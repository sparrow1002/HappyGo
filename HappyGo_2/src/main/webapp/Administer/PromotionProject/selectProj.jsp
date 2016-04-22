<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢方案</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#PTP_CREATEDATE").datepicker({
			dateFormat: "yy/mm/dd"
		});
	});
	$(function() {
		$("#PTP_DELDATE").datepicker( {
			dateFormat: "yy/mm/dd"
		});
	});
</script>
</head>
<body>
<div id="allpage" style="background-color:#FFDDAA">
	<c:import url="/admin/TopMeau.jsp" />
	<form
		action="<c:url value="/PromotionProject/selectPromotionProject.controller" />"
		method="get">
		<table height="300px" width="1200px" style="border: 1px solid black"
			align="center">
			<tr>
				<td>查詢、修改活動方案</td>
			</tr>
			<tr>
				<td>請輸入【活動編號】或【活動名稱關鍵字】或【輸入日期】查詢活動</td>
			</tr>
			<tr>
				<td>請在此輸入活動編號：<input type="text" name="PTP_PROJID">
				<span class="error">${error.id}</span></td>
			</tr>
			<tr>
				<td>請在此輸入活動名稱關鍵字：<input type="text" name="PTP_NAME"></td>
			</tr>
			<tr>
				<td><select>
						<option value="TIMERANGE">活動區間
						<option value="UPDATETIME">異動日期區間
				</select>
				開始日期：<input type="text" name="PTP_CREATEDATE" id="PTP_CREATEDATE" value="">
				結束日期：<input type="text" name="PTP_DELDATE" id="PTP_DELDATE" value=""></td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" name="promotionProject" value="select">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="button" value="Back" onclick="location.href='<c:url value="/Administer/PromotionProject/index.jsp" />'">
				</td>
			</tr>
		</table>
	</form>
	<c:import url="/admin/FootBar.jsp" />
</div>
</body>
</html>