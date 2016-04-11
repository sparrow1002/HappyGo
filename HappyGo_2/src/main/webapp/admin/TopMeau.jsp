<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MENU</title>
</head>
<link rel="stylesheet" href="../css/main.css">
<script src="../jquery/jquery-2.1.4.min.js"></script>
<script src="../jquery/jquery-ui.min.js"></script>
<script src="../jquery/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="../jquery/base/jquery-ui-1.9.2.custom.min.css">
<script src="../js/menu.js"></script>
<link rel="stylesheet" type="text/css"
	href="../jquery/jquery.dataTables.min.css" />
<body>
	<div align="center">
		<ul id="menus">
			<li><a href="">會員資料管理</a>
				<ul>
					<li><a onclick="">會員資料維護</a></li>
					<li><a onclick="">新增會員資料</a></li>
				</ul></li>
			<li><a href="">特店資料管理</a>
				<ul>
					<li><a onclick="">特店申請核准</a></li>
					<li><a onclick="">特店資料維護</a></li>
					<li><a onclick="">新增特店資料</a></li>
				</ul></li>
			<li><a href="">促銷活動管理</a>
				<ul>
					<li><a onclick="">促銷活動查詢</a></li>
					<li><a onclick="">新增促銷活動</a></li>
				</ul></li>
			<li><a href="">報表查詢</a>
				<ul>
					<li><a onclick="">會員點數查詢</a></li>
					<li><a onclick="">特店點數查詢</a></li>
					<li><a onclick="">點數交易處理查詢</a></li>
				</ul></li>
			<li><a href="">系統管理</a>
				<ul>
					<li><a href='<c:url value="/dayuNameSpace/sysloglist.action?mode=select"/>'>登入管理</a></li>
					<li><a href='<c:url value="/dayuNameSpace/maguserlist.action?mode=select"/>'>使用者設定</a></li>
					<li><a href='<c:url value="/dayuNameSpace/rolelist.action?mode=select"/>'>角色權限設定</a></li>
					<li><a href='<c:url value="/dayuNameSpace/rightlist.action?mode=select"/>'>權限項目設定</a></li>
					<li><a href='<c:url value="/dayuNameSpace/dataprofilelist.action?mode=select"/>'>資料設定</a></li>

				</ul></li>
			<li><a href="../index.jsp">回首頁</a></li>
		</ul>
	</div>
	<br/>&nbsp;
	<div>
	<br/>&nbsp;
	</div>
</body>
</html>