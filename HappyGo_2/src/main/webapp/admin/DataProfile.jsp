<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
input {
	width: 100px;
}
</style>
<body>
	<div id="allpage">
		<c:import url="/admin/TopMeau.jsp" />
		<div class="demo">
			<table style="background-color: #F0E68C;">
				<thead>
					<tr>
						<th colspan="2">後台系統代碼管理</th>
					</tr>
					<tr>
						<th align="right" style="width: 100px;"><label>代碼群組</label></th>
						<th align="left" style="width: 280px;">
							<form
								action='<c:url value="/dayuNameSpace/dataprofilelist.action"/>'
								method="get">
								<input type="text" name="DAP_GROUP" value=""> <input
									type="hidden" name="mode" value="select"> <input
									type="submit" value="查詢">
							</form>

						</th>
						<th align="left">
							<form
								action='<c:url value="/dayuNameSpace/dataprofilelist.action"/>'
								method="get">
								<input type="button" onclick="showfrom('insert','');" value="新增">
							</form>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="3"><c:if test="${not empty select}">
								<table id="userslist" class="t2">
									<thead>
										<tr>
											<th>代碼群組</th>
											<th>代碼編號</th>
											<th>代碼文字</th>
											<th>代碼描述</th>
											<th>代碼更新者</th>
											<th>代碼更新日</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="row" items="${select}" varStatus="varStatus">
											<c:url value="/dayuNameSpace/dataprofilelist.action"
												var="path_edit" scope="page">
												<c:param name="DAP_GROUP" value="${row.DAP_GROUP}" />
												<c:param name="DAP_ID" value="${row.DAP_ID}" />
												<c:param name="DAP_VALUE" value="${row.DAP_VALUE}" />
												<c:param name="DAP_DESC" value="${row.DAP_DESC}" />
												<c:param name="mode" value="edit" />
											</c:url>
											<tr>
												<td><input id="DAP_GROUP__${varStatus.count}"
													name="DAP_GROUP" type="text" value="${row.DAP_GROUP}"
													style="display: none"> <lable
														id="DAP_GROUP_${varStatus.count}" name="DAP_GROUP">${row.DAP_GROUP}</lable></td>
												<td><input id="DAP_ID__${ varStatus.count}" type="text"
													value="${row.DAP_ID}" style="display: none"> <lable
														id="DAP_ID_${varStatus.count}" name="DAP_ID">${row.DAP_ID}</lable></td>
												<td><input id="DAP_VALUE__${ varStatus.count}"
													type="text" value="${row.DAP_VALUE}" style="display: none">
													<lable id="DAP_VALUE_${varStatus.count}" name="DAP_VALUE">${row.DAP_VALUE}</lable></td>
												<td><input id="DAP_DESC__${ varStatus.count}"
													type="text" value="${row.DAP_DESC}" style="display: none">
													<lable id="DAP_DESC_${varStatus.count}" name="DAP_DESC">${row.DAP_DESC}</lable></td>
												<td><input id="DAP_UPDATEUSER__${ varStatus.count}"
													type="text" value="${row.DAP_UPDATEUSER}"
													style="display: none"> <lable
														id="DAP_UPDATEUSER_${varStatus.count}" name="DAP_GROUP">${row.DAP_UPDATEUSER}</lable></td>
												<td><input id="DAP_UPDATETIME__${ varStatus.count}"
													type="text" value="${row.DAP_UPDATETIME}"
													style="display: none"> <lable
														id="DAP_UPDATETIME_${varStatus.count}" name="DAP_GROUP">${row.DAP_UPDATETIME}</lable></td>
												<td><input type="button"
													onclick="showfrom('update','${varStatus.count}');"
													value="修改"></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if></td>
					</tr>
				</tbody>
			</table>
			<div id="users-contain" class="ui-widget">
				<form name="myForm" id="myForm"
					action='<c:url value="/dayuNameSpace/dataprofilelist.action?mode=update"/>'
					method="get">
					<h1>代碼項目</h1>
					<table id="users" class="t2">
						<thead>
							<tr>
								<th>項目</th>
								<th>內容</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>代碼群組</td>
								<td><input id="DAP_GROUP" name="DAP_GROUP" type="text"></td>
							</tr>
							<tr>
								<td>代碼編號</td>
								<td><input id="DAP_ID" name="DAP_ID" type="text"></td>
							</tr>
							<tr>
								<td>代碼文字</td>
								<td><input id="DAP_VALUE" name="DAP_VALUE" type="text"></td>
							</tr>
							<tr>
								<td>代碼描述</td>
								<td><input id="DAP_DESC" name="DAP_DESC" type="text"></td>
							</tr>
							<tr>
								<td colspan="2"><input name="formSubmit" type="submit"
									value="儲存" /> <input id="cancel" value="取消" type="button">
									<input id="mode" name="mode" type="hidden" value="update" /></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
<script>	
	function showfrom(mode,index) {
		if(index!='')
		{			
			$('#DAP_GROUP').val($('#DAP_GROUP__'+index).val());
			$('#DAP_ID').val($('#DAP_ID__'+index).val());
			$('#DAP_VALUE').val($('#DAP_VALUE__'+index).val());
			$('#DAP_DESC').val($('#DAP_DESC__'+index).val());
		}else{
			$('#DAP_GROUP').val('');
			$('#DAP_ID').val('');
			$('#DAP_VALUE').val('');
			$('#DAP_DESC').val('');			
		}
		$('#mode').val(mode);
		$('#users-contain').show();
		$('#users-contain').dialog({
			autoOpen : true,
			modal : false
		});
	}
	
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
				|| aryPara["mode"].toString() == "selectitem"
				|| aryPara["mode"].toString() == "new") {

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
				&& (aryPara["mode"].toString() == "edit" || aryPara["mode"].toString() == "selectitem"|| aryPara["mode"].toString() == "newitem")) {
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

	var message = '<%=request.getAttribute("message")%>';
	if (message != null && message.trim() != "" && message.trim() != "null")
		$.MessageBox(message);
</script>
</html>
