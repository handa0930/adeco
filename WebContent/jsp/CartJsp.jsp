<%-- 作成者　上田 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page
	import="java.text.NumberFormat,java.util.ArrayList,web.logic.CartItemBean"%>
<%-- 関数の定義 --%>
<script type="text/javascript">
	function backButton() {
		location.href = "jsp/SearchJsp.jsp"
	}
</script>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/button.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/table.css">
<meta content="text/html; charset=UTF-8">
<title>カート</title>
</head>
<body>
<%@ include file = "HelloJsp.jsp" %>
<p class = "bana">
<span class = "midashi">-Adecco-market-</span>
</p>
<div class="top">
	<h1>カート</h1>
	<table class = "table" align="center" cellspacing="3" cellpadding="10" width="500">
		<tr>
			<td class = "Tmidashi">商品名</td>
			<td class = "Tmidashi">単価</td>
			<td class = "Tmidashi">数量</td>
		</tr>
		<%
			// 通貨形式で表示
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();
		%>
		<%-- カートの中身を表示する --%>
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
			<td class = "Tmidashi" colspan="2">消費税</td>
			<td class = "Tcell"><%=nfCur.format(session.getAttribute("tax"))%></td>
		</tr>
		<tr>
			<td class = "Tmidashi" colspan="2">合計金額</td>
			<td class = "Tcell"><%=nfCur.format(session.getAttribute("sumTax"))%></td>
		</tr>
	</table>
	<button type="button" onclick="backButton()">買い物を続ける</button>
	<form action="http://localhost:8080/ECSite/bought" method="post">
		<input type="submit" value="購入">
	</form>
</div>
</body>
</html>