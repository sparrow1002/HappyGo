<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/table.css">
<script type="text/javascript"
	src="https://cdn.datatables.net/t/dt/jq-2.2.0,dt-1.10.11/datatables.min.js"></script>
<script src="/HappyGo_2/jquery/jquery-ui.js" type="text/javascript"></script>
<script
	src="/HappyGo_2/jquery/dataTable/columnFilter/jquery.dataTables.columnFilter.js"
	type="text/javascript" language="javascript"></script>
<script type="text/javascript" language="javascript">
	jQuery(document).ready(function() {
		jQuery("#report_table").dataTable(

		);

	});
</script>
<style type="text/css">
TD {
	text-align: center;
}
.jtable TH{
	font-size: 10px;
}
</style>
<title>點數交易查詢</title>
</head>
<body>
	<div id="allpage" style="background-color: #FFDDAA;">
		<c:import url="/admin/TopMeau.jsp" />
		<div>
			<form action="/HappyGo_2/reportServer" name="form" method="post" >
				<div style="width: 300px; margin: 0 auto;">
					<TABLE>
						<TR>
							<TH colspan='2' bgcolor='#d4edec'><label>點數交易查詢</label></TH>
						</TR>
						<TR>
							<TD bgcolor='#bce6e4' align="right">會員ID</TD>
							<TD bgcolor='#85d6d2'><input type="text" id="userid"
								name="report_id" value="${param.report_id}"></TD>
						</TR>
						<TR>
							<TD bgcolor='#bce6e4' align="right">特約商店ID</TD>
							<TD bgcolor='#85d6d2'><input type="text" id="userid"
								name="report_store" value="${param.report_store}"></TD>
						</TR>
						<TR>
							<TD bgcolor='#bce6e4' align="right">起始日期</TD>
							<TD for="meeting"><input id="meeting" type="date"
								name="report_day1" value="${param.report_day1}" style="width: 97%;"></TD>
						</TR>
						<TR>
							<TD bgcolor='#bce6e4' align="right">結束日期</TD>
							<TD for="meeting"><input id="meeting" type="date"
								name="report_day2" value="${param.report_day2}" style="width: 97%;"></TD>
						</TR>
						<TR>
							<TD colspan='2' bgcolor='#d4edec' align="center"><input
								type="submit" name="report_prodaction" value="查詢" /> <input
								type="submit" name="report_prodaction" value="產生PDF" /></TD>
						</TR>
					</TABLE>
				</div>
				<div style="margin: 0 auto;">
					<c:if test="${not empty report_select}">
						<table id="report_table" class="jtable">
							<thead>
								<tr>
									<th>交易編號</th>
									<th>會員編號</th>
									<th>消費地點</th>
									<th>交易日期</th>
									<th>消費金額</th>
									<th>折抵金額</th>
									<th>消費給點</th>
									<th>消耗點數</th>
									<th>交易狀態</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="row" items="${report_select}">
									<tr>
										<td>${row.SOP_TRANID}</td>
										<td>${row.SOP_MEMBERID}</td>
										<td>${row.COS_NAME}</td>
										<td>${row.CPT_TRANDATE}</td>
										<td>${row.SOP_TRANAMT}</td>
										<td>${row.SOP_DISCOUNT}</td>
										<td>${row.CPT_POINTADD}</td>
										<td>${row.CPT_POINTDRE}</td>
										<td>${row.transation}</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>交易編號</th>
									<th>會員編號</th>
									<th>消費地點</th>
									<th>交易日期</th>
									<th>消費金額</th>
									<th>折抵金額</th>
									<th>消費給點</th>
									<th>消耗點數</th>
									<th>交易狀態</th>
								</tr>
							</tfoot>
						</table>
					</c:if>
				</div>
			</form>
		</div>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
<link rel="stylesheet" href="/HappyGo_2/css/main.css">
<script src="/HappyGo_2/jquery/jquery-2.1.4.min.js"></script>
<script src="/HappyGo_2/jquery/jquery-ui.min.js"></script>
<script src="/HappyGo_2/jquery/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="/HappyGo_2/jquery/base/jquery-ui-1.9.2.custom.min.css">
<script src="/HappyGo_2/js/menu.js"></script>
<link rel="stylesheet" type="text/css"
	href="/HappyGo_2/jquery/jquery.dataTables.min.css" />
</html>