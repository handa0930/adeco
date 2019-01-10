package web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.logic.ChangePasswordLogic;
import web.logic.UserBean;

@WebServlet(name = "changepass", urlPatterns = "/changepass")
public class ChangePasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");
		// 送信されてくるデータの格納
		String oldPass = req.getParameter("oldpass");// 現在のパスワード
		String newPass = req.getParameter("newpass");// 新しいパスワード
		String ReNewPass = req.getParameter("renewpass");// 新しいパスワード確認用
		// パスワードの変更が正常に終わったか
		Boolean isChange = false;

		// セッションの継続
		HttpSession session = req.getSession(false);
		if (session != null) {
		} else {
		}

		// ロジックの生成
		ChangePasswordLogic logic = new ChangePasswordLogic((UserBean) session.getAttribute("user"));
		// パスワードの変更
		isChange = logic.Change(oldPass, newPass, ReNewPass);

		if (isChange) {
			// パスワードの変更成功
			req.setAttribute("result", "パスワードを変更しました。");

		} else {
			// パスワードの変更失敗
			req.setAttribute("result", "入力されたパスワードが違います");

		}

		// マイページに戻る
		RequestDispatcher rd = req.getRequestDispatcher("jsp/PassChangeResultJsp.jsp");
		rd.forward(req, resp);

	}

}
