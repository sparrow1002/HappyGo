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

		$.datepicker.regional[""].dateFormat = 'yy/mm/dd';
        $.datepicker.setDefaults($.datepicker.regional['']);
                
		jQuery("table").dataTable(
						
		).columnFilter({ sPlaceHolder: "head:before",
            aoColumns: [
                        { type: "date-range" },//失效日
                        { type: "text" },//點數
                        { type: "select", values:['已使用','未使用'] },//點數狀態
                        { type: "text" },//交易編號
                        { type: "date-range" }//交易日
                        
                        ]
					});
		
	});
</script>

<title>紅利點數記錄</title>
</head>


<body>
	
	<h1>尚有:"EL語法 總點數"點</h1>
	<h4>您有 "EL語法 點數"點,將在"EL語法 失效日"過期</h4>
	<table class="display">
<!-- 	class="display"可以套用到dataTables的css樣式 -->
<!-- 	class="display"可以套用到demo_table.css樣式 -->
		<thead>
			<tr>
				<th >失效日</th>
				<th >點數</th>
				<th >點數狀態</th>
				<th >交易編號</th>
				<th >交易日</th>
			</tr>
			<tr>
				<th >失效日</th>
				<th >點數</th>
				<th >點數狀態</th>
				<th >交易編號</th>
				<th >交易日</th>
			</tr>
		</thead>
	<!-- ------------------------ -->	
		<tbody>
			<tr>
				<td>20160601</td>
				<td>30</td>
				<td>未使用</td>
				<td>A123456789</td>
				<td>2016/06/01</td>
			</tr>
			<tr>
				<td>2016/06/01</td>
				<td>100</td>
				<td>已使用</td>
				<td>AAAAAAAAAA</td>
				<td>2016/06/01</td>
			</tr>
			<tr>
				<td>2016/06/01</td>
				<td>656</td>
				<td>未使用</td>
				<td>BBBBBBBBBB</td>
				<td>2016/06/01</td>
			</tr>
<%--			
 			<c:forEach var="row" items=""> 
			<tr>
				<td>2016/06/01</td>
				<td>30</td>
				<td>未使用</td>
				<td>A123456789</td>
				<td>2016/01/01</td>
			</tr>	
			</c:forEach>
--%>
		</tbody>
	<!-- ------------------------ -->
		<tfoot>
			<tr>
				<th >失效日</th>
				<th >點數</th>
				<th >點數狀態</th>
				<th >交易編號</th>
				<th >交易日</th>
			</tr>
		</tfoot>
	</table>
</body>
</html>