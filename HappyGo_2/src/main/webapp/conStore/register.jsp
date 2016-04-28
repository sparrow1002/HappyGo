<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css">
<title>Insert title here</title>
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
			<form action="<c:url value="/conStore/register.controller" />"
				method="get">
				<table class="t2" style="background-color: #F0E68C;">
					<tr>
						<td colspan="2" align="center">申請特約商店</td>
					</tr>
					<tr>
						<td align="right">特店代號 :</td>
						<td><input type="text" name="storeid" value=""></td>
					</tr>
					<tr>
						<td align="right">特店名稱 :</td>
						<td><input type="text" name="name" value=""></td>
					</tr>

					<tr>
						<td align="right">特店密碼 :</td>
						<td><input type="password" name="pwd" value=""></td>
					</tr>
					<tr>
						<td align="right">統一編號 :</td>
						<td><input type="text" name="taxcode" value=""></td>
					</tr>
					<tr>
						<td align="right">特店地址 :</td>
						<td><input type="text" name="address" value=""></td>
					</tr>
					<tr>
						<td align="right">連絡電話 :</td>
						<td><input type="text" name="phone" value=""></td>
					</tr>
					<tr>
						<td align="right">聯絡人 :</td>
						<td><input type="text" name="contact" value=""></td>
					</tr>
					<tr>
						<td align="right">特店生效日 :</td>
						<td><input type="text" id="today" name="createtime" value=""></td>
					</tr>
					<tr>
						<td align="right">特店失效日 :</td>
						<td><input type="text" id="datepicker" name="deletime"
							value=""></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit" name="prodaction"
							value="申請特約商店"></td>
					</tr>
				</table>
			</form>
		</div>
		<c:import url="/common/FootBar.jsp" />
	</div>
</body>
</html>