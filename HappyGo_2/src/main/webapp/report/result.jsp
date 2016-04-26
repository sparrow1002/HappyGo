<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="allpage" style="background-color: #FFDDAA">
		<c:import url="/admin/TopMeau.jsp" />
		<div style="width: 300px;margin: 0 auto;">
			<h1>取消交易成功!!!!</h1>
			<button onclick="location.href='/HappyGo_2/shopping/Count_inquiry.jsp'">
				返回查詢
			</button>
		</div>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
<link rel="stylesheet" href="/HappyGo_2/css/main.css">
<script src="/HappyGo_2/jquery/jquery-2.1.4.min.js"></script>
<script src="/HappyGo_2/jquery/jquery-ui.min.js"></script>
<script src="/HappyGo_2/jquery/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="/HappyGo_2/jquery/base/jquery-ui-1.9.2.custom.min.css">
<script src="/HappyGo_2/js/menu.js"></script>
<link rel="stylesheet" type="text/css"
	href="/HappyGo_2/jquery/jquery.dataTables.min.css" />
</html>