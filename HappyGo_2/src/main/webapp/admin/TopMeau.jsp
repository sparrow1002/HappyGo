<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MENU</title>
</head>
<link rel="stylesheet" href="<c:url value='/css/main.css'/>">

<script src="<c:url value='/jquery/jquery-2.1.4.min.js'/>"></script>
<script src="<c:url value='/jquery/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jquery/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet"	href="<c:url value='/jquery/base/jquery-ui-1.9.2.custom.min.css'/>">
<script src="<c:url value='/js/menu.js'/>"></script>
<link rel="stylesheet" type="text/css"	href="<c:url value='/jquery/jquery.dataTables.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/messagebox.css'/>">
<script src="<c:url value='/js/messagebox.js'/>"></script> 
<body>
	<div align="center">
		<c:if test="${sessionScope.adminuserright != null}">
			<ul id="menus">
				<c:forEach var="right" items="${sessionScope.adminuserright}"
					varStatus="varStatus">
					<li><a href="">${right.key}</a>
						<ul>
							<c:forEach var="rightitem" items="${right.value}">
								<li><a href='<c:url value="${rightitem.value}"/>'>${rightitem.key}</a></li>
							</c:forEach>
						</ul></li>
				</c:forEach>
				<li><a href="<c:url value="/dayuNameSpace/weblogin.action?mode=quit" />">回首頁</a></li>
			</ul>
		</c:if>
	</div>
	<div>
		<table style="background-color: #F75000;width:900px;">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
</body>
</html>