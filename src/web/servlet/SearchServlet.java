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
			session.setAttribute("Item", logic.getItemList());
			RequestDispatcher rd = req.getRequestDispatcher("jsp/SearchResultJsp.jsp");
			rd.forward(req, resp);

			return;
		} else {
			/*
			 * 検索結果が無かった場合、検索結果0件のページに遷移する
			 */
			RequestDispatcher rd = req.getRequestDispatcher("jsp/NotItemSearchJsp.jsp");
			rd.forward(req, resp);
			return;
		}

	}

}
