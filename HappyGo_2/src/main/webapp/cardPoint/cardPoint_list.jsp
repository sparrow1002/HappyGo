<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<script type="text/javascript" language="javascript">
	jQuery(document).ready(function(){

		//$.datepicker.regional[""].dateFormat = 'yy/mm/dd';
        //$.datepicker.setDefaults($.datepicker.regional[""]);
                
		jQuery('table').dataTable(
						
		);
		
	});
</script>

<title>紅利點數記錄</title>
</head>


<body>
	
	<h1>尚有:${totalPoint}點</h1>
	<h4>您有 ${LastPoint.pointAdd}點,將在${LastPoint.dDate}過期</h4>
	<table class="display">
<!-- 	class="display"可以套用到dataTables的css樣式 -->
<!-- 	class="display"可以套用到demo_table.css樣式 -->
		<thead>
<!-- 			<tr> -->
<!-- 				<th >失效日</th> -->
<!-- 				<th >點數</th> -->
<!-- 				<th >點數狀態</th> -->
<!-- 				<th >交易編號</th> -->
<!-- 				<th >交易日</th> -->
<!-- 			</tr> -->
			<tr>
				<th >失效日</th>
				<th >點數</th>
<!-- 				<th >點數狀態</th> -->
<!-- 				<th >交易編號</th> -->
				<th >交易日</th>
			</tr>
		</thead>
	<!-- ------------------------ -->	
		<tbody>
			<c:if test="${not empty point}">
 			<c:forEach var="row" items="${point}"> 
			<tr>
				<td>${row.dDate}</td>
				<td>${row.pointAdd}</td>
<%-- 				<td>${row.status}</td> --%>
<%-- 				<td>${row.tranId}</td> --%>
				<td>${row.tranDate}</td>
			</tr>	
			</c:forEach>
			</c:if>
		</tbody>
	<!-- ------------------------ -->
		<tfoot>
			<tr>
				<th >失效日</th>
				<th >點數</th>
<!-- 				<th >點數狀態</th> -->
<!-- 				<th >交易編號</th> -->
				<th >交易日</th>
			</tr>
		</tfoot>
	</table>
</body>
</html>