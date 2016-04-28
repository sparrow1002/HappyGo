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
	<img id="sky" src="/HappyGo_2/images/bg_00.png" />
	<img id="ground" src="/HappyGo_2/images/bg_01.png">
	<img id="cloud01" src="/HappyGo_2/images/cloud_01.png">
	<img id="cloud02" src="/HappyGo_2/images/cloud_02.png">
	<img id="cloud03" src="/HappyGo_2/images/cloud_03.png">
	<img id="cloud04" src="/HappyGo_2/images/cloud_04.png">
<div id="allpage" style="background-color:#FFDDAA">
	<c:import url="/admin/TopMeau.jsp" />
	
<h1>促銷方案首頁</h1>
<c:if test="${not empty insert}">
<h2>活動設定成功</h2>
</c:if>

<c:if test="${not empty update}">
<h2>活動更新成功</h2>
</c:if>
<input type=button value="新增活動方案" onclick="location.href='<c:url value="/Administer/PromotionProject/insertProj.jsp" />'">
<input type=button value="查詢活動方案" onclick="location.href='<c:url value="/Administer/PromotionProject/selectProj.jsp" />'">
<!-- demo時，只可從查詢介面進入修改介面 -->
<%-- <input type=button value="修改活動方案" onclick="location.href='<c:url value="/Administer/PromotionProject/updateProj.jsp" />'"> --%>

	<c:import url="/admin/FootBar.jsp" />
</div>
</body>
</html>
