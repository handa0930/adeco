package web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.logic.CartItemBean;
import web.logic.CartLogic;

/* 作成者　上田 */
@WebServlet(name = "cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");
		// 送信されてくるパラメータを変数に格納
		String name = req.getParameter("ItemName");
		int price = Integer.parseInt(req.getParameter("ItemPrice"));
		int order = Integer.parseInt(req.getParameter("order"));

		// セッションの継続
		HttpSession session = req.getSession(false);
		if (session != null) {
		} else {
		}

		// ロジックの生成
		CartLogic logic = new CartLogic((ArrayList<CartItemBean>)session.getAttribute("CartList"));
		// カートに商品を入れる
		logic.addCart(name, price, order);
		// 消費税計算
		long tax = logic.taxCalc();
		// 消費税込みの合計金額を計算
		long sumTax = logic.sumCalc() + tax;

		// セッションオブジェクトに消費税と税込み金額を格納
		session.setAttribute("tax", tax);
		session.setAttribute("sumTax", sumTax);

		// カート画面に遷移
		RequestDispatcher rd = req.getRequestDispatcher("jsp/CartJsp.jsp");
		rd.forward(req, resp);

	}

}
