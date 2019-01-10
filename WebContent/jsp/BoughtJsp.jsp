<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page
	import="java.text.NumberFormat,java.util.ArrayList,web.logic.CartItemBean"%>

<html>

<head>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/button.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/table.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>購入確認画面</title>

</head>

<body>
<%@ include file = "HelloJsp.jsp" %>
<p class = "bana">
<span class = "midashi">-Adecco-market-</span>
</p>
	<div>

		<h1>購入してよろしいですか？</h1>

		<table class = "table" align="center" cellspacing="3" cellpadding="10" width="500">

			<%-- 見出し --%>
			<tr>
				<th class = "Tmidashi">商品名</th>
				<th class = "Tmidashi">単価</th>
				<th class = "Tmidashi">数量</th>
			</tr>

			<%-- 内容 --%>

			<%
				// 通貨形式で表示
				NumberFormat nfCur = NumberFormat.getCurrencyInstance();
			%>

			<%
				ArrayList<CartItemBean> itemList = (ArrayList<CartItemBean>) session.getAttribute("CartList");

				for (CartItemBean item : itemList) {
			%>

			<tr>
				<%-- 商品名 --%>
				<td class = "Tcell"><%=item.getName()%></td>
				<%-- 単価 --%>
				<td class = "Tcell"><%=nfCur.format(item.getPrice())%></td>
				<%-- 数量 --%>
				<td class = "Tcell"><%=item.getNum()%></td>
			</tr>
			<%
				}
			%>
			<tr>
				<th colspan="2" class = "Tmidashi">消費税</th>
				<td class = "Tcell"><%=nfCur.format(session.getAttribute("tax"))%></td>
			</tr>
			<tr>
				<th colspan="2" class = "Tmidashi">合計金額</th>
				<td class = "Tcell"><%=nfCur.format(session.getAttribute("sumTax"))%></td>
			</tr>

		</table>

		<table align="center" width="100" cellspacing="0" cellpadding="5">
			<tr>
				<td><form
						action="http://localhost:8080/ECSite/jsp/SearchJsp.jsp"
						method="POST">
						<input type="submit" value="いいえ">
					</form></td>
				<td>
					<form action="http://localhost:8080/ECSite/finish"
						method="POST">
						<input type="submit" value="はい">
					</form>
				</td>
			</tr>
		</table>

	</div>
</body>
</html>