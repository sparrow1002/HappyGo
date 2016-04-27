<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css">
<title>修改</title>
</head>
<%
	Object adminuser = session.getAttribute("adminuser");
	Object storeuser = session.getAttribute("storeLoginOK");
%>
<body>
<img id="sky" src="/HappyGo_2/images/bg_00.png" />
<img id="ground" src="/HappyGo_2/images/bg_01.png">
<img id="cloud01" src="/HappyGo_2/images/cloud_01.png">
<img id="cloud02" src="/HappyGo_2/images/cloud_02.png">
<img id="cloud03" src="/HappyGo_2/images/cloud_03.png">
<img id="cloud04" src="/HappyGo_2/images/cloud_04.png">
	<div id="allpage" style="background-color: #FFDDAA">
		<c:import url="/admin/TopMeau.jsp" />
		<div id="content" class="demo" style="width: 900px">
			<form action="<c:url value="/conStore/modify.controller"/>"
				method="get">
				<!-- 後台特店 -->
				<c:if test="${!empty adminuser}">
					<table class="t2" style="background-color: #F0E68C;">
						<c:forEach var="row" items="${select}">
							<tr>
								<td>特店代號 :</td>
								<td><input type="text" name="storeid"
									value="${row.cos_storeid}" readonly></td>

							</tr>
							<tr>
								<td>特店名稱 :</td>
								<td><input type="text" name="name" value="${row.cos_name}"
									readonly></td>
							</tr>
							<tr>
								<td>特店密碼 :</td>
								<td><input type="password" name="pwd" value="${row.cos_pwd}" readonly></td>
							</tr>
							<tr>
								<td>統一編號 :</td>
								<td><input type="text" name="taxcode"
									value="${row.cos_taxcode}"></td>

							</tr>
							<tr>
								<td>特店地址 :</td>
								<td><input type="text" name="address"
									value="${row.cos_address}"></td>

							</tr>
							<tr>
								<td>特店狀態 :</td>
								<td><c:if test="${row.cos_status=='1'}">
										<input type="radio" name="status" value="1" checked="checked">有效
	 		    <input type="radio" name="status" value="0">無效
			</c:if> <c:if test="${row.cos_status=='0'}">
										<input type="radio" name="status" value="1">有效
			 	<input type="radio" name="status" value="0" checked="checked">無效		
			</c:if></td>

							</tr>
							<tr>
								<td>連絡電話 :</td>
								<td><input type="text" name="phone"
									value="${row.cos_phone}"></td>

							</tr>
							<tr>
								<td>聯絡人 :</td>
								<td><input type="text" name="contact"
									value="${row.cos_contact}"></td>

							</tr>
							<tr>
								<td>特店生效日 :</td>
								<td><input type="text" id="today" name="createtime"
									value="${row.cos_createtime}" readonly></td>

							</tr>
							<tr>
								<td>特店失效日 :</td>
								<td><input type="text" id="datepicker" name="deletime"
									value="${row.cos_deletime}" readonly></td>

							</tr>
							<tr>
								<td colspan="2"><input type="submit" name="prodaction"
									value="送出"
									onclick="if(confirm('您確定要修改嗎?')) return true;else return false">
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</form>
		</div>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
</html>