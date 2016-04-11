<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改方案</title>
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
		<table height="600px" width="600px" style="border: 1px solid black" align="center">
			<tr style="border: 1px solid black">
				<td>促銷方案活動編號：<input type=text value="" name="PTP_PROJID"></td>
			</tr>
			<tr style="border: 1px solid black">
				<td>促銷方案活動名稱：<input type=text value="請在此輸入活動名稱" name="PTP_NAME"></td>
			</tr>
			</p>
			<tr style="border: 1px solid black">
				<td>活動內容文字說明：<textarea rows="3" cols="50" name="PTP_DESC">請在此輸入活動內容文字說明，最多200個字。</textarea></td>
			</tr>
			<tr style="border: 1px solid black">
				<td>活動狀態(開啟)<input type="checkbox" name="PTP_STATUS" value="1" ></td>
				
				<!-- 				<td>常態活動(永久)</td>
				 					<td><input type="checkbox" id="Timeliness"></td> -->
				<td style="border: 1px solid black">促銷活動生效日期：</td>
				<td style="border: 1px solid black"><input type="text" name="PTP_CREATEDATE" id="PTP_CREATEDATE"></td>
				<td style="border: 1px solid black">促銷活動結束日期：</td>
				<td style="border: 1px solid black"><input type="text" name="PTP_DELDATE" id="PTP_DELDATE"></td>
			<tr>
				<td>紅利條件：<select size=5>
						<option value="singleCondition">1_消費紅利(單一條件)
						<option value="moreCondition">2_消費紅利(多條件)
				</select></td>
				<td>>= (大於等於)</td>
				<td><input type="text" name="PTB_VALUE" value="請在此輸入參數"></td>
				<td>可獲得紅利</td>
				<td><input type="text" name="PTB_POINT" value="請在此輸入參數"></td>
			</tr>
			<tr>
				<td><input type="button" value="新增其它消費金額" id=NewOtherParameter
					onclick="doNewOtherParameter()"></td>
			</tr>
			<tr>
				<td>進階條件<input type="checkbox" id="HAVE_PTM_ATRID"><select
					size=5 id="PTM_ATRID">
						<option value="HG_Member" >1_會員資料
				</select>
			</tr>
			<tr>
				<td>進階條件屬性 <select size=5 id="PTM_ATRID">
						<option value="MBR_SEX">1_會員性別
						<option value="MBR_BIRTHDAY">2_會員生日
						<option value="MBR_INTRODUCER">3_介紹人數
				</select></td>
				<td>生日(0=當日,1=當週 ,2=當月)性別(0=男,1=女)介紹人(介紹會員人數)</td>
				<td><input type="text" name="PTM_VALUE" value="請在此輸入參數"></td>
				<td>可獲得紅利</td>
				<td><input type="text" name="PTM_POINT" value="請在此輸入參數"></td>
			</tr>
			<tr>
				<td>促銷特店群組</td>
				<td><input type="checkbox" name="PPS_STORGPID"
					value="noneGroup">無</td>
				<td><input type="checkbox" name="PPS_STORGPID"
					value="SOGOGroup">SOGO集團</td>
				<td><input type="checkbox" name="PPS_STORGPID"
					value="FarEastGroup">遠東集團</td>
				<!--	後續優化，自動生成選項	-->
			</tr>
			<tr>
				<td>促銷特約店家</td>
				<td><input type="checkbox" name="PPS_STOREID" value="noneGroup">阿嬤的古早味</td>
				<td><input type="checkbox" name="PPS_STOREID"
					value="SOGOZhongxiao">SOGO忠孝館</td>
				<td><input type="checkbox" name="PPS_STOREID"
					value="FarEastBanqiao">板橋大遠百</td>
				<!--	後續優化，自動生成選項	-->
				<td></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" name="promotionProject"
					value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>