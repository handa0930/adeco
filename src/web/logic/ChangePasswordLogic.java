package web.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePasswordLogic {
	UserBean user;

	// コンストラクタ
	public ChangePasswordLogic(UserBean user) {
		this.user = user;
	}

	// パスワードの変更を判定する
	public Boolean Change(String oldPass, String newPass, String reNewPass) {

		// パスワード変更が正常に終わったか
		boolean flag = false;

		// 入力されたパスワードが正しくなければ偽を返す
		if (!user.getLoginPassword().equals(oldPass)) {
			return flag;
		}
		// 新しいパスワードと確認用再入力パスワードが同じでなければ偽を返す
		if (!newPass.equals(reNewPass)) {
			return flag;
		}

		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite?autoReconnect=true&useSSL=false";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		// DBに接続
		try {
			System.out.println(user.getLoginPassword());
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			// userテーブルのパスワードを更新する
			String query = "UPDATE user SET login_pw = ? WHERE user_id = ?;";
			pst = cnct.prepareStatement(query);
			pst.setString(1, newPass);
			pst.setInt(2, user.getUserID());
			pst.executeUpdate();
			flag = true;
			user.setLoginPassword(newPass);
			System.out.println(user.getLoginPassword());
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
