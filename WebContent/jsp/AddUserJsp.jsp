<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/ECSite/css/button.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/ECSite/css/title.css">
<meta content="text/html; charset=UTF-8">
<title>新規会員登録</title>
</head>
<body>
	<p class="bana">
		<span class="midashi">-Adecco-market-</span>
	</p>
	<form action="http://localhost:8080/ECSite/adduser" method="POST">
		<table align = "center">
			<tr>
				<td colspan="2"  class="plate" id="backer" align = "center"><h2>新規会員登録</h2></td>

			</tr>
			<tr>
				<td colspan="2">
				　
				</td>
			</tr>
			<tr>
				<td>名前を入力してください</td>
				<td><input type="text" name="addname"></td>
			</tr>
			<tr>
				<td>パスワードを入力してください</td>
				<td><input type="password" name="addpass"></td>
			</tr>
			<tr>
				<td>パスワードを入力してください</td>
				<td><input type="password" name="addrepass"></td>
			</tr>
			<tr>
			<td  colspan="2" align="center">
		<input type="submit" value="決定">
			</td></tr>
		</table>
	</form>


	<form action="http://localhost:8080/ECSite/jsp/EntryJsp.jsp"
		method="post">
			<table align = "center">
		<tr><td>
		<input type="submit" value="ログイン画面に戻る">
		</td></tr>
		</table>
	</form>

</body>
</html>