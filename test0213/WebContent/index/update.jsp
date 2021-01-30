<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/com/update" method="post">
	<table align="center">
		<tr>
			<td>
			<input type="text" name="name"/>
			</td>
			<td>
			請輸入帳號
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="idcard"/>
			</td>
			<td>
			請輸入身分證
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit" value="確定"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>