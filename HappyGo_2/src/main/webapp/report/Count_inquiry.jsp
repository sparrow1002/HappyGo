<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
<script type="text/javascript" src="https://cdn.datatables.net/t/dt/jq-2.2.0,dt-1.10.11/datatables.min.js"></script>
<script src="/HappyGo_2/jquery/jquery-ui.js" type="text/javascript"></script>
<script src="/HappyGo_2/jquery/dataTable/columnFilter/jquery.dataTables.columnFilter.js" type="text/javascript" language="javascript"></script>
<script type="text/javascript" language="javascript">
	jQuery(document).ready(function() {
		jQuery("#report_table").dataTable(

		);

	});
	
	function open(){
		document.getElementsByName("form").target="_blank";
	}
</script>

<title>點數交易查詢</title>
</head>
<body>
	<div>
		<form action="/HappyGo_2/reportServer" name="form" method="post"  >
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>點數交易查詢</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="userid" name="id"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特約商店ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="userid"
						name="store"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">起始日期</TD>
					<TD for="meeting"><input id="meeting" type="date" name="day1"
						value="2014-01-13"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">結束日期</TD>
					<TD for="meeting"><input id="meeting" type="date" name="day2"
						value="2014-01-13"></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
					<input type="submit" name="prodaction" value="查詢" />
					<input type="submit" name="prodaction" value="產生PDF"/></TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<c:if test="${not empty select}">
		<table id="report_table">
			<thead>
				<tr>
					<th>會員編號</th>
					<th>消費地點</th>
					<th>交易日期</th>
					<th>消費金額</th>
					<th>折抵金額</th>
					<th>消費給點</th>
					<th>消耗點數</th>
					<th>剩餘點數</th>
					<th>取消交易</th>
				</tr>
			</thead>
			<!-- ------------------------ -->

			<tbody>
				<!--
			<tr>
				<td>會員編號</td>
				<td>消費地點</td>
				<td>交易日期</td>
				<td>消費金額</td>
				<td>折抵金額</td>
				<td>消費給點</td>
				<td>消耗點數</td>
				<td>剩餘點數</td>
				<td><button>取消交易</button></td>
			</tr>
			<tr>
				<td>交易2</td>
				<td>會員m</td>
				<td>金額100</td>
				<td>折抵50</td>
				<td>2016/01/01</td>
				<td>取消交易</td>
				<td>河濱店</td>
				<td>AOO1</td>
				<td><button>取消交易</button></td>
			</tr>
			<tr>
				<td>交易3</td>
				<td>會員Y</td>
				<td>金額100</td>
				<td>折抵50</td>
				<td>2016/01/01</td>
				<td>已交易</td>
				<td>河濱店</td>
				<td>AOO1</td>
				<td><button>取消交易</button></td>
			</tr>
  -->

				<c:forEach var="row" items="${select}">
					<tr>
						<td>${row.SOP_MEMBERID}</td>
						<td>${row.COS_NAME}</td>
						<td>${row.CPT_TRANDATE}</td>
						<td>${row.SOP_TRANAMT}</td>
						<td>${row.SOP_DISCOUNT}</td>
						<td>${row.CPT_POINTADD}</td>
						<td>${row.CPT_POINTDRE}</td>
						<td>${row.SOP_overPoint}</td>
						<td>取消交易</td>
					</tr>
				</c:forEach>
			</tbody>
			<!-- ------------------------ -->
			<tfoot>
				<tr>
					<th>會員編號</th>
					<th>消費地點</th>
					<th>交易日期</th>
					<th>消費金額</th>
					<th>折抵金額</th>
					<th>消費給點</th>
					<th>消耗點數</th>
					<th>剩餘點數</th>
					<th></th>
				</tr>
			</tfoot>
		</table>
	</c:if>
</body>
</html>