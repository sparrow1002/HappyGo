<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>查詢結果</title>
</head>
<body>
<div id="allpage">
	<c:import url="/admin/TopMeau.jsp" />
<h3>查詢結果</h3>

<c:if test="${not empty select}">
<table>
	<thead>
		<tr>
		<th>PTP_PROJID</th>
		<th>PTP_NAME</th>
		<th>PTP_CREATEDATE</th>
		<th>PTP_DELDATE</th>
		<th>PTP_STATUS</th>
		<th>ACTION</th>
		</tr>
	</thead>
<tbody>
	<c:forEach var="row" items="${select}">
		<c:url value="/Administer/PromotionProject/updateProj.jsp" var="path" scope="page">
			<c:param name="PTP_PROJID" value="${row.PTP_PROJID}" />
			<c:param name="PTP_NAME" value="${row.PTP_NAME}" />
			<c:param name="PTP_CREATEDATE" value="${row.PTP_CREATEDATE}" />
			<c:param name="PTP_DELDATE" value="${row.PTP_DELDATE}" />
			<c:param name="PTP_STATUS" value="${row.PTP_STATUS}" />
			<c:param name="ACTION" value="功能" />
		</c:url>
	<tr>
		<td>${row.PTP_PROJID}</td>
		<td>${row.PTP_NAME}</td>
		<td>${row.PTP_CREATEDATE}</td>
		<td>${row.PTP_DELDATE}</td>
		<td>${row.PTP_STATUS}</td>
		<td><a href="${path}">修改</a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
<h3><a href="<c:url value="/Administer/PromotionProject/selectProj.jsp" />">Back</a></h3>

	<c:import url="/admin/FootBar.jsp" />
</div>
</body>
</html>