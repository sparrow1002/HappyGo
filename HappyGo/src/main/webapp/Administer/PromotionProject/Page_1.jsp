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
		$("#datepicker1").datepicker();
	});
	$(function() {
		$("#datepicker2").datepicker();
	});
</script>
</head>
<body>
	<form
		action="<c:url value="/PromotionProject/PromotionProject.controller" />"
		method="get">
		<table>
			<tr>
				<td>促銷方案活動名稱：</td>
				<td><input type=text value="請在此輸入活動名稱"
					id="PromotionProjectNnme"></td>
			</tr>
			<tr>
				<td>活動內容文字說明：</td>
				<td><textarea rows="3" cols="50" id="PromotionProjectDESC">請在此輸入活動內容文字說明，最多250個字。</textarea></td>
			</tr>
			<tr>
				<td>常態活動(永久)</td>
				<td><input type="checkbox" id="foreverPromotionProject"></td>
				<td>促銷活動生效日期：</td>
				<td><input type="text" id="datepicker1"></td>
				<td>促銷活動結束日期：</td>
				<td><input type="text" id="datepicker2"></td>
			<tr>
				<td>促銷條件一：</td>
				<td><select size=5>
						<option value="1">1_消費紅利(單一條件)
						<option value="2">2_消費紅利(多條件)
				</select></td>
			</tr>
		</table>
	</form>
	<form name="myForm">
		促銷條件一： <select size=5 onChange="renew(this.selectedIndex);">
			<option value="1">1_消費紅利(單一條件)
			<option value="2">2_消費紅利(多條件)
			<option value="3">3_會員資料紅利
		</select> 促銷條件二： <select name="member" size=5>
			<option value="">請先選取左方屬性
		</select>
	</form>
	<script>
		department = new Array();
		department[0] = [ "1_－－－" ]; // 1_消費紅利(單一條件) ＊＊＊第二個以後的陣列重複，待解決＊＊＊
		department[1] = [ "1_只計算最高", "2_全部累積計算" ]; // 2_消費紅利(多條件)
		department[2] = [ "1_生日", "2_性別", "3_介紹人" ]; // 3_會員資料紅利

		function renew(index) {
			for (var i = 0; i < department[index].length; i++)
				document.myForm.member.options[i] = new Option(
						department[index][i], department[index][i]); // 設定新選項
			document.myForm.member.length = department[index].length; // 刪除多餘的選項
		}
	</script>
	<form name="myForm2">
		滿足條件： <select size=5 onChange="renew2(this.selectedIndex);">
			<option value="1">1_當消費金額
			<option value="2">1_生日當天
			<option value="3">2_生日當週
			<option value="4">3_生日當月
			<option value="5">1_是男生(0)
			<option value="6">2_是女生(1)
			<option value="7">1_介紹的會員數
		</select> 運算子： <select name="member2" size=5>
			<option value="">請先選取左方屬性
		</select>
	</form>
	<script>
		// 		department = new Array();
		// 		department[0] = [
		// 				">",
		// 				">=",
		// 				"<=",
		// 				"<" ]; 					
// 		department[1] = [ "－－－" ]; 								
// 		department[2] = [ "－－－" ];
// 		department[3] = [ "－－－" ];
// 		department[4] = [ "－－－" ];
// 		department[5] = [ "－－－" ];
// 		department[6] = [ "－－－" ];
// 		department[7] = [ ">",
		// 				">=", "<=", "<" ]; //＊＊＊無法顯示，待解決＊＊＊

		// 		function renew(index) {
		// 			for (var i = 0; i < department[index].length; i++)
		// 				document.myForm.member.options[i] = new Option(
		// 						department[index][i], department[index][i]); // 設定新選項
		// 			document.myForm.member.length = department[index].length; // 刪除多餘的選項
		// 		}
	</script>
	<h3>可獲得紅利</h3>
	<input type="text" value="請在此輸入數字" id="PromotionProjectNnme">
	<br>
	<br>
	<h3>促銷特店群組</h3>
	<input type="checkbox" value="請在此輸入數字" id="PromotionProjectNnme">
	<h3>特約店家編號</h3>
	<input type="checkbox" value="請在此輸入數字" id="PromotionProjectNnme">
	<br>
	<br>
	<input type="button" value="確認" id=sureButtonId
		onclick="location.href=''">
	<input type="button" value="上一步" id=backButtonId
		onclick="location.href=''">
</body>
</html>