package web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="reentry",urlPatterns="/reentry")
public class ReEntryServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html;charset=Windows-31J");

		HttpSession session = req.getSession(false);
		if (session != null) {
		session.invalidate();
		}

		//ログインページへ遷移
		RequestDispatcher rd = req.getRequestDispatcher("jsp/EntryJsp.jsp");
		rd.forward(req, resp);



		}

}