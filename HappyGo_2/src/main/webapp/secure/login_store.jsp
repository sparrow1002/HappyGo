<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>特約商店登入</title>
<link rel="stylesheet" href="css/main.css">
<link rel="Shortcut Icon" type="image/x-icon" href="/HappyGo_2/images/happGo.ico" />
</head>
<body>
	<img id="sky" src="/HappyGo_2/images/bg_00.png" />
	<img id="ground" src="/HappyGo_2/images/bg_01.png">
	<img id="cloud01" src="/HappyGo_2/images/cloud_01.png">
	<img id="cloud02" src="/HappyGo_2/images/cloud_02.png">
	<img id="cloud03" src="/HappyGo_2/images/cloud_03.png">
	<img id="cloud04" src="/HappyGo_2/images/cloud_04.png">
	<div id="allpage">
		<c:import url="/common/TopMeau.jsp" />
		<div id="content" class="demo" style="width: 946px">
			<form action="<c:url value="/secure/login_store.controller" />"
				method="get">
				<table class="t2" style="background-color: #F0E68C;">
					<tr>
						<th colspan='2' bgcolor='#d4edec'><label>特店登入</label></th>
					</tr>
					<tr>
						<td bgcolor='#bce6e4' align="right">特約商店帳號</td>
						<td bgcolor='#85d6d2'><input type="text" name="username"
							value="${param.username}">${error.username}</td>
					</tr>
					<tr>
						<td bgcolor='#bce6e4' align="right">特約商店密碼</td>
						<td bgcolor='#85d6d2'><input type="password" name="password"
							value="${param.password}">${error.password}</td>
					</tr>
					<tr>
						<td colspan='2' bgcolor='#d4edec' align="center"><input
							type="submit" value="登入"> <input type=button
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
<script src="js/jquery.cycle2.js"></script>
<link rel="stylesheet" href="base/jquery-ui-1.9.2.custom.min.css">
</html>
