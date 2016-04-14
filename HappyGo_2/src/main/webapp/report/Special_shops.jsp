<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>特店點數查詢</title>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
	<div>
		<form action="../reportServer_store" method="post" target="_blank">
			<TABLE>	
				<TR>
					<TH colspan='2'  bgcolor='#d4edec'><label>特店交易紀錄查詢</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="userid"
						name="id"></TD>
				</TR>
					<TR>
					<TD bgcolor='#bce6e4' align="right">起始日期</TD>
					<TD for="meeting" >
					<input id="meeting" type="date" name="day1" value="2014-01-13">
					</TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">結束日期</TD>
					<TD for="meeting" >
					<input id="meeting" type="date" name="day2" value="2014-01-13">
					</TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="submit" value="輸入" /></TD>
				</TR>
			</TABLE>
		</form>
	</div>
</body>
</html>