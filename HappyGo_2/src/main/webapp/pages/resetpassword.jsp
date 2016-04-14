<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="" />

<title>Forget Password</title>
</head>
<body>

<h3>會員中心...(您的臨時密碼已寄到您的信箱, 請使用臨時密碼登入更新密碼設定)</h3>

<form action="<c:url value="/secure/login.controller" />" method="get">
<table>
	<%-- <tr>
		<td>會員帳號: </td>
		<td><input type="text" name="MBR_MEMBERID" value="${param.MBR_MEMBERID}"></td>
		<td>${error.MBR_MEMBERID}</td>
	</tr>
	<tr>
		<td>電子郵件帳號: </td>
		<td><input type="text" name="MBR_EMAIL" value="${param.MBR_EMAIL}"></td>
		<td>${error.MBR_EMAIL}</td>
	</tr> --%>
	
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr><td/>
		<!-- <td align="left"><input type="submit" name="loginOrCreate" value="使用(會員帳號/電子郵件)查詢"></td> -->		
		<td align="left"><input type="submit" name="loginOrCreate" value="回會員中心首頁"></td>	

	</tr>
</table>
</form>

</body>
</html>