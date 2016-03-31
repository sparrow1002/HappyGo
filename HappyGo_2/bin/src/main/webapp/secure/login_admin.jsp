<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>內部管理登入</title>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
	<div>
		<!-- <form action="mag_1.jsp" method="get"> -->
		<form action="<c:url value="/dayuNameSpace/weblogin.controller" />"  method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>內部管理登入</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">使用者帳號</TD>
					<TD bgcolor='#85d6d2'><input type="text"  id="username"  name="username" value=${param.username}	></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">使用者密碼</TD>
					<TD bgcolor='#85d6d2'><input type="text"  id="password"  name="password" value=${param.password}	></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<input	type="submit" value="登入" />
						 <input value="回首頁"	onclick="window.location='../index.jsp'" type="button"></TD>
				</TR>
			</TABLE>
		</form>
	</div>
</body>
</html>