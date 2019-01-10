<%--作成者　上田 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="web.logic.UserBean"%>
<%
	UserBean user = (UserBean) session.getAttribute("user");
%>

<table align="right">
	<tr>
		<td>ようこそ <%=user.getUserName()%>さん
		</td>
		<td>
			<form action="http://localhost:8080/ECSite/jsp/MyPageJsp.jsp"
				method="post">
				<input type="submit" value="マイページ">
			</form>
		</td>
		<td>
			<form action="http://localhost:8080/ECSite/reentry" method="post">
				<input type="submit" value="ログアウト">
			</form>
		</td>
	</tr>
</table>
<br><br>