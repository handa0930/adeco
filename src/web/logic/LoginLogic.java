package web.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginLogic {

	private UserBean user = new UserBean();

	public Boolean isLogin(String name, String pass) {

		boolean flag = false;
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite?autoReconnect=true&useSSL=false";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// ログインコード・パス
			rs = st.executeQuery("SELECT * FROM user;");

			while (rs.next()) {
				int sID = rs.getInt(1);
				String sName = rs.getString(2);
				String sCode = rs.getString(3);
				String sPass = rs.getString(4);
				if (sName.equals(name) && sPass.equals(pass)) {
					flag = true;
					user.setUserID(sID);
					user.setUserName(sName);
					user.setUserCode(sCode);
					user.setLoginPassword(sPass);
					break;
				}
			}
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

	public UserBean getUser() {
		return user;
	}

	// 作成者 上田
	// カテゴリー名を取得
	public ArrayList<String> getCategoryList() {
		ArrayList<String> categoryList = new ArrayList<String>();
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite?autoReconnect=true&useSSL=false";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// SQL文の指定
			rs = st.executeQuery("SELECT cat_name FROM category;");

			while (rs.next()) {
				categoryList.add(rs.getString("cat_name"));
			}
			return categoryList;
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

		return categoryList;

	}

}
