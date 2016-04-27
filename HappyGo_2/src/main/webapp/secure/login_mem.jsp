<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
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
		<div class="demo" style="width: 946px">
			<form action="<c:url value="/secure/login.controller" />"	method="get">
				<table class="t2" style="background-color: #F0E68C;">
					<tr>
						<td colspan="3" align="center">會員中心...(會員登入)</td>
					</tr>
					<tr>
						<td align="right">會員帳號:</td>
						<td><input type="text" name="MBR_MEMBERID"
							value="${param.MBR_MEMBERID}"></td>
						<td>${error.MBR_MEMBERID}</td>
					</tr>
					<tr>
						<td align="right">密碼:</td>
						<td><input type="text" name="MBR_PWD"
							value="${param.MBR_PWD}"></td>
						<td>${error.MBR_PWD}</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input type="submit"
							name="loginOrCreate" value="註冊帳號"> <input type="submit"
							name="loginOrCreate" value="會員登入"> <input type="submit"
							name="loginOrCreate" value="忘記密碼"></td>
						<!-- <td align="left"><input type="submit" name="loginOrCreate" value="登出"></td> -->
					</tr>
				</table>
			</form>
		</div>
		<c:import url="/common/FootBar.jsp" />
	</div>

</body>
</html>