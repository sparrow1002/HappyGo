<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ROLE SETTING</title>
</head>
<body>
<div id="allpage">
	<c:import url="/admin/TopMeau.jsp" />
	<div class="demo">
		<table style="background-color: #F0E68C;">
			<thead>
				<tr>
					<th>後台系統使用者管理</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:if test="${not empty userlist}">
							<table id="userslist" class="t2">
								<tbody>
									<tr>
										<td><c:forEach var="userlist" items="${userlist}">
												<form
													action='<c:url value="/dayuNameSpace/rolelist.action?mode=select"/>'
													method="get">
													<table style="width: 870PX;">
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
															<td><input type="submit" value="修改"> <input
																type="hidden" name="userid" value="${userlist.key}">
																<input type="hidden" name="mode" value="edit"></td>
														</tr>
													</table>
												</form>
											</c:forEach></td>
									</tr>
								</tbody>
							</table>
						</c:if></td>
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
	});
	
	var message = '<%=request.getAttribute("message")%>';
	if (message != null && message != "" && message != "null")
		alert(message);
</script>
</html>