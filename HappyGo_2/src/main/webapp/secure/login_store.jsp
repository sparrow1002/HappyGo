<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>特約商店登入</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<div>
		<form action="cs_1.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2'  bgcolor='#d4edec'><label>特店登入</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特約商店帳號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="userid"
						name="userid"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特約商店密碼</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="userpwd"
						name="userpwd"></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<input type="submit" value="登入" /> <input type="button" value="申請特約商店" />
						<input value="回首頁" onclick="window.location='../index.jsp'" type="button">
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
</body>
</html>