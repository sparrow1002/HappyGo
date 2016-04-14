<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../jquery-ui-1.11.4.custom/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../css/lightbox.min.css" />
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css" />

<title>Display</title>
<style type="text/css">
#photo {
	position:absolute;
	z-index:1;
	left:600px;
	top:75px;
	width:300px;
	height:300px;
}
</style>
<script type="text/javascript" src="../js/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="../jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
var url = "${pageContext.request.contextPath}/pages/photo.view?photoid=";
$(document).ready(function() {
	$('a[href*="photo"]').attr("data-lightbox", "product");
	$("#photo").hide();
	$("tbody>tr>td:nth-child(2)").each(function() {
		$(this).mouseover(function() {
			var id = $(this).prev().text();
			$("#photo").html('<img src="'+url+id+'">').show("bounce", null, 1000);
		});
	});
	$("tbody>tr>td:nth-child(2)").mouseout(function() {
		$("#photo").empty().hide();
	});
	
	$("table").DataTable({
		"pageLength": 3,
		"lengthMenu": [ 1, 3, 5, 7 ]
	});
});
</script>
</head>
<body>

<h3>(會員中心)登出</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Make</th>
		<th>Expire</th>
		<th>Photo</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/product.jsp" var="path" scope="page">
			<c:param name="id" value="${row.id}" />
			<c:param name="name" value="${row.name}" />
			<c:param name="price" value="${row.price}" />
			<c:param name="make" value="${row.make}" />
			<c:param name="expire" value="${row.expire}" />
		</c:url>
		<c:url value="/pages/photo.view" var="url" scope="page">
			<c:param name="photoid" value="${row.id}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.id}</a></td>
		<td>${row.name}</td>
		<td>${row.price}</td>
		<td>${row.make}</td>
		<td>${row.expire}</td>
		<td><a href="${url}" data-title="${row.name}"><img src="../img/click.png"></a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<%-- <h3><a href="<c:url value="/pages/product.jsp" />">Product Table</a></h3> --%>
<div id="photo"></div>

<script type="text/javascript" src="../js/lightbox.min.js"></script>
</body>
</html>