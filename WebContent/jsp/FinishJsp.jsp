<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/button.css">
<meta content="text/html; charset=UTF-8">
<title>お買い上げありがとうございました</title>
</head>
<body>
<p class = "bana">
<span class = "midashi">-Adecco-market-</span>
</p>
	<div class ="second">
		<h1>お買い上げありがとうございました！</h1>
					<img src="http://localhost:8080/ECSite/img/byebye.jpg">
		<% /* ReEntryservletへ */ %>
		<form action="http://localhost:8080/ECSite/reentry" method="post">
			<table>
				<tr>

				<input type="submit" value="ログアウト">

				</tr>
			</table>
		</form>
	</div>
</body>
</html>