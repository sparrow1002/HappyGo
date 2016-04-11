<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>Display</title>
</head>
<body>

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
	<tbody>
	<c:forEach var="row" items="${select}">
		<c:url value="/conStore/contractStore.jsp" var="path" scope="page">
			<c:param name="storeid" value="${row.cos_storeid}" />
			<c:param name="name" value="${row.cos_name}" />
			<c:param name="pwd" value="${row.cos_pwd}" />
			<c:param name="taxcode" value="${row.cos_taxcode}" />
			<c:param name="address" value="${row.cos_address}" />
			<c:param name="status" value="${row.cos_status}" />
			<c:param name="phone" value="${row.cos_phone}" />
			<c:param name="contact" value="${row.cos_contact}" />
			<c:param name="createtime" value="${row.cos_createtime}" />
			<c:param name="deletime" value="${row.cos_deletime}" />
			<c:param name="updatetime" value="${row.cos_updatetime}" />
			<c:param name="updateuser" value="${row.cos_updateuser}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.cos_storeid}</a></td>
		<td>${row.cos_name}</td>
		<td>${row.cos_pwd}</td>
		<td>${row.cos_taxcode}</td>
		<td>${row.cos_address}</td>
		<td>${row.cos_status}</td>
		<td>${row.cos_phone}</td>
		<td>${row.cos_contact}</td>
		<td>${row.cos_createtime}</td>
		<td>${row.cos_deletime}</td>
		<td>${row.cos_updatetime}</td>
		<td>${row.cos_updateuser}</td>		
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/conStore/contractStore.jsp" />">ContractStore Table</a></h3>
</body>
</html>