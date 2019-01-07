<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList" %>
<html>
<head>
<style>

div {
	padding: 10px;
	text-align: center;
	text-align: center;
	margin: 30px auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>

	<% ArrayList<String> list = (ArrayList<String>)request.getAttribute("catgoryList"); %>
	<div>
	<h1>検索</h1>
		<form action="http://localhost:8080/ECSite/search" method="POST">
			<input type="text" name="search" size="55%">
				<br>
				<br>
					<p>カテゴリ
					<select name="category">
					<option value=""></option>
						<% for(String s : list){ %>
		  				<option value="<%= s %>"><%= s %></option>
					<% } %>
						</select>
					</p>
			<input type="submit" value="検索">
		</form>
	</div>

</body>
</html>