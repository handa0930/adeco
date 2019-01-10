package web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.logic.AddUserLogic;

@WebServlet(name = "adduser", urlPatterns = "/adduser")
public class AddUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");
		// 送信されてくるデータの格納
		String addName = req.getParameter("addname");// 名前
		String addPass = req.getParameter("addpass");// パスワード
		String reAddPass = req.getParameter("addrepass");// パスワード確認用
		// 会員登録が正常に終わったか
		Boolean isAdd = false;

		AddUserLogic logic = new AddUserLogic();
		isAdd = logic.idAdd(addName, addPass, reAddPass);

		if (isAdd) {
			RequestDispatcher rd = req.getRequestDispatcher("jsp/AddUserResult.jsp");
			rd.forward(req, resp);
			return;

		} else {
			RequestDispatcher rd = req.getRequestDispatcher("jsp/AddError.jsp");
			rd.forward(req, resp);
			return;
		}

	}

}
