package web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.logic.SearchLogic;

/* 作成者　上田 */
@WebServlet(name = "search", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");
		// 送信されてくるパラメータの取得（文字列)
		String search = req.getParameter("search");// 検索キーワード
		String category = req.getParameter("category");// 検索カテゴリ
		// セッションの継続
		HttpSession session = req.getSession(false);
		if (session != null) {
		} else {
		}

		// 検索ロジックのオブジェクトを生成
		SearchLogic logic = new SearchLogic();
		// 検索の実行
		if (logic.isItem(search, category)) {
			/*
			 * 検索結果があった場合 検索された商品をID:Itemとしてリクエストオブジェクトに格納する その後検索結果表示ページに遷移する
			 */
			System.out.println("aa1");
			req.setAttribute("Item", logic.getItemList());
			System.out.println("aa2");
			System.out.println(logic.getItemList().get(0).getName());

			RequestDispatcher rd = req.getRequestDispatcher("jsp/SearchResultJsp.jsp");
			System.out.println(rd);
			System.out.println("aa3");

			System.out.println(req);
			System.out.println("----------------------");
			System.out.println(resp);
			System.out.println("----------------------");
			rd.forward(req, resp);
			System.out.println("aa4");

			return;
		} else {
			/*
			 * 検索結果が無かった場合、検索結果0件のページに遷移する
			 */
			System.out.println("bb1");
			RequestDispatcher rd = req.getRequestDispatcher("jsp/NotItemSearchJsp.jsp");
			System.out.println(rd);
			System.out.println("bb2");
			rd.forward(req, resp);
			System.out.println("bb3");
			return;
		}

	}

}
