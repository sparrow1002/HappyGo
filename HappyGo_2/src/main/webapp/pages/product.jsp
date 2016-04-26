<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<link rel="stylesheet" type="text/css"
	href="../jquery-ui-1.11.4.custom/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
<script type="text/javascript" src="../js/jquery-2.2.1.min.js"></script>
<script type="text/javascript"
	src="../jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript" src="../js/product.js"></script>
<script type="text/javascript">
	var path = "${pageContext.request.contextPath}";
	$(document).ready(function() {
		$('input[name="id"]').blur(function() {
			$("img:eq(0)").show();
			var url = path + "/pages/product.view";
			var id = $('input[name="id"]').val();
			//	 	sendRequest("GET", url, id, "textText");
			//	 	sendRequest("POST", url, id, "textXml");
			//	 	sendRequest("POST", url, id, "textJson");
			sendRequestJSON(url, id);
		});
		$(":button").focus(function() {
			$('input[type="text"]').val("");
			$("span").empty("");
		});

		$('input[name="make"]').attr("readonly", "readonly").datepicker({
			appendText : "請輸入YYYY-MM-DD",
			showOn : "focus",
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd",
			defaultDate : "2010-12-01",
		});

	});
</script>
</head>
<body>
	<div id="allpage">
		<c:import url="/common/TopMeau.jsp" />
		<div class="demo" style="width: 946px">
			<form action="<c:url value="/pages/member.controller" />"
				method="get">
				<table class="t2">
					<tr>
						<td align="center" colspan="3">會員中心...(會員資料維護)
							${user.MBR_NAME}</td>
					</tr>
					<tr>
						<td align="right">*會員編號 :</td>
						<td><input type="text" name="MBR_MEMBERID"
							value="${user.MBR_MEMBERID}"><span class="error">${error.MBR_MEMBERID}</span></td>
					</tr>
					<tr>
						<td align="right">*會員姓名 :</td>
						<td><input type="text" name="MBR_NAME"
							value="${user.MBR_NAME}"><span class="error">${error.MBR_NAME}</span></td>
					</tr>
					<tr>
						<td align="right">*密碼 :</td>
						<td><input type="text" name="MBR_PWD" value="${user.MBR_PWD}"><span
							class="error">${error.MBR_PWD}</span></td>
					</tr>
					<tr>
						<td align="right">性別 :</td>
						<td><input type="text" name="MBR_SEX" value="${user.MBR_SEX}"></td>
					</tr>
					<tr>
						<td align="right">生日 :</td>
						<td><input type="text" name="MBR_BIRTHDAY"
							value="${user.MBR_BIRTHDAY}"></td>
					</tr>
					<tr>
						<td align="right">身份證號碼 :</td>
						<td><input type="text" name="MBR_IDENTITY"
							value="${user.MBR_IDENTITY}"></td>
					</tr>
					<tr>
						<td align="right">郵遞區號 :</td>
						<td><input type="text" name="MBR_POST"
							value="${user.MBR_POST}"></td>
					</tr>
					<tr>
						<td align="right">住址 :</td>
						<td><input type="text" name="MBR_ARRDESS"
							value="${user.MBR_ARRDESS}"></td>

					</tr>
					<tr>
						<td align="right">婚姻狀況 :</td>
						<td><input type="text" name="MBR_MARRIED"
							value="${user.MBR_MARRIED}"></td>
					</tr>
					<tr>
						<td align="right">*行動電話 :</td>
						<td><input type="text" name="MBR_MOBIL"
							value="${user.MBR_MOBIL}"> <span class="error">${error.MBR_MOBIL}</span></td>
					</tr>
					<tr>
						<td align="right">住家電話 :</td>
						<td><input type="text" name="MBR_PHONE"
							value="${user.MBR_PHONE}"></td>
					</tr>
					<tr>
						<td align="right">*電子郵件帳號 :</td>
						<td><input type="text" name="MBR_EMAIL"
							value="${user.MBR_EMAIL}"><span class="error">${error.MBR_EMAIL}</span></td>
					</tr>
					<tr>
						<td align="right">資料建立日期 :</td>
						<td><input type="text" name="MBR_CREATEDATE"
							value="${user.MBR_CREATEDATE}"></td>
					</tr>
					<tr>
						<td align="right">交易日期 :</td>
						<td><input type="text" name="MBR_DELDATE"
							value="${user.MBR_DELDATE}"></td>
					</tr>
					<tr>
						<td align="right">紅利點數 :</td>
						<td><input type="text" name="MBR_POINTS"
							value="${user.MBR_POINTS}"></td>
					</tr>
					<tr>
						<td align="right">會員卡狀態 :</td>
						<td><input type="text" name="MBR_STATUS"
							value="${user.MBR_STATUS}"></td>
					</tr>
					<tr>
						<td align="right">介紹人 :</td>
						<td><input type="text" name="NMBR_INTRODUCER"
							value="${user.MBR_INTRODUCER}"></td>
					</tr>
					<tr>
						<td align="right">資料更新日期 :</td>
						<td><input type="text" name="MBR_UPDATETIME"
							value="${user.MBR_UPDATETIME}"></td>
					</tr>
					<tr>
						<td align="right">會員卡使用者更新 :</td>
						<td><input type="text" name="MBR_UPDATEUSER"
							value="${user.MBR_UPDATEUSER}"></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							name="prodaction" value="確定"> <input type="button"
							value="清除欄位" onclick="clearForm()"> <input type="submit"
							name="prodaction" value="回會員中心首頁"></td>
					</tr>
				</table>
			</form>
			<h3>
				<span class="error">${error.action}</span>
			</h3>
			<c:if test="${not empty delete}">
				<h3>Delete Product Table Success : ${delete} row deleted</h3>
				<script type="text/javascript">
					clearForm();
				</script>
			</c:if>
			<c:if test="${not empty insert}">
				<h3>Insert Product Table Success</h3>
				<table class="t2" border="1">
					<tr>
						<td>Id</td>
						<td>${insert.id}</td>
					</tr>
					<tr>
						<td>Name</td>
						<td>${insert.name}</td>
					</tr>
					<tr>
						<td>Price</td>
						<td>${insert.price}</td>
					</tr>
					<tr>
						<td>Make</td>
						<td>${insert.make}</td>
					</tr>
					<tr>
						<td>Expire</td>
						<td>${insert.expire}</td>
					</tr>
				</table>
				<script type="text/javascript">
					clearForm();
				</script>
			</c:if>
			<c:if test="${not empty update}">
				<h3>Update Product Table Success</h3>
				<table class="t2" border="1">
					<tr>
						<td>Id</td>
						<td>${update.id}</td>
					</tr>
					<tr>
						<td>Name</td>
						<td>${update.name}</td>
					</tr>
					<tr>
						<td>Price</td>
						<td>${update.price}</td>
					</tr>
					<tr>
						<td>Make</td>
						<td>${update.make}</td>
					</tr>
					<tr>
						<td>Expire</td>
						<td>${update.expire}</td>
					</tr>
				</table>
				<script type="text/javascript">
					clearForm();
				</script>
			</c:if>
		</div>
		<c:import url="/common/FootBar.jsp" />
	</div>
</body>
</html>