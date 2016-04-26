<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css"> 
	@import"../jquery/jquery-ui.css";   
/*  	@import"../jquery/dataTable/columnFilter/demo_table.css";  */
	/*
		Lin Juang-Bao:
		demo_table.css is writed by datatableFilter's auth
		if want to use,may style will be unprediction
	*/
</style>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/t/dt/jq-2.2.0,dt-1.10.11/datatables.min.css"/>

<script type="text/javascript" src="https://cdn.datatables.net/t/dt/jq-2.2.0,dt-1.10.11/datatables.min.js"></script>

<script src="../jquery/jquery-ui.js" type="text/javascript"></script>
<script src="../jquery/dataTable/columnFilter/jquery.dataTables.columnFilter.js"type="text/javascript" language="javascript"></script>





<title>交易記錄</title>
</head>
<body>
	<h1>交易記錄</h1>
	
	<table >
		<thead>
			<tr>
				<th>交易編號</th>
				<th>會員編號</th>
				<th>交易金額</th>
				<th>交易折抵</th>
				<th>交易日期</th><!--  點數table-->
				<th>交易狀態</th>
				<th>消費店家</th>
				<th>促銷專案</th>
				<th>取消交易</th>
			</tr>
		</thead>
	<!-- ------------------------ -->
		
		<tbody>
			<tr>
				<td>交易1</td>
				<td>會員m</td>
				<td>金額100</td>
				<td>折抵50</td>
				<td>2016/01/01</td>
				<td>已交易</td>
				<td>河濱店</td>
				<td>AOO1</td>
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
			
<%-- 			
			<c:forEach var="row" items="${ }"> 
			<tr>
				<td>${row.tranId}</td>
				<td>${row.memberId}</td>
				<td>${row.tranAmt}</td>
				<td>${row.disCount}</td>
				<th>交易日期</th><!--  點數table-->
				<td>${row.status}</td>
				<td>${row.storeId}</td>
				<td>${row.projId}</td>
			</tr>
			</c:forEach>
--%>
		</tbody>
	<!-- ------------------------ -->	
		<tfoot>
			<tr>
				<th>交易編號</th>
				<th>會員編號</th>
				<th>交易金額</th>
				<th>交易折抵</th>
				<th>交易日期</th><!--  點數table-->
				<th>交易狀態</th>
				<th>消費店家</th>
				<th>促銷專案</th>
				<th></th>
			</tr>
		</tfoot>
	</table>
	
	
	
	<a href="">回搜尋頁面</a>
	
</body>
</html>