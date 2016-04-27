<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>查詢會員資料</title>
</head>
<body>
	<div id="allpage" style="background-color: #FFDDAA">
		<c:import url="/admin/TopMeau.jsp" />
		<h2>請輸入會員帳號</h2>
		<form
			action="<c:url value="/Administer/selectMemberData.controller" />
		"
			method="get">
			<div class="tableEff">
			<table >
				<tr>
					<td>會員帳號： <input type="text" name="MBR_MEMBERID"> <input
						type="submit" name="selectMemberData" value="select"> <span
						class="error">${error.MBR_MEMBERID}</span> <span class="error">${error.id}</span>
					</td>
				</tr>
			</table>
			</div>
		</form>

		<c:if test="${not empty select}">
		<div class="tableEff">
			<table class="jtable">
				<thead>
					<tr>
						<th>帳號</th>
						<th>名稱</th>
						<th>性別</th>
						<th>生日</th>
						<!-- <th>紅利點數</th> -->
					</tr>
				</thead>
				<tr>
					<td>${select.MBR_MEMBERID}</td>
					<td>${select.MBR_NAME}</td>
					<td><c:if test="${select.MBR_SEX==1}">男</c:if> <c:if
							test="${select.MBR_SEX==0}">女</c:if> <%-- 	<td>${select.MBR_SEX}</td> --%>
					</td>
					<td>${select.MBR_BIRTHDAY}</td>
					<%-- <td>${select.MBR_POINTS}</td> --%>
				</tr>
			</table>
			</div>
		</c:if>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
</html>