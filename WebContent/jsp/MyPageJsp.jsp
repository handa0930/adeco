<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="web.logic.UserBean"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/button.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/title.css">
<meta content="text/html; charset=UTF-8">
<title>マイページ</title>
</head>
<body>
<%
	UserBean user = (UserBean) session.getAttribute("user");
%>
<p class = "bana">
<span class = "midashi">-Adecco-market-</span>
</p>


	<table align = "center">
		<tr>
		<td>
		<h1><nobr><%=user.getUserName()%>さんのマイページ</h1>
		</td>
		</tr>
	<br>
	<br>
	<br>
	<form action="http://localhost:8080/ECSite/changepass" method="POST">
		<table align = "center">
			<tr>
				<td colspan="2"  class="plate" id="backer" align = "center"><h2>パスワードの変更</h2></td>

			</tr>
			<tr>
				<td colspan="2">
				　
				</td>
			</tr>
			<tr>
				<td>現在のパスワードを入力してください
				</td>
				<td>
				<input type="password" name="oldpass">
				</td>

			</tr>
			<tr>
				<td>新しいパスワードを入力してください
				</td>
				<td>
				<input type="password" name="newpass">
				</td>

			</tr>
						<tr>
				<td>確認のためもう一度新しいパスワードを入力してください
				</td>
				<td>
				<input type="password" name="renewpass">
				</td>

			</tr>
			<tr>
			<td  colspan="2" align="center">
				<input type="submit" value="決定">
			</td>
		</table>
	</form>
	<br>
	<br>
	<table align = "center">
	<tr><td>
	<form action="http://localhost:8080/ECSite/jsp/SearchJsp.jsp" method="post">
	<input type="submit" value="商品検索画面">
</form>
	</td>
	<td>
	<form action="http://localhost:8080/ECSite/reentry" method="post">
	<input type="submit" value="ログアウト">
</form>
	</td>
	</tr>
	</table>

</body>
</html>