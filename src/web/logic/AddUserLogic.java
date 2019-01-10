package web.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddUserLogic {

	public Boolean idAdd(String name, String pass, String rePass) {
		Boolean flag = false;

		// 入力されたパスワードと確認用再入力パスワードが同じでなければ偽を返す
		if (!pass.equals(rePass)) {
			return flag;
		}

		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite?autoReconnect=true&useSSL=false";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement pst = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// select文
			rs = st.executeQuery("SELECT * FROM user;");
			int count = 1;
			ArrayList<UserBean> users = new ArrayList<UserBean>();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUserName(rs.getString(2));
				users.add(user);
				count++;
			}
			for (UserBean u : users) {
				if (u.getUserName().equals(name)) {
					return flag;
				}
			}


			// userテーブルのパスワードを更新する
			String query = "INSERT INTO user VALUES(?,?,?,?);";
			pst = cnct.prepareStatement(query);
			pst.setInt(1, count);
			pst.setString(2, name);
			pst.setString(3, name);
			pst.setString(4, pass);
			pst.executeUpdate();
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
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}

		return flag;
	}

}
