<%--作成者　上田 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/button.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/title.css">
<meta content="text/html; charset=UTF-8">
<title>EC Site</title>
</head>

<body>
<p class = "bana">
<span class = "midashi">-Adecco-market-</span>
</p>
<hr>
<br>
<form>
<table align = "center">
	<tr>
		<td><a class = "tag"><b>★ 今 週 の 人 気 商 品 ★</b></a></td>
	</tr>
</table>
<table align = "center">

	<tr>
		<td><h1>バケットホイールエクスカベーター</h1></td>
	</tr>
	<tr>
		<td>
			<img src="http://localhost:8080/ECSite/img/bucket.jpg">
		</td>
	</tr>
</table>
</form>
<br>
<hr>
	<div class="top">
		<h2 class="platepink" id="back"><span>ログイン</span></h2>
		<form action="http://localhost:8080/ECSite/login" method="post">
			<table align = "center">
				<tr>
					<td>名前</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="pass"></td>
				</tr>
			</table>
			<input type="submit" value="Log in" class="blue2button">
		</form>
	</div>
</body>
</html>