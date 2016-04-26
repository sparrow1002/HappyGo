<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<%
	Object adminuser = session.getAttribute("adminuser");
	Object storeuser = session.getAttribute("storeLoginOK");
%>
<body>
	<div id="allpage" style="background-color: #FFDDAA">
		<c:import url="/admin/TopMeau.jsp" />
		<form action="<c:url value="/conStore/modify.controller"/>"
			method="get">
			
			<!-- 前台特店 -->
			<c:if test="${empty adminuser}">
				<table class="t2" style="background-color: #F0E68C;">
					<c:forEach var="row" items="${select}">
						<tr>
							<td>特店代號 :</td>
							<td><input type="text" name="storeid"
								value="${row.cos_storeid}" readonly></td>
							<td></td>
						</tr>
						<tr>
							<td>特店名稱 :</td>
							<td><input type="text" name="name" value="${row.cos_name}"></td>
							<td></td>
						</tr>
						<tr>
							<td>統一編號 :</td>
							<td><input type="text" name="taxcode"
								value="${row.cos_taxcode}"></td>
							<td></td>
						</tr>
						<tr>
							<td>特店地址 :</td>
							<td><input type="text" name="address"
								value="${row.cos_address}"></td>
							<td></td>
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
							<td></td>
						</tr>
						<tr>
							<td>連絡電話 :</td>
							<td><input type="text" name="phone" value="${row.cos_phone}"></td>
							<td></td>
						</tr>
						<tr>
							<td>聯絡人 :</td>
							<td><input type="text" name="contact"
								value="${row.cos_contact}"></td>
							<td></td>
						</tr>
						<tr>
							<td>特店生效日 :</td>
							<td><input type="text" id="today" name="createtime"
								value="${row.cos_createtime}" readonly></td>
							<td></td>
						</tr>
						<tr>
							<td>特店失效日 :</td>
							<td><input type="text" id="datepicker" name="deletime"
								value="${row.cos_deletime}" readonly></td>
							<td></td>
						</tr>
						<tr>
							<td><input type="submit" name="prodaction" value="送出"
								onclick="if(confirm('您確定要修改嗎?')) return true;else return false">
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			
			<!-- 後台特店 -->
			<c:if test="${!empty adminuser}">
				<table class="t2" style="background-color: #F0E68C;">
					<c:forEach var="row" items="${select}">
						<tr>
							<td>特店代號 :</td>
							<td><input type="text" name="storeid"
								value="${row.cos_storeid}" readonly></td>
							<td></td>
						</tr>
						<tr>
							<td>特店名稱 :</td>
							<td><input type="text" name="name" value="${row.cos_name}" readonly></td>
							<td></td>
						</tr>
						<tr>
							<td>統一編號 :</td>
							<td><input type="text" name="taxcode"
								value="${row.cos_taxcode}"></td>
							<td></td>
						</tr>
						<tr>
							<td>特店地址 :</td>
							<td><input type="text" name="address"
								value="${row.cos_address}"></td>
							<td></td>
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
							<td></td>
						</tr>
						<tr>
							<td>連絡電話 :</td>
							<td><input type="text" name="phone" value="${row.cos_phone}"></td>
							<td></td>
						</tr>
						<tr>
							<td>聯絡人 :</td>
							<td><input type="text" name="contact"
								value="${row.cos_contact}"></td>
							<td></td>
						</tr>
						<tr>
							<td>特店生效日 :</td>
							<td><input type="text" id="today" name="createtime"
								value="${row.cos_createtime}" readonly></td>
							<td></td>
						</tr>
						<tr>
							<td>特店失效日 :</td>
							<td><input type="text" id="datepicker" name="deletime"
								value="${row.cos_deletime}" readonly></td>
							<td></td>
						</tr>
						<tr>
							<td><input type="submit" name="prodaction" value="送出"
								onclick="if(confirm('您確定要修改嗎?')) return true;else return false">
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</form>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
</html>