<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用者管理</title>

</head>
<body>
	<c:import url="/admin/TopMeau.jsp" />
	<div style="width: 800px; height: 600px;">
		<table style="background-color: #F0E68C;">
			<thead>
				<tr>
					<th colspan="2">後台系統使用者管理</th>
				</tr>
				<tr>
					<th align="right" style="width: 100px;"><label>使用者ID</label></th>
					<th align="left">
						<form action='<c:url value="/dayuNameSpace/maguserlist.action"/>'
							method="get">
							<input type="text" name="ADM_ID" value=""> <input
								type="hidden" name="mode" value="select"> <input
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
										<th>使用者帳號</th>
										<th>使用者密碼</th>
										<th>使用者名稱</th>
										<th>使用者身分</th>
										<th>帳號更新者</th>
										<th>帳號更新日</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="row" items="${select}">
										<c:url value="/dayuNameSpace/maguserlist.action"
											var="path_select" scope="page">
											<c:param name="ADM_ID" value="${row.ADM_ID}" />
											<c:param name="ADM_PWD" value="${row.ADM_PWD}" />
											<c:param name="ADM_NAME" value="${row.ADM_NAME}" />
											<c:param name="ADM_ROLEID" value="${row.ADM_ROLEID}" />
											<c:param name="mode" value="selectitem" />
										</c:url>
										<c:url value="/dayuNameSpace/maguserlist.action"
											var="path_edit" scope="page">
											<c:param name="ADM_ID" value="${row.ADM_ID}" />
											<c:param name="ADM_PWD" value="${row.ADM_PWD}" />
											<c:param name="ADM_NAME" value="${row.ADM_NAME}" />
											<c:param name="ADM_ROLEID" value="${row.ADM_ROLEID}" />
											<c:param name="mode" value="edit" />
										</c:url>
										<tr>
											<td><a href="${path_select}">${row.ADM_ID}</a></td>
											<td>${row.ADM_PWD}</td>
											<td>${row.ADM_NAME}</td>
											<td>${row.ADM_ROLEID}</td>
											<td>${row.ADM_UPDATEUSER}</td>
											<td>${row.ADM_UPDATETIME}</td>
											<td><button
													onclick="window.location.href='${path_edit}'">修改</button></td>
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

		<div id="users-contain" class="ui-widget">
			<form name="myForm" id="myForm"
				action='<c:url value="/dayuNameSpace/maguserlist.action?mode=update"/>'
				method="get">
				<h1>使用者資料</h1>
				<table id="users" class="t2">
					<thead>
						<tr>
							<th>項目</th>
							<th>內容</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty edit}">
							<tr>
								<td>使用者帳號</td>
								<td><input id="ADM_ID" name="ADM_ID" type="text"
									value=${edit.ADM_ID}></td>
							</tr>
							<tr>
								<td>使用者密碼</td>
								<td><input id="ADM_PWD" name="ADM_PWD" type="text"
									value=${edit.ADM_PWD}></td>
							</tr>
							<tr>
								<td>使用者名稱</td>
								<td><input id="ADM_NAME" name="ADM_NAME" type="text"
									value=${edit.ADM_NAME}></td>
							</tr>
							<tr>
								<td>使用者角色</td>
								<td><select size="1" name="ADM_ROLEID">
										<c:forEach var="roleid" items="${roleid}">
											<option value="${roleid.DAP_ID}"
												${(roleid.DAP_ID==edit.ADM_ROLEID)?'selected':'' }>${roleid.DAP_VALUE}
										</c:forEach>
								</select> <!-- <input id="ADM_ROLEID" name="ADM_ROLEID" type="text"
									value=${edit.ADM_ROLEID}><input id="mode" name="mode"
									type="hidden" value="select"> --></td>
							</tr>
							<tr>
								<td colspan="2"><input name="formSubmit" type="submit"
									value="儲存" /><input id="cancel" value="取消" type="button"></td>

							</tr>
						</c:if>
						<c:if test="${not empty selectitem}">
							<tr>
								<td>使用者帳號</td>
								<td>${selectitem.ADM_ID}</td>
							</tr>
							<tr>
								<td>使用者密碼</td>
								<td>${selectitem.ADM_PWD}</td>
							</tr>
							<tr>
								<td>使用者名稱</td>
								<td>${selectitem.ADM_NAME}</td>
							</tr>
							<tr>
								<td>使用者角色</td>
								<td>${selectitem.ADM_ROLEID}</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input id="cancel"
									value="確認" type="button"></td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</form>
		</div>
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
	
	var message = '<%=request.getAttribute("message")%>';
	if (message != null && message.trim() != "" && message.trim() != "null")
		alert(message);
</script>
</html>
