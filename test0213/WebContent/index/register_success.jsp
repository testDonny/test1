<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊成功的頁面</title>
<style type="text/css">
h1{text-align:conter;}
h4{text-align:right;color:red;}
</style>
</head>
<body>
<hr/>
<h1>恭喜! 用戶${info}註冊成功</h1><br>
<a href="${pageContext.request.contextPath}/login.jsp" target="_blank">馬上去登入</a>
</body>
</html>