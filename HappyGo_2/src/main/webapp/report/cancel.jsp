<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="allpage" style="background-color: #FFDDAA">
		<c:import url="/admin/TopMeau.jsp" />
		<form action="/HappyGo_2/reportCancelServer" method="post">

			<table class="t2">
				<thead>

				<tr>
					<th><h1>確定要取消交易嗎?</h1></th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>交易編號：${param.cancel}
					<input type="hidden" name="report_cancel"
						value="${param.cancel}" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="reportstore_prodaction" value="確定" />
						<input type="button" value="取消" onclick="location.href='/HappyGo_2/shopping/Count_inquiry.jsp'"></td>
				</tr>
				</tbody>
			</table>
		</form>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
</html>
