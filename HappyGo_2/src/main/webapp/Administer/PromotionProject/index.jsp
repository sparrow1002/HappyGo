<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>促銷方案首頁</title>
</head>
<body>
<div id="allpage">
	<c:import url="/admin/TopMeau.jsp" />
<h1>促銷方案首頁</h1>
<input type=button value="新增活動方案" onclick="location.href='<c:url value="/Administer/PromotionProject/insertProj.jsp" />'">
<input type=button value="查詢活動方案" onclick="location.href='<c:url value="/Administer/PromotionProject/selectProj.jsp" />'">
<input type=button value="修改活動方案" onclick="location.href='<c:url value="/Administer/PromotionProject/updateProj.jsp" />'">

<c:if test="${not empty insert}">
<h3>Insert PromotionProject Success</h3>
</c:if>

<c:if test="${not empty update}">
<h3>Update PromotionProject Success</h3>
</c:if>
	<c:import url="/admin/FootBar.jsp" />
</div>
</body>
</html>
