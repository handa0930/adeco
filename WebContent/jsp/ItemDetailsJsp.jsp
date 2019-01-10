<%--　作成者　上田 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--使用するクラスのインポート --%>
<%@page
	import="java.lang.*,java.text.NumberFormat,web.logic.CartItemBean,web.logic.ItemBean,java.util.ArrayList"%>
<%-- 関数の定義 --%>
<script type="text/javascript">
	function backButton() {
		location.href = "SearchJsp.jsp"
	}
</script>
<html>
<head>
<%--スタイルシートの定義 --%>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/button.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/table.css">
<meta content="text/html; charset=UTF-8">
<title>商品紹介</title>
</head>
<body>
<%@ include file = "HelloJsp.jsp" %>
<p class = "bana">
<span class = "midashi">-Adecco-market-</span>
</p>
	<%
		// セッションオブジェクトから商品リストとカート内の商品を取得
		ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) session.getAttribute("Item");
		ArrayList<CartItemBean> cartList = (ArrayList<CartItemBean>) session.getAttribute("CartList");
	%>
	<%-- リスト内から商品を取得--%>
	<%
		ItemBean mItem = itemList.get(Integer.parseInt(request.getParameter("itemNum")));
	%>
	<h1 align = "center">商品紹介</h1>
<div class = "second">
	<%--画像の表示 --%>
	<img src=<%=mItem.getImg()%>>

	<form action="http://localhost:8080/ECSite/cart" method="post">
		<table class = "table" align="center" cellspacing="3" cellpadding="10" width="500">
			<tr>
				<td class = "Tmidashi">商品名</td>
				<td class = "Tcell"><%=mItem.getName()%></td>
				<input type="hidden" name="ItemName" value=<%=mItem.getName()%>>
			</tr>
			<tr>
				<td class = "Tmidashi">カテゴリ</td>
				<td class = "Tcell"><%=mItem.getCategory()%></td>
			</tr>
			<tr>
				<td class = "Tmidashi">価格</td>
				<%
				// 通貨形式で表示
					NumberFormat nfCur = NumberFormat.getCurrencyInstance();
				%>
				<td class = "Tcell"><%=nfCur.format(mItem.getPrice())%></td>
				<input type="hidden" name="ItemPrice" value=<%=mItem.getPrice()%>>
			</tr>
			<tr>
				<td class = "Tmidashi">在庫</td>
				<%-- 在庫処理 --%>
				<%
					int stock = mItem.getStock();
					// カート内に選択された商品が存在するか

					for (CartItemBean cart : cartList) {
						if (mItem.getName().equals(cart.getName())) {
							stock -= cart.getNum();
						}
					}
				%>
				<td class = "Tcell"><%=stock%></td>
			</tr>
			<tr>
				<td class = "Tmidashi">商品紹介</td>
				<td class = "Tcell"><%=mItem.getMsg()%></td>
			</tr>
		</table>
		<%
			if (stock > 0) {
		%>
		個数 <select name="order">
			<%
				for (int i = 1; i <= stock; i++) {
					if(i>100){
						break;
					}
			%>
			<option value=<%=i%>><%=i%></option>
			<%
				}
			%>
		</select> <input type="submit" value="カートへ">
		<%
			} else {
		%>
		売り切れです
		<%
			}
		%>
	</form>
	<button type="button" onclick="backButton()">戻る</button>

</div>
</body>
</html>