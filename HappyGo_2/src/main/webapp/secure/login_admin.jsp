<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>內部管理登入</title>
</head>
<body>
	<div id="allpage">
		<c:import url="/common/TopMeau.jsp" />
		<div class="demo" style="width: 946px">
			<table  class="t2" style="background-color: #F0E68C;" >
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>內部管理登入</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">使用者帳號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="username"
						name="username" value=${param.username}	></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">使用者密碼</TD>
					<TD bgcolor='#85d6d2'><input type="password" id="password"
						name="password" value=${param.password}	></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="submit" value="登入" /> <input value="回首頁"
						onclick="window.location='../index.jsp'" type="button"> <lable>${param.errormsg}</lable></TD>
				</TR>
			</table>
		</div>
		<c:import url="/common/FootBar.jsp" />
	</div>
</body>
<script>	
	var message = '<%=request.getAttribute("errormsg")%>
	';
	if (message != null && message != "" && message != "null")
		$.MessageBox(message);
</script>
</html>