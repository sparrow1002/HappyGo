<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/HappyGo_2/css/main.css">
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
			dateFormat : "yy/mm/dd"
		});
	});
	$(function() {
		$("#PTP_DELDATE").datepicker({
			dateFormat : "yy/mm/dd"
		});
	});

	function clearForm() {
		// 		暫時關閉
		// 		var inputs = document.getElementsByTagName("textarea");
		// 		for(var i=0; i<inputs.length; i++) {
		// 				inputs[i].value="";
		// 		}
	}
</script>
</head>
<body>
	<div id="allpage" style="background-color: #FFDDAA">
		<c:import url="/admin/TopMeau.jsp" />
		<h1></h1>
		<form
			action="<c:url value="/PromotionProject/PromotionProject.controller" />"
			method="get">
			<table height="600px" width="800px" class="t2" align="center">
				<tr style="border: 1px solid black">
					<td  colspan="2" align="center">第一步：請設定促銷活動</td>					
				</tr>
				<tr style="border: 1px solid black">
					<td align="right">促銷方案活動編號：</td>
					<td><input type="text" name="PTP_PROJID" value=""><span
						class="error">${error.pTP_PROJID}</span></td>
				</tr>
				<tr style="border: 1px solid black">
					<td align="right">促銷方案活動名稱：</td>
					<td><input type="text" name="PTP_NAME"><span
						class="error">${error.pTP_NAME}</span></td>
				</tr>
				<tr>
					<td align="right">活動內容文字說明：</td>
					<td><textarea rows="3" cols="50" name="PTP_DESC"
							onfocus="clearForm()">請在此輸入活動內容文字說明，最多200個字。</textarea></td>
				</tr>
				<tr>
					<td align="right">活動狀態(開啟)</td>
					<td><input type="checkbox" checked="checked" name="PTP_STATUS"
						value="1">
				</tr>
				<tr>
					<!-- 需要在Servlet接PTP_FOREVER值且在Service設定一個超久的活動時間，有勾value="1" 沒勾value=null -->
					<td align="right">活動時間(永久)</td>
					<td><input type="checkbox" name="PTP_FOREVER" value="1">
					</td>
				</tr>
				<tr>
					<td align="right">促銷活動生效日期：</td>
					<td><input type="text" name="PTP_CREATEDATE"
						id="PTP_CREATEDATE"><span class="error">${error.PTP_CREATEDATE}</span>
					</td>
				</tr>
				<tr>
					<td align="right">促銷活動結束日期：</td>
					<td><input type="text" name="PTP_DELDATE" id="PTP_DELDATE"><span
						class="error">${error.PTP_DELDATE}</span></td>
				</tr>
				<tr>
					<!-- 4/12與宗保討論，固定給點PTP_FIXPOINT後方給TEXT欄位輸入，需寫入TABLE_HG_PromotionProject -->
					<td align="right">方式一：</td>
					<td>只要消費即可獲得紅利 <input type="text" value="0"
						name="PTP_FIXPOINT"><span class="error">${error.pTP_FIXPOINT}</span>
					</td>
				</tr>
				<tr>
					<!-- 0413需寫入TABLE_HG_PromotionBonus PTB_VALUE跟PTB_POINT需要如何同時輸入多筆，還需確認-->
					<td align="right">方式二：</td>
					<td>消費金額(大於等於)<input type="text" name="PTB_VALUE0" value="0">
						可獲得紅利： <input type="text" name="PTB_POINT0" value="0">
					</td>
				</tr>
				<tr>
					<!-- click the button to add new item 新增其他消費金額-->
					<td align="center" colspan="2"><div id="showBlock"></div></td>
				</tr>
				<tr>
					<!-- click the button to add new item 新增其他消費金額-->
					<td align="center" colspan="2"><input type="button" id="btn"
						value="新增其它消費金額"></td>
				</tr>
				<tr>
					<!-- 4/13與宗保討論：PTM_model需要寫入TABLE_HG_PromotionMethod -->
					<td align="right">方式三： </td><td>
						只要消費時滿足以下條件 <br> 會員屬性 <select name="PTM_model">
							<option value="0">選擇屬性
							<option value="1">1_會員性別
							<option value="2">2_會員生日
							<option value="3">3_介紹人數
					</select> <br> <!-- 4/13與宗保討論：PTM_VALUE需要寫入TABLE_HG_PromotionMethod -->
						屬性參數：<input type="text" name="PTM_VALUE" value="請輸入參數"> <br>
						生日(1=當日,2=當月)性別(0=女,1=男)介紹人(介紹會員人數) <br> <br> <!-- 0413與宗保討論，PTM_NAME需寫入至Table_HG_PromotionMethod -->
						<select name="PTM_NAME">
							<option value="1">可獲得紅利：</option>
							<option value="2">可獲得X倍紅利：</option>
					</select> <input type="text" name="PTM_VARDATE" value="0">
					</td>
				</tr>
				<!-- 			<tr> -->
				<!-- 				<td style="border: 1px solid black">促銷特店群組<input type="checkbox" name="PPS_STORGPID" -->
				<!-- 					value="noneGroup">無 -->
				<!-- 				<input type="checkbox" name="PPS_STORGPID" -->
				<!-- 					value="SOGOGroup">SOGO集團 -->
				<!-- 				<input type="checkbox" name="PPS_STORGPID" -->
				<!-- 					value="FarEastGroup">遠東集團 -->
				<!-- 					後續優化，自動生成選項	 -->
				<!-- 				<br> -->
				<!-- 				促銷特約店家 -->
				<!-- 				<input type="checkbox" name="PPS_STOREID" value="noneGroup">阿嬤的古早味 -->
				<!-- 				<input type="checkbox" name="PPS_STOREID" value="SOGOZhongxiao">SOGO忠孝館 -->
				<!-- 				<input type="checkbox" name="PPS_STOREID" value="FarEastBanqiao">板橋大遠百 -->
				<!-- 					後續優化，自動生成選項	 -->
				<!-- 				</td> -->
				<!-- 			</tr> -->
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="promotionProject" value="Insert"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button"
						value="Back"
						onclick="location.href='<c:url value="/Administer/PromotionProject/index.jsp" />'">
					</td>
				</tr>
			</table>
		</form>
		<hr />
		<h3>
			<span class="error">${error.action}</span>
		</h3>
		<script>
			//新增其他消費金額
			//set the default value
			var txtId = 1;
			//add input block in showBlock
			$("#btn")
					.click(
							function() {
								$("#showBlock")
										.append(
												'<div id="div' + txtId + '">消費金額(大於等於) <input type="text" name="PTB_VALUE'+txtId+'" value="0"/>可獲得紅利： <input type="text" name="PTB_POINT'+txtId+'" value="請在此輸入點數"><input type="button" value="刪除" onclick="deltxt('
														+ txtId + ')"></div>');
								txtId++;
							});
			//remove div
			function deltxt(id) {
				$("#div" + id).remove();
				txtId--;
			}
		</script>
		<c:import url="/admin/FootBar.jsp" />
	</div>
</body>
</html>