<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../css/main.css">
<body>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>ADM_ID</th>
		<th>ADM_PWD</th>
		<th>ADM_NAME</th>
		<th>ADM_ROLEID</th>
		<th>ADM_UPDATEUSER</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="row" items="${select}">
		<c:url value="/admin/userlist.jsp" var="path" scope="page">
			<c:param name="ADM_ID" value="${row.ADM_ID}" />
			<c:param name="ADM_PWD" value="${row.ADM_PWD}" />
			<c:param name="ADM_NAME" value="${row.ADM_NAME}" />
			<c:param name="ADM_ROLEID" value="${row.ADM_ROLEID}" />
			<c:param name="ADM_UPDATEUSER" value="${row.ADM_UPDATEUSER}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.ADM_ID}</a></td>
		<td>${row.ADM_PWD}</td>
		<td>${row.ADM_NAME}</td>
		<td>${row.ADM_ROLEID}</td>
		<td>${row.ADM_UPDATEUSER}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
<h3><a href="<c:url value="/admin/main_mag.jsp" />">Main </a></h3>
</body>
</html>