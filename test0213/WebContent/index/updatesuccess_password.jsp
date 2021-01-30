<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body{text-align:center}
</style>
<title>Insert title here</title>
</head>	
<body>			   										
	<form action="${pageContext.request.contextPath}/com/updeteequals" method="psot">
		<input type="password" name="password"/>請輸入新的密碼<br>
		<input type="submit" value="確定"/>
		</form>
</body>
</html>