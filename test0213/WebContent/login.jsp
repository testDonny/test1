<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{color:red;}
</style>
</head>
<body><center>
<h1>歡迎您</h1>
	<form action="${pageContext.request.contextPath}/com/userlogin" method="post">
	<table>
		<tr>
		<td>帳號</td>
		<td><input  id="name" name="name" type="text"></td>
		</tr>
		<tr>
		<td>密碼</td>
		<td><input id="password" name="password" type="password"><input type="checkbox" name="autologin">保持登入狀態</td>
		</tr>
		<tr>
		<td colspan="1">
		</td>
		<td>
		<input type="submit" value="登入">
			<input type="reset" value="從置">
			<a href="${pageContext.request.contextPath}/register.jsp" target="_blank" >註冊</a>
			<a href="${pageContext.request.contextPath}/index/update.jsp"  target="_blank">忘記密碼</a>
		</td>
		</tr>
	</table>
	</center>

</body>
</html>