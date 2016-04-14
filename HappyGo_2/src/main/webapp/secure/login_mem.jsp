<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="" />

<title>Login</title>
</head>
<body>

<h3>會員中心...(會員登入)</h3>

<form action="<c:url value="/secure/login.controller" />" method="get">
<table>
	<tr>
		<td>會員帳號: </td>
		<td><input type="text" name="MBR_MEMBERID" value="${param.MBR_MEMBERID}"></td>
		<td>${error.MBR_MEMBERID}</td>
	</tr>
	<tr>
		<td>密碼: </td>
		<td><input type="text" name="MBR_PWD" value="${param.MBR_PWD}"></td>
		<td>${error.MBR_PWD}</td>
	</tr>
	
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td align="left"><input type="submit" name="loginOrCreate" value="註冊帳號"></td>		
		<td align="middle"><input type="submit" name="loginOrCreate" value="會員登入"></td>
		<td align="left"><input type="submit" name="loginOrCreate" value="忘記密碼"></td>
		<!-- <td align="left"><input type="submit" name="loginOrCreate" value="登出"></td> -->

	</tr>
</table>
</form>

</body>
</html>