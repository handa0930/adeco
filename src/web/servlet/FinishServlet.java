package web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.logic.CartItemBean;
import web.logic.UserBean;

@WebServlet(name = "finish", urlPatterns = "/finish")
public class FinishServlet extends HttpServlet {

	private ArrayList<CartItemBean> itemList = new ArrayList<CartItemBean>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, Integer> map = new HashMap<String, Integer>();

		// 送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");

		// セッションの継続
		HttpSession session = req.getSession(false);
		if (session != null) {
		} else {
		}
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite?autoReconnect=true&useSSL=false";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();

			// 商品テーブルの情報を取得
			rs = st.executeQuery("SELECT * FROM product;");
			while (rs.next()) {
				// ハッシュマップに名前をキー、在庫を値として登録する
				map.put(rs.getString("pro_name"), rs.getInt("stock_no"));
			}

			// プリコンパイル文
			String query = "UPDATE product SET stock_no = ? WHERE pro_name = ?;";
			pst = cnct.prepareStatement(query);

			ArrayList<CartItemBean> mList = (ArrayList<CartItemBean>) session.getAttribute("CartList");

			// カートのリスト内から商品テーブルに一致する商品の在庫を減らしてDBに登録
			for (CartItemBean item : mList) {
				int temp = map.get(item.getName()) - item.getNum();
				pst.setInt(1, temp);
				pst.setString(2, item.getName());
				pst.executeUpdate();
			}
			// 明細テーブルと購入テーブルに情報の登録
			// 明細テーブルの情報を取得
			rs = st.executeQuery("SELECT mei_id from meisai");
			int meiId = 1;
			if (rs.next()) {
				do {
					meiId = rs.getInt("mei_id") + 1;
				} while (rs.next());
			}

			// 明細テーブルに登録
			// プリコンパイル文
			query = "INSERT INTO meisai VALUES(?,?,now(),?);";
			pst = cnct.prepareStatement(query);
			pst.setInt(1, meiId);
			UserBean user = (UserBean) session.getAttribute("user");
			int userID = user.getUserID();
			pst.setInt(2, userID);
			pst.setLong(3, (long)session.getAttribute("sumTax"));
			pst.executeUpdate();

			for (CartItemBean item : mList) {
				// 購入テーブルに登録
				// プリコンパイル文
				query = "INSERT INTO purchase VALUES(" + meiId + ",?," + item.getNum() + ");";
				pst = cnct.prepareStatement(query);

				rs = st.executeQuery("SELECT pro_cd from product WHERE pro_name = '" + item.getName() + "';");
				rs.next();
				int proCd = rs.getInt("pro_cd");
				pst.setInt(1, proCd);

				pst.executeUpdate();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}

		// カート画面に遷移
		RequestDispatcher rd = req.getRequestDispatcher("jsp/FinishJsp.jsp");
		rd.forward(req, resp);

	}

}
