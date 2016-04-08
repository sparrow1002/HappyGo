<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ROLE SETTING</title>
<link rel="stylesheet" href="../css/main.css">
<script src="../jquery/jquery-2.1.4.min.js"></script>
<script src="../jquery/jquery-ui.js"></script>
<script src="../jquery/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../jquery/base/jquery-ui-1.9.2.custom.min.css">
<link rel="stylesheet" type="text/css"
	href="../jquery/jquery.dataTables.min.css" />
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
	
	var a = '<%=request.getAttribute("message")%>' ;
	if(a!=null && a!="")
		alert(a);
</script>

</head>
<body>
	<h3>
		<a id="main" href="<c:url value="/admin/main_mag.jsp" />">後台角色主頁 </a>
		<a id="dataprofile"
			href="<c:url value="/dayuNameSpace/rolelist.action?mode=select" />">代碼設定
		</a>
	</h3>
	<div style="width: 800px; height: 600px;">
		<table style="background-color: #F0E68C;">
			<thead>
				<tr>
					<th colspan="2">後台系統使用者管理</th>
				</tr>

			</thead>
			<tbody>
				<tr>
					<td colspan="2"><c:if test="${not empty userlist}">
							<table id="userslist" class="t2">
								<tbody>
									<tr>
										<td><c:forEach var="userlist" items="${userlist}">
												<form
													action='<c:url value="/dayuNameSpace/rolelist.action?mode=select"/>'
													method="get">
													<table>
														<tr>
															<td style="width: 100px">${userlist.value}</td>
															<td><c:forEach var="right" items="${right}">
																	<c:set var="salary" scope="page" value="1" />
																	<c:forEach var="rolelist" items="${rolelist}">
																		<c:if
																			test="${userlist.key==rolelist.ROL_ROLEID && right.RIG_RIGHTID==rolelist.ROL_RIGHTID}">
																			<c:set var="salary" scope="page" value="2" />
																		</c:if>
																	</c:forEach>
																	<c:choose>
																		<c:when test="${salary==2}">
																			<input type="checkbox" id="${right.RIG_RIGHTID}"
																				name="${right.RIG_RIGHTID}" checked="checked" />
																			<label for="${right.RIG_RIGHTID}">${right.RIG_DESC}</label>
																			<br />
																		</c:when>
																		<c:otherwise>
																			<input type="checkbox" id="${right.RIG_RIGHTID}"
																				name="${right.RIG_RIGHTID}" />
																			<label for="${right.RIG_RIGHTID}">${right.RIG_DESC}</label>
																			<br />
																		</c:otherwise>
																	</c:choose>
																</c:forEach></td>
															<td><input type="submit" value="修改"><input type="hidden" name="userid" value="${userlist.key}"><input type="hidden" name="mode" value="edit"></td>
														</tr>
													</table>
												</form>
											</c:forEach></td>
									</tr>
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
								<td><input id="ROL_ROLEID" name="ROL_ROLEID" type="text"
									value=${edit.ROL_ROLEID}></td>
							</tr>
							<tr>
								<td>使用者密碼</td>
								<td><input id="ROL_RIGHTID" name="ROL_RIGHTID" type="text"
									value=${edit.ROL_RIGHTID}></td>
							</tr>
							<tr>
								<td><input name="formSubmit" type="submit" value="儲存" /></td>
								<td><input value="取消" type="button"></td>
							</tr>
						</c:if>
						<c:if test="${not empty selectitem}">
							<tr>
								<td>使用者帳號</td>
								<td>${selectitem.ROL_ROLEID}</td>
							</tr>
							<tr>
								<td>使用者密碼</td>
								<td>${selectitem.ROL_RIGHTID}</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input value="確認"
									type="button"></td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>