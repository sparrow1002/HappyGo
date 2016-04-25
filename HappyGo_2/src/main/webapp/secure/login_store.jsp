<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>特約商店登入</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<div>
		<form action="<c:url value="/secure/login_store.controller" />" method="get">
			<table>
				<tr>
					<th colspan='2'  bgcolor='#d4edec'><label>特店登入</label></th>
				</tr>
				<tr>
					<td bgcolor='#bce6e4' align="right">特約商店帳號</td>
					<td bgcolor='#85d6d2'><input type="text" name="username" value="${param.username}"></td>
					<td>${error.username}</td>
				</tr>
				<tr>
					<td bgcolor='#bce6e4' align="right">特約商店密碼</td>
					<td bgcolor='#85d6d2'><input type="text" name="password" value="${param.password}"></td>
					<td>${error.password}</td>
				</tr>
				<tr>
					<td colspan='2' bgcolor='#d4edec' align="center">
						<input type="submit" value="登入">
						<input type=button onClick="location.href='<c:url value="/conStore/register.jsp"/>'" value='申請特約商店'>
						<input value="回首頁" onclick="window.location='../index.jsp'" type="button">
					</td>					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>