<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/HappyGo_2/reportCancelServer" method="post">
		<table>
			<tr>
				<th><h1>確定要取消交易嗎?</h1></th>
			</tr>
			<tr>
				<td>交易編號：</td>
				<td><input type="text" name="report_cancel" value="${param.cancel}" /></td>
			</tr>
			<tr>
				<td>
				<input type="submit" name="reportstore_prodaction" value="確定" />
				<input type="submit" name="reportstore_prodaction" value="取消" /> </td>
			</tr>
		</table>
	</form>
</body>
</html>