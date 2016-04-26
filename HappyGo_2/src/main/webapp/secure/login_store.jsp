<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>特約商店登入</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<div id="allpage">
		<c:import url="/common/TopMeau.jsp" />
		<div class="demo" style="width: 946px">
			<form action="<c:url value="/secure/login_store.controller" />"
				method="get">
				<table class="t2" style="background-color: #F0E68C;">
					<tr>
						<th colspan='2'><label>特店登入</label></th>
					</tr>
					<tr>
						<td align="right">特約商店帳號</td>
						<td><input type="text" name="username"
							value="${param.username}"></td>
						<td>${error.username}</td>
					</tr>
					<tr>
						<td align="right">特約商店密碼</td>
						<td><input type="text" name="password"
							value="${param.password}"></td>
						<td>${error.password}</td>
					</tr>
					<tr>
						<td colspan='2' align="center"><input type="submit"
							value="登入"> <input type=button
							onClick="location.href='<c:url value="/conStore/register.jsp"/>'"
							value='申請特約商店'> <input value="回首頁"
							onclick="window.location='../index.jsp'" type="button"></td>
					</tr>
				</table>
			</form>
		</div>
		<c:import url="/common/FootBar.jsp" />
	</div>
</body>
</html>