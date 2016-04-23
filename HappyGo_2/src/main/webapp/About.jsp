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
pre {
	clear: none;
}

div.showCode {
	margin-left: 0em;
}

.tabs {
	margin-top: 0.5em;
	clear: left;
	width: 600px;
	height: 700px;
	margin: 10px 0;
}

.ui-tabs {
	
}

.ui-tabs .ui-tabs-nav {
	padding-left: 10em;
	background: rgb(243, 226, 199); /* Old browsers */
	background: -moz-linear-gradient(top, rgba(243, 226, 199, 1) 0%,
		rgba(193, 158, 103, 1) 50%, rgba(182, 141, 76, 1) 51%,
		rgba(233, 212, 179, 1) 100%); /* FF3.6-15 */
	background: -webkit-linear-gradient(top, rgba(243, 226, 199, 1) 0%,
		rgba(193, 158, 103, 1) 50%, rgba(182, 141, 76, 1) 51%,
		rgba(233, 212, 179, 1) 100%); /* Chrome10-25,Safari5.1-6 */
	background: linear-gradient(to bottom, rgba(243, 226, 199, 1) 0%,
		rgba(193, 158, 103, 1) 50%, rgba(182, 141, 76, 1) 51%,
		rgba(233, 212, 179, 1) 100%);
	/* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f3e2c7',
		endColorstr='#e9d4b3', GradientType=0); /* IE6-9 */
	border-radius: 6px;
}

.ui-tabs-nav .ui-state-active {
	border-color: #D4CCB0;
}

.ui-tabs .ui-tabs-panel {
	background: transparent;
	border-width: 0px;
	margin-left: 10em;
}

.ui-tabs-panel p {
	margin-top: 0em;
	width: 93%;
}

.ui-tabs-panel pre.showCode span {
	margin-left: 6em;
}

#minImage {
	margin-left: 6.5em;
}

#minImage img {
	padding: 2px;
	border: 2px solid #448844;
	vertical-align: bottom;
}

#tabs-left {
	position: relative;
	padding-left: 2.9em;
}

#tabs-left .ui-tabs-nav {
	position: absolute;
	left: 0.8em;
	top: 0.25em;
	bottom: 0.25em;
	width: 11em;
	padding: 0.2em 0 0.2em 0.2em;
}

#tabs-left .ui-tabs-nav li {
	right: 1px;
	width: 100%;
	border-right: none;
	border-bottom-width: 1px !important;
	-moz-border-radius: 4px 0px 0px 4px;
	-webkit-border-radius: 4px 0px 0px 4px;
	border-radius: 4px 0px 0px 4px;
	overflow: hidden;
}

#tabs-left .ui-tabs-nav li.ui-tabs-selected, #tabs-left .ui-tabs-nav li.ui-state-active
	{
	border-right: 1px solid transparent;
}

#tabs-left .ui-tabs-nav li a {
	float: right;
	width: 100%;
	text-align: right;
	color: #c575a5;
	text-align: center;
}

#tabs-left .ui-tabs-panel {
	height: 97%;
}

#tabs-left-vertical .ui-tabs-nav {
	position: absolute;
	width: 21em;
	transform: translate(-100%, 0%) rotate(-90deg);
	transform-origin: 100% 0%;
}

#tabs-left-vertical .ui-tabs-nav li {
	float: right;
}

#tabs-left-vertical .ui-tabs-panel {
	
}

#tabs-left-vertical .ui-tabs-panel {
	height: 20em;
}

.menut {
	list-style: none;
	width: 200px;
	margin: 0px auto 0px;
}

.menut li {
	height: 20px;
	overflow: hidden;
	position: relative;
}

.menut li:after {
	content: "";
	display: block;
	height: 1px;
	width: 100%;
	position: absolute;
	bottom: 0px;
	background: -moz-linear-gradient(left, #222, #666, #222);
	background: -webkit-linear-gradient(left, #222, #666, #222);
}

.menut a {
	display: block;
	line-height: 20px;
	text-align: center;
	color: #FFF;
	text-decoration: none;
	-moz-transition: all .3s ease-out;
	-webkit-transition: all .3s ease-out;
}

.menut a:before {
	content: attr(title);
	display: block;
	background: #FFF;
	color: #000;
	margin-top: -20px;
}

.menut a:hover {
	margin-top: 20px;
}
</style>
<body>
	<div id="allpage">
		<c:import url="/common/TopMeau.jsp" />
		<div id="tabs-left" class="demo">
			<div class="wrapper">
				<ul class="ulReset menut">
					<img alt="" src="../img/happygi.png" style="width:10.5em;">
					<li><a href="#tabs-1" title="關於HAPPY GO">ABOUT HAPPY GO</a></li>
					<li><a href="#tabs-2" title="影片介紹">Show MV</a></li>
					<li><a href="#tabs-3" title="卡種說明">Card Type</a></li>
				</ul>
			</div>
			<div id="tabs-3" style="height: 550px; overflow-y: scroll;">
				<table style="width: 570px;">
					<tbody>
						<tr>
							<td><c:if test="${not empty select}">
									<table id="userslist" class="t2"
										style="width: 550px; margin: 0px auto;">
										<tbody>
											<tr>
												<c:forEach var="row" items="${select}" varStatus="varStatus">
													<c:url value="/photo.view" var="path_img" scope="page">
														<c:param name="photoid" value="${row.CDI_CardID}" />
														<c:param name="mode" value="selectitem" />
													</c:url>
													<td><input id="${row.CDI_CardID}_0"
														value="${row.CDI_CardName}" type="hidden"> <input
														id="${row.CDI_CardID}_1" value="${row.CDI_CardInfo}"
														type="hidden"> <input id="${row.CDI_CardID}_2"
														value="${row.CDI_CardName}" type="hidden"> <img
														id="${row.CDI_CardID}" src="${path_img}" alt="photoid"
														height="100" width="160" onclick='showfrom(this);' /></td>
													<c:if test="${ varStatus.count % 3 == 0 }">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
										</tbody>
									</table>
								</c:if></td>
						</tr>
					</tbody>
				</table>
				<div id="users-contain">
					<table id="users" style="width: 550px; height: 300px" class="t2">
						<thead>
							<tr>
								<th>項目</th>
								<th>內容</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img src="" id="selectimg" alt="photoid" height="200"
									width="320" /></td>
								<td rowspan="2" valign="top"><label id="CDI_CardInfo"></label></td>

							</tr>
							<tr>
								<td align="center"><label id="CDI_CardName"></label></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input id="cancel"
									value="確認" type="button"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="tabs-1">
				<p>HAPPY GO為你帶來「每天一點點‧快樂多一點」的生活體驗！擁有HAPPY
					GO卡，讓你每一天都輕鬆享受集點樂趣，從早到晚、不管平日或假日，自己一個人或與朋友在一起，都可使用點數兌換帶來不同的消費感動，讓我們來看看大家是怎麼善用他的HAPPY
					GO卡吧！</p>
				<img width="700" height="520" alt="" src="../img/daily_about.png"
					style="margin-bottom: 1.25em;">
			</div>
			<div id="tabs-2">
				<p>擁有HAPPY GO卡，讓你成為聰明購物家！HAPPY
					GO卡為國內首張聯合集點卡，只要在特約商店消費，皆可集點，並可使用累積點數獲得不同優惠或折抵消費，更可做公益，讓您消費購物的時刻快樂多一點，每分每秒充滿愉悅！
				</p>
				<object width="700" height="520" style="margin-bottom: 1.25em;">
					<param name="movie"
						value="http://www.youtube.com/v/TA1fDnelcM4?fs=1&amp;hl=zh_TW"></param>
					<param name="allowFullScreen" value="true"></param>
					<param name="allowscriptaccess" value="always"></param>
					<embed src="http://www.youtube.com/v/TA1fDnelcM4?fs=1&amp;hl=zh_TW"
						type="application/x-shockwave-flash" allowscriptaccess="always"
						allowfullscreen="true" width="700" height="520"
						style="margin-bottom: 1.25em;"></embed>
				</object>
			</div>
		</div>
		<c:import url="/common/FootBar.jsp" />
	</div>
</body>
<script>
	function showfrom(object) {
		var oid = object.id;
		var ddd = document.getElementById("selectimg");
		var cccc = "/HappyGo_2/photo.view?photoid=" + object.id;
		ddd.src = cccc;
		var c1 = document.getElementById(oid + "_1");
		var c2 = document.getElementById(oid + "_2");
		document.getElementById("CDI_CardInfo").innerText = c1.value;
		document.getElementById("CDI_CardName").innerText = c2.value;
		$('#users-contain').show();
		$('#users-contain').dialog({
			autoOpen : true,
			modal : false,
			width : 580,
			height : 360

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
		if (aryPara["mode"] != null
				&& aryPara["mode"].toString() == "selectitem") {
			//alert(aryPara["mode"].toString());
			$('#users-contain').show();
			$('#users-contain').dialog({
				autoOpen : true,
				modal : false,
				width : 580,
				height : 360
			});
		}
	}
	$("a").button();
	$("#cancel").click(function() {
		$('#users-contain').dialog("close");
	});
	$("#tabs-left").tabs();
	$(function() {
		$("label[name$='_0']").click(function() {
			$(this).css("color", "red");
		});
		$('#users-contain').hide();
		if (aryPara["mode"] != null
				&& (aryPara["mode"].toString() == "edit"
						|| aryPara["mode"].toString() == "selectitem" || aryPara["mode"]
						.toString() == "newitem")) {
			$('#users-contain').show();
			$('#users-contain').dialog({
				open : function() {
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
</script>
</html>