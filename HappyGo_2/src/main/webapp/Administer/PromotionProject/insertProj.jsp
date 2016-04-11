<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增方案</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#PTP_CREATEDATE").datepicker({
			dateFormat: "yy/mm/dd"
		});
	});
	$(function() {
		$("#PTP_DELDATE").datepicker({
			dateFormat: "yy/mm/dd"
		});
	});

	function doNewOtherParameter() {
		//新增其他消費金額
	}
	function showSecondConditionProperty() {
		//if checkbox id=HAVE_PTM_ATRID有被勾選
		//show條件二屬性PTM_ATRID
	}
</script>
</head>
<body>
	<form
		action="<c:url value="/PromotionProject/PromotionProject.controller" />"
		method="get">
		<table height="600px" width="1200px" style="border: 1px solid black"
			align="center">
			<tr style="border: 1px solid black">
				<td style="border: 1px solid black">促銷方案活動名稱：<input type="text"
					name="PTP_NAME"></td>
			</tr>
			<tr>
				<td style="border: 1px solid black">活動內容文字說明：<textarea rows="3"
						cols="50" name="PTP_DESC">請在此輸入活動內容文字說明，最多200個字。</textarea></td>
			</tr>
			<tr>
				<td style="border: 1px solid black">活動狀態(開啟) <input
					type="checkbox" checked="checked" name="PTP_STATUS" value="1">
			</tr>
			<tr>
				<td style="border: 1px solid black">活動時間(永久) <input
					type="checkbox" name="PTP_FOREVER"> <br> 促銷活動生效日期： <input
					type="text" name="PTP_CREATEDATE" id="PTP_CREATEDATE"> <br>
					促銷活動結束日期： <input type="text" name="PTP_DELDATE" id="PTP_DELDATE">
				</td>
			<tr>
				<td style="border: 1px solid black">固定給點 <input type="checkbox"
					id="PTP_FIXPOINT">
				</td>
			</tr>
			<tr>
				<td> 紅利條件：(大於等於)<input type="text" name="PTB_VALUE"
					value="請在此輸入金額">可獲得紅利： <input type="text"
					name="PTB_POINT" value="請在此輸入點數">
				</td>
			</tr>
			<tr>
				<!-- click the button to add new item 新增其他消費金額-->
				<td><div id="showBlock"></div></td>
			</tr>
			<tr>
				<!-- click the button to add new item 新增其他消費金額-->
				<td><input type="button" id="btn" value="新增其它消費金額"></td>
			</tr>
			<tr>
				<td style="border: 1px solid black">進階條件<input type="checkbox"
					id="HAVE_PTM_ATRID"><select size=5 id="PTM_ATRID">
						<option value="HG_Member">1_會員資料
				</select> 進階條件屬性 <select size=5 id="PTM_ATRID">
						<option value="MBR_SEX">1_會員性別
						<option value="MBR_BIRTHDAY">2_會員生日
						<option value="MBR_INTRODUCER">3_介紹人數
				</select> <br> 屬性參數：<input type="text" name="PTM_VALUE" value="請在此輸入參數">可獲得紅利：<input
					type="text" name="PTM_POINT" value="請在此輸入參數"> <br>
					生日(0=當日,1=當週 ,2=當月)性別(0=男,1=女)介紹人(介紹會員人數)
				</td>
			</tr>
			<tr>
				<td style="border: 1px solid black">促銷特店群組<input type="checkbox" name="PPS_STORGPID"
					value="noneGroup">無
				<input type="checkbox" name="PPS_STORGPID"
					value="SOGOGroup">SOGO集團
				<input type="checkbox" name="PPS_STORGPID"
					value="FarEastGroup">遠東集團
				<!--	後續優化，自動生成選項	-->
				<br>
				促銷特約店家
				<input type="checkbox" name="PPS_STOREID" value="noneGroup">阿嬤的古早味
				<input type="checkbox" name="PPS_STOREID" value="SOGOZhongxiao">SOGO忠孝館
				<input type="checkbox" name="PPS_STOREID" value="FarEastBanqiao">板橋大遠百
				<!--	後續優化，自動生成選項	-->
				</td>
			</tr>
			<tr>
				<td align="center"><input type="submit" name="promotionProject"
					value="Insert"></td>
			</tr>
			<tr>
				<td align="center"><input type="button" value="Back"
				onclick="location.href='<c:url value="/Administer/PromotionProject/index.jsp" />'">
				</td>
			</tr>
		</table>
	</form>
	
	
	
	<hr />

	<script>
		//新增其他消費金額
		//set the default value
		var txtId = 1;
		  //add input block in showBlock
		  $("#btn").click(function () {
		      $("#showBlock").append('<div id="div' + txtId + '">紅利條件：(大於等於) <input type="text" name="PTB_VALUE" value="請在此輸入金額"/>可獲得紅利： <input type="text" name="PTB_POINT" value="請在此輸入點數"><input type="button" value="刪除" onclick="deltxt('+txtId+')"></div>');
		      txtId++;
		  });
		  //remove div
		  function deltxt(id) {
		      $("#div"+id).remove();
		  }
	</script>
</body>
</html>