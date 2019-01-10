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

@WebServlet(name = "bought", urlPatterns = "/bought")
public class BoughtServlet extends HttpServlet {

	private ArrayList<CartItemBean> CartList = new ArrayList<CartItemBean>();

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	// 送信されてくるパラメータのエンコーディング指定
	req.setCharacterEncoding("UTF-8");

	// CartJspからパラメータを取得
	String cartlist = req.getParameter("CartList");

	// セッションの継続
	HttpSession session = req.getSession(false);
	if (session != null) {
	} else {
	}

	RequestDispatcher rd = req.getRequestDispatcher("jsp/BoughtJsp.jsp");
	rd.forward(req, resp);


}

}
