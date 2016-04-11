<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
</style>
</head>
<body>
	<header>
	<div>
		<nav>
		<ul id="menu">
			<li><a href="">Happy GO 說明</a></li>
			<li><a href="">最新促銷活動</a></li>
			<li><a href="secure/login_cus.jsp">會員登入</a></li>
			<li><a href="secure/login_store.jsp">特約商店登入</a></li>
			<li><a href="secure/login_admin.jsp">系統人員登入</a></li>
		</ul>
		</nav>
	</div>
	</header>
	<div id="content">
		<img alt="" src="img/main.jpg">
		<div>
			<footer>
			<p style="color: white;">E-amil:dayu2004@gmail.com &nbsp;
				Tel:(02)2882-5252 &nbsp; 台北市復興南路一段390號 &nbsp; &copy; 2016 dayu DEMO.</p>
			</footer>
		</div>
	</div>
</body>
<script src="jquery/jquery-2.1.4.min.js"></script>
<script src="jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="base/jquery-ui-1.9.2.custom.min.css">
<script>
	$(function() {
		$("#menus2").menu();
	});
</script>
</body>
</html>