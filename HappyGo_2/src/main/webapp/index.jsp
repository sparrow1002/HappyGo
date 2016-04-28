<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
</style>
</head>
<body>
	<img id="sky" src="/HappyGo_2/images/bg_00.png" />
	<img id="ground" src="/HappyGo_2/images/bg_01.png">
	<img id="cloud01" src="/HappyGo_2/images/cloud_01.png">
	<img id="cloud02" src="/HappyGo_2/images/cloud_02.png">
	<img id="cloud03" src="/HappyGo_2/images/cloud_03.png">
	<img id="cloud04" src="/HappyGo_2/images/cloud_04.png">
	<div id="allpage">
		<c:import url="/common/TopMeau.jsp" />
		<div id="content">
			<div class="cycle-slideshow">
				<img src="img/ad1.jpg"> <img src="img/ad5.jpg"> 
				<img src="img/ad7.jpg"> <img src="img/ad8.jpg">
			</div>
		</div>
		<c:import url="/common/FootBar.jsp" />
	</div>
</body>
<script src="js/jquery.cycle2.js"></script>
<link rel="stylesheet" href="base/jquery-ui-1.9.2.custom.min.css">
</body>
</html>
