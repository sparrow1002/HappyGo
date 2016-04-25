<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MENU</title>
</head>

<body>
	<div align="center">
		<nav>
		<ul id="mainmenu">
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li> <a
				href='<c:url value="/dayuNameSpace/cardinfolist.action?mode=select"/>'>HappyGO說明</a></li>
			<li><a href='<c:url value="/secure/login_cus.jsp"/>'>會員登入</a></li>
			<li><a href='<c:url value="/conStore/login.jsp"/>'>特約商店登入</a></li>
			<li><a href='<c:url value="/dayuNameSpace/weblogin.action"/>'>系統人員登入</a></li>
			<li><a href='<c:url value="/index.jsp"/>'>首頁</a></li>
		</ul>
		</nav>
	</div>
	<div>
		<table style="background-color: #F75000; width: 946px" id="maintable">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
</body>
<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
<script src="<c:url value='/jquery/jquery-2.1.4.min.js'/>"></script>
<script src="<c:url value='/jquery/jquery-ui.min.js'/>"></script>
<link rel="stylesheet"	href="<c:url value='/jquery/base/jquery-ui-1.9.2.custom.min.css'/>">
</html>