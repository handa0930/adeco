package web.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchLogic {

	private ArrayList<ItemBean> itemList = new ArrayList<ItemBean>();

	public Boolean isItem(String search, String category) {

		boolean flag = false;
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite?autoReconnect=true&useSSL=false";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		String mSearch = search;
		if (mSearch.equals("") || mSearch == null) {
			mSearch = "hogehoge";
		}

		String mCategory = category;
		if (mCategory.equals("") || mCategory == null) {
			mCategory = "hogehoge";
		}

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			String query = "SELECT * FROM product INNER JOIN category ON product.cat_id = category.cat_id WHERE (product.pro_name LIKE '%"
					+ mSearch + "%') OR (category.cat_name = '" + mCategory + "');";
			System.out.println(query);
			rs = st.executeQuery(query);
			if (!rs.next()) {
				return flag;
			}

			do {
				ItemBean item = new ItemBean();

				String sName = rs.getString("product.pro_name");
				item.setName(sName);

				int sStock = rs.getInt("product.stock_no");
				item.setStock(sStock);

				int sPrice = rs.getInt("product.pro_price");
				item.setPrice(sPrice);

				String sCategory = rs.getString("product.cat_id");
				item.setCategory(sCategory);

				String sImg = rs.getString("product.pro_img");
				item.setImg(sImg);

				String sMsg = rs.getString("product.pro_msg");
				item.setMsg(sMsg);

				itemList.add(item);

			} while (rs.next());
			flag = true;
			return flag;

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return flag;

	}

	/**
	 * @return itemList
	 */
	public ArrayList<ItemBean> getItemList() {
		return itemList;
	}

}
