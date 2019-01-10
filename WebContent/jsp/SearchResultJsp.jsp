<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import ="java.lang.*,java.text.NumberFormat,web.logic.ItemBean" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/entrytop.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/ECSite/css/button.css">
<script type="text/javascript">
function btnLink(i){
	var url = "jsp/ItemDetailsJsp.jsp?itemNum="+i;
	location.href=url;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="SearchJsp.jsp" %>

<!-- 以下検索結果 -->

<div class = "second">
		<table class = "shohin" border="1" cellspacing="0" cellpadding="8">
			<tr>
			<td>画像</td>
			  <td >商品名</td>
			  <td>価格</td>
			  <td>詳細</td>
			</tr>
			<%ArrayList<ItemBean> itemList = (ArrayList<ItemBean>)session.getAttribute("Item"); %>
			<%
			// 商品位置格納用リスト
			ArrayList<Integer> numList = new ArrayList<Integer>();
			%>

			<% for(int i = 0;i<itemList.size();i++){ %>
			<tr>
			<td>
			<!-- イメージ -->
			<img src=<%=itemList.get(i).getImg()%> width="100" height="auto" ></td>
			<!-- 商品名 -->
			  <td nowrap>
			  <%=itemList.get(i).getName() %>
			  </td>
			<!-- 価格 -->
			  <td>
				<%
				// 通貨形式で表示
					NumberFormat nfCur = NumberFormat.getCurrencyInstance();
				%>
			  <%=nfCur.format(itemList.get(i).getPrice()) %>
			  </td>
			<!-- 詳細 -->
			  <td>
			  <button type="button" onclick ="btnLink(<%=i%>)">詳細</button>

			  </td>
			</tr>
			<% } %>
		</table>
</div>


</body>
</html>