<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forget Password</title>
</head>
<body>
	<div id="allpage_out">
		<c:import url="/common/TopMeau.jsp" />
		<div class="demo" style="width: 946px">
			<form action="<c:url value="/secure/login.controller" />"
				method="get">
				<table class="t2" style="background-color: #F0E68C;">
					<tr>
						<td align="center" colspan="3">會員中心...(忘記密碼)</td>
					</tr>
					<tr>
						<td align="right">會員帳號:</td>
						<td colspan="2"><input type="text" name="MBR_MEMBERID"
							value="${param.MBR_MEMBERID}">${error.MBR_MEMBERID}</td>
					</tr>
					<tr>
						<td align="right">電子郵件帳號:</td>
						<td colspan="2"><input type="text" name="MBR_EMAIL"
							value="${param.MBR_EMAIL}">${error.MBR_EMAIL}</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input type="submit"
							name="loginOrCreate" value="使用(會員帳號/電子郵件)查詢"> <input
							type="submit" name="loginOrCreate" value="回會員中心首頁"></td>
					</tr>
				</table>
			</form>
		</div>
		<c:import url="/common/FootBar.jsp" />
	</div>
</body>
</html>