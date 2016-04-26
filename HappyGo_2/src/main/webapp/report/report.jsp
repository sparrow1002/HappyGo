<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../reportServer" target="_blank" method="post">
		<table class="t2">
			<tr>
				<td>客戶ID:</td>
				<td><input type="text" name="id"></td>
			</tr>						<tr>
				<td>特店ID:</td>
				<td><input type="text" name="store"></td>
			</tr>
			<tr>
				<td>請輸入查詢日期:</td>
				<td><input type="text" name="day1">～<input type="text" name="day2"></td>
			</tr>
			<tr>
				<td><input type="submit" value="查詢(產生PDF)"></td>
			</tr>
		</table>
	</form>
</body>
</html>