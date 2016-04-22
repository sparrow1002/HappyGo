<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="allpage">
		<c:import url="/admin/TopMeau.jsp" />
		<div class="demo">
			<table style="background-color: #F0E68C;">
				<thead>
					<tr>
						<th colspan="2">後台系統紀錄檢視</th>
					</tr>
					<tr>
						<th align="right" style="width: 100px;"><label>使用者ID</label></th>
						<th align="left">
							<form action='<c:url value="/dayuNameSpace/sysloglist.action"/>'
								method="get">
								<input type="text" name="LOG_USERID" value=""> <input
									type="hidden" name="mode" value="selectitem"> <input
									type="submit" value="查詢">
							</form>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2"><c:if test="${not empty select}">
								<table id="userslist" class="t2">
									<thead>
										<tr>
											<th>紀錄編號</th>
											<th>使用者</th>
											<th>紀錄類型</th>
											<th>紀錄說明</th>
											<th>紀錄時間</th>
											<th>紀錄者</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="row" items="${select}">
											<tr>
												<td>${row.LOG_NO}</td>
												<td>${row.LOG_USERID}</td>
												<td>${row.LOG_TYPE}</td>
												<td>${row.LOG_DESC}</td>
												<td>${row.LOG_UPDATETIME}</td>
												<td>${row.LOG_UPDATEUSER}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
<script>
	var strUrl = location.search;
	var getPara, ParaVal;
	var aryPara = [];
	function submi_form() {
		var myForm = document.forms['myForm'];
		var formSubmit = document.getElementById('formSubmit');
		formSubmit.onclick = function() {
			myForm.submit();
		}
	}
	if (strUrl.indexOf("?") != -1) {
		var getSearch = strUrl.split("?");
		getPara = getSearch[1].split("&");
		for (i = 0; i < getPara.length; i++) {
			ParaVal = getPara[i].split("=");
			aryPara.push(ParaVal[0]);
			aryPara[ParaVal[0]] = ParaVal[1];
		}
		//alert(aryPara["mode"]);
		$('#users-contain').hide();
		if (aryPara["mode"] != null && aryPara["mode"].toString() == "edit"
				|| aryPara["mode"].toString() == "selectitem") {

			//alert(aryPara["mode"].toString());
			$('#users-contain').show();
			$('#users-contain').dialog({
				autoOpen : true,
				modal : false
			});
		}
	}
	$("#cancel").click(function() {
		$('#users-contain').dialog("close");
	});
	$(function() {
		var opt = {
			"info" : false,
			"lengthChange" : false,
			"searching" : false,
			"stateSave" : true,
			"oLanguage" : {

				"sProcessing" : "處理中...",
				"sLengthMenu" : "顯示 _MENU_ 項結果",
				"sZeroRecords" : "沒有匹配結果",
				"sInfo" : "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
				"sInfoEmpty" : "顯示第 0 至 0 項結果，共 0 項",
				"sInfoFiltered" : "(從 _MAX_ 項結果過濾)",
				"sSearch" : "搜索:",
				"oPaginate" : {
					"sFirst" : "首頁",
					"sPrevious" : "上頁",
					"sNext" : "下頁",
					"sLast" : "尾頁"
				}
			}
		};
		$('#main').button();
		$('#dataprofile').button();
		$('#userslist').DataTable(opt);
		$('#users-contain').hide();
		if (aryPara["mode"] != null
				&& (aryPara["mode"].toString() == "edit" || aryPara["mode"]
						.toString() == "selectitem")) {
			//alert("test");
			$('#users-contain').show();
			$('#users-contain').dialog({
				open : function() {
					// On open, hide the original submit button
					$(this).find("[type=button]").click(function() {
						$('#users-contain').dialog("close");
					});
				},
				close : function() {
					$('#users-contain').dialog("close");
				}
			});
		}
	});
	
	var message = '<%=request.getAttribute("message")%>
	';
	if (message != null && message.trim() != "" && message.trim() != "null")
		alert(message);
</script>
</html>