<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>特約店</title>
</head>
<script src="../jquery/jquery-2.1.4.min.js"></script>
<script src="../jquery/jquery-ui.js"></script>
<script src="../jquery/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../jquery/jquery.dataTables.min.css" />

<script>
	$(document).ready(function() {
		$('#myTable').DataTable();
	});
</script>
<style>
span {
	float: right;
}
</style>
<body>
	<%@ page import="conStore.model.*"%>
	<%@ page import="java.util.List"%>
	<%@ page import="javax.servlet.*"%>
	<%
		Object cb = session.getAttribute("adminuser");
		ContractStoreService contractStoreService = new ContractStoreService();
		List<ContractStoreBean> result = contractStoreService.select();
	%>
	<div id="allpage" style="background-color: #FFDDAA">
		<c:import url="/admin/TopMeau.jsp" />
		<form action="<c:url value="/conStore/contractStore.controller"/>"
			method="get">
			<span><a>${cb} </a><input type="submit" name="prodaction"
				value="登出" /></span>
			<table id="myTable" class="t2" style="background-color: #F0E68C;">
				<thead>
					<tr>
						<th>特店代號</th>
						<th>特店名稱</th>
						<th>統一編號</th>
						<th>特店地址</th>
						<th>特店狀態</th>
						<th>連絡電話</th>
						<th>聯絡人</th>
						<th>特店生效日</th>
						<th>特店失效日</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="row" items="<%=result%>">
						<tr>
							<td>${row.cos_storeid}</td>
							<td>${row.cos_name}</td>
							<td>${row.cos_taxcode}</td>
							<td>${row.cos_address}</td>
							<td><c:if test="${row.cos_status==1}">有效</c:if> <c:if
									test="${row.cos_status==0}">無效</c:if></td>
							<td>${row.cos_phone}</td>
							<td>${row.cos_contact}</td>
							<td>${row.cos_createtime}</td>
							<td>${row.cos_deletime}</td>
							<td><input type="button" name="prodaction" value="修改"
								onclick="location.href='<c:url value="/conStore/contractStore.controller?storeid=${row.cos_storeid}&prodaction=修改"/>'"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
</html>