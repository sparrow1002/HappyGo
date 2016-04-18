<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
<form action="<c:url value="/conStore/modify.controller"/>" method="get">
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>storeid</th>
		<th>name</th>
		<th>pwd</th>
		<th>taxcode</th>
		<th>address</th>
		<th>status</th>
		<th>phone</th>
		<th>contact</th>
		<th>createtime</th>
		<th>deletime</th>
		<th>updatetime</th>
		<th>updateuser</th>		
	</tr>
	</thead>	
</table>
</c:if>

<table>
	<c:forEach var="row" items="${select}">
	<tr>
		<td>StoreID : </td>
		<td><input type="text" name="storeid" value="${row.cos_storeid}" ></td>
		<td></td>
	</tr>
	<tr>
		<td>Name : </td>
		<td><input type="text" name="name" value="${row.cos_name}"></td>
		<td></td>
	</tr>

	<tr>
		<td>PassWord : </td>
		<td><input type="text" name="pwd" value="${row.cos_pwd}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Taxcode : </td>
		<td><input type="text" name="taxcode" value="${row.cos_taxcode}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Address : </td>
		<td><input type="text" name="address" value="${row.cos_address}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Status : </td>
		<td><input type="text" name="status" value="${row.cos_status}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Phone : </td>
		<td><input type="text" name="phone" value="${row.cos_phone}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Contact : </td>
		<td><input type="text" name="contact" value="${row.cos_contact}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Createtime : </td>
		<td><input type="text" id="today"  name="createtime" value="${row.cos_createtime}" ></td>
		<td></td>
	</tr>
	<tr>
		<td>Deletime : </td>
		<td><input type="text" id="datepicker"  name="deletime" value="${row.cos_deletime}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Updatetime : </td>
		<td><input type="text" name="updatetime" value="${row.cos_updatetime}" ></td>
		<td></td>
	</tr>
	<tr>
		<td>Updateuser : </td>
		<td><input type="text" name="Updateuser" value="${row.cos_updateuser}"></td>
		<td></td>
	</tr>
	<tr>
		<td>		
			<input type="submit" name="prodaction" value="Update">
		</td>		
	</tr>	
	</c:forEach>	
</table>
</form>
</body>
</html>