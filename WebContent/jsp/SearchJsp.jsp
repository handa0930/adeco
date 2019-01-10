<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/button.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/title.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>

<%@ include file = "HelloJsp.jsp" %>

<p class = "bana">
<span class = "midashi">-Adecco-market-</span>
</p>
	<% ArrayList<String> list = (ArrayList<String>)session.getAttribute("catgoryList"); %>

	<div class = "top">
	<h1 class="plate" id="backer" align = "center">
  	<span>商 品 を 検 索</span>
	</h1>
	</div>
<div class = "second">
		<form action="http://localhost:8080/ECSite/search" method="POST">
			<p>カテゴリ：
				<select name="category" class = "cp_ipcheck">
				<option value=""></option>
					<% for(String s : list){ %>
		  			<option value="<%= s %>"><%= s %></option>
					<% } %>
				</select>
			</p>
			<p class="cp_iptxt">
			<label class="ef">
			<input type="text" name="search">

			</label>
			</p>
			<input type="submit" value="検索する" class="bluebutton">

		</form>
	</div>

</body>
</html>