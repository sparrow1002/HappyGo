<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>內部管理網頁</title>
<link rel="stylesheet" href="../css/main.css">
<script src="../jquery/jquery-2.1.4.min.js"></script>
<script src="../jquery/jquery-ui.min.js"></script>
<link rel="stylesheet" href="../jquery/jquery-ui.theme.css">
<style type="text/css">
#menus {
	margin: 0;
	padding: 0;
	list-style: none;
	position: relative;
	width: 600px;
	float: left;
	background: #000;
	border: 10px ridgt #38c2bb;
	border-radius: 20px;
	bgcolor: gold;
	box-shadow: 1px 1px 100px 10px #38c2bb;
}

#menus li {
	margin: 0;
	padding: 0;
	float: left;
	border-right: 1px solid #999;
}

#menus li a {
	padding: 10px 15px;
	display: block;
	color: #fff;
	text-decoration: none;
}

#menus li ul {
	margin: 0;
	padding: 15px 0;
	list-style: none;
	float: left;
	position: absolute;
	left: 0;
	width: 600px;
	color: #fff;
	background: #06c url('bottom.gif') no-repeat bottom;
	display: none;
}

#menus li ul li {
	border-right: 1px solid #fff;
}

#menus li ul li a {
	display: inline;
}

#menus li ul li a:hover {
	text-decoration: underline;
}
</style>
<script type="text/javascript">
	$(function() {
		// 幫 #menu li 加上 hover 事件
		$('#menus>li').hover(
				function() {
					// 先找到 li 中的子選單
					var _this = $(this), _subnav = _this.children('ul');

					// 變更目前母選項的背景顏色
					// 同時滑入子選單(如果有的話)
					_this.css('backgroundColor', '#06c');
					_subnav.stop(true, true).slideDown(400);
				},
				function() {
					// 變更目前母選項的背景顏色
					// 同時滑出子選單(如果有的話)
					// 也可以把整句拆成上面的寫法
					$(this).css('backgroundColor', '').children('ul').stop(
							true, true).slideUp(400);
				});

		// 取消超連結的虛線框
		$('a').focus(function() {
			this.blur();
		});
	});

	function showpage(page) {
		var page1 = document.getElementById("show_1"); //會員資料維護
		var page2 = document.getElementById("show_2"); //新增會員資料
		var page3 = document.getElementById("show_3"); //特店申請核准
		var page4 = document.getElementById("show_4"); //特店資料維護
		var page5 = document.getElementById("show_5"); //新增特店資料
		var page6 = document.getElementById("show_6"); //促銷活動查詢
		var page7 = document.getElementById("show_7"); //新增促銷活動
		var page8 = document.getElementById("show_8"); //會員點數查詢
		var page9 = document.getElementById("show_9"); //特店點數查詢
		var page10 = document.getElementById("show_10"); //點數交易處理查詢
		var page11 = document.getElementById("show_11"); //登入管理
		var page12 = document.getElementById("show_12"); //權限設定
		var page13 = document.getElementById("show_13"); //資料設定
		var page14 = document.getElementById("show_14"); //現金折扣設定
		page1.style.display = "none";
		page2.style.display = "none";
		page3.style.display = "none";
		page4.style.display = "none";
		page5.style.display = "none";
		page6.style.display = "none";
		page7.style.display = "none";
		page8.style.display = "none";
		page9.style.display = "none";
		page10.style.display = "none";
		page11.style.display = "none";
		page12.style.display = "none";
		page13.style.display = "none";
		page14.style.display = "none";
		switch (page) {
		case "1":
			page1.style.display = "inline";
			break;
		case "2":
			page2.style.display = "inline";
			break;
		case "3":
			page3.style.display = "inline";
			break;
		case "4":
			page4.style.display = "inline";
			break;
		case "5":
			page5.style.display = "inline";
			break;
		case "6":
			page6.style.display = "inline";
			break;
		case "7":
			page7.style.display = "inline";
			break;
		case "8":
			page8.style.display = "inline";
			break;
		case "9":
			page9.style.display = "inline";
			break;
		case "10":
			page10.style.display = "inline";
			break;
		case "11":
			page11.style.display = "inline";
			break;
		case "12":
			page12.style.display = "inline";
			break;
		case "13":
			page13.style.display = "inline";
			break;
		case "14":
			page14.style.display = "inline";
			break;
		}
	}
</script>

</head>
<body>
	<div>
		<ul id="menus">
			<li><a href="">會員資料管理</a>
				<ul>
					<li><a onclick="showpage('1');">會員資料維護</a></li>
					<li><a onclick="showpage('2');">新增會員資料</a></li>
				</ul></li>
			<li><a href="">特店資料管理</a>
				<ul>
					<li><a onclick="showpage('3');">特店申請核准</a></li>
					<li><a onclick="showpage('4');">特店資料維護</a></li>
					<li><a onclick="showpage('5');">新增特店資料</a></li>
				</ul></li>
			<li><a href="">促銷活動管理</a>
				<ul>
					<li><a onclick="showpage('6');">促銷活動查詢</a></li>
					<li><a onclick="showpage('7');">新增促銷活動</a></li>
				</ul></li>
			<li><a href="">報表查詢</a>
				<ul>
					<li><a onclick="showpage('8');">會員點數查詢</a></li>
					<li><a onclick="showpage('9');">特店點數查詢</a></li>
					<li><a onclick="showpage('10');">點數交易處理查詢</a></li>
				</ul></li>
			<li><a href="">系統管理</a>
				<ul>
					<li><a onclick="showpage('11');">登入管理</a></li>
					<li><a onclick="showpage('12');">權限設定</a></li>
					<li><a onclick="showpage('13');">資料設定</a></li>
					<!-- <li><a onclick="showpage('14');">現金折扣設定</a></li> -->
				</ul></li>
			<li><a href="../index.jsp">回首頁</a></li>
		</ul>
	</div>
	<div id="show_1" style="display: none;" class="level1">
		<!--會員資料維護  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>會員管理</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員姓名</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="button" value="查詢" /></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'>會員ID</TH>
								<TH bgcolor='#85d6d2'>會員姓名</TH>
								<TH bgcolor='#a9d999'>狀態</TH>
								<TH bgcolor='#85d6d2'></TH>
								<TH bgcolor='#a9d999'></TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>C00000214</TD>
								<TD bgcolor='#85d6d2'>王斐</TD>
								<TD bgcolor='#a9d999'>有效</TD>
								<TD bgcolor='#85d6d2'><input value="檢視"
									onclick="showpage('2');" type="button"></TD>
								<TD bgcolor='#a9d999'><input value="修改"
									onclick="showpage('2');" type="button"></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>C00000327</TD>
								<TD bgcolor='#85d6d2'>林一飛</TD>
								<TD bgcolor='#a9d999'>停權</TD>
								<TD bgcolor='#85d6d2'><input value="檢視"
									onclick="showpage('2');" type="button"></TD>
								<TD bgcolor='#a9d999'><input value="修改"
									onclick="showpage('2');" type="button"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_2" style="display: none;" class="level1">
		<!--新增會員資料  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>會員資料維護</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員帳號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="userid"
						name="userid"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員卡號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="userpwd"
						name="userpwd"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員性別</TD>
					<TD bgcolor='#85d6d2'><select name="sex" size="1" id="sex">
							<option value="1" selected>男</option>
							<option value="2">女</option>
					</select></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">郵遞區號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="post" name="post">
					</TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員地址</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="address"
						name="address"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">婚姻狀況</TD>
					<TD bgcolor='#85d6d2'><select name="sex" size="1" id="sex">
							<option value="1" selected>未婚</option>
							<option value="2">已婚</option>
							<option value="3">離婚</option>
					</select></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員電話</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="phone"
						name="phone"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員手機</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="mobile"
						name="mobile"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">帳號狀況</TD>
					<TD bgcolor='#85d6d2'><select name="sex" size="1" id="sex">
							<option value="1" selected>未認證</option>
							<option value="2">有效</option>
							<option value="3">停權</option>
					</select></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="submit" value="儲存" /> <input value="回首頁"
						onclick="window.location='default.jsp'" type="button"></TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_3" style="display: none;" class="level1">
		<!--特店申請核准  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>特店申請核准</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店姓名</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="button" value="查詢" /></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'>特店ID</TH>
								<TH bgcolor='#85d6d2'>特店名稱</TH>
								<TH bgcolor='#a9d999'>申請日期</TH>
								<TH bgcolor='#85d6d2'></TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>S00000214</TD>
								<TD bgcolor='#85d6d2'>全家忠孝新生店</TD>
								<TD bgcolor='#a9d999'>2015/11/14</TD>
								<TD bgcolor='#85d6d2'><input value="審閱"
									onclick="showpage('4');" type="button"></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>S00000327</TD>
								<TD bgcolor='#85d6d2'>愛買中一路店</TD>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'><input value="審閱"
									onclick="showpage('4');" type="button"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_4" style="display: none;" class="level1">
		<!--特店資料維護  -->
		<form action="" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>特約商店資料</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店姓名</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="button" value="查詢" /></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店代號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="shopcode"
						name="shopcode"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">統一編號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="taccode"
						name="taccode"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店群組</TD>
					<TD bgcolor='#85d6d2'><select name="sex" size="1" id="sex">
							<option value="01" selected>SOGO事業群</option>
							<option value="02">愛買事業群</option>
							<option value="03">全家事業群</option>
							<option value="04">遠傳事業群</option>
							<option value="99">無</option>
					</select></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">郵遞區號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="post" name="post">
					</TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店地址</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="address"
						name="address"></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="submit" value="儲存" /> <input value="回首頁"
						onclick="window.location='index.jsp'" type="button"></TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_5" style="display: none;" class="level1">
		<!--新增特店資料  -->
		<form action="" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>新增特約商店資料</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店代號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="shopcode"
						name="shopcode"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">統一編號</TD>
					<TD bgcolor='#85d6d2'><input type="date" id="startdate"
						name="startdate">~</TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店群組</TD>
					<TD bgcolor='#85d6d2'><select name="sex" size="1" id="sex">
							<option value="01" selected>SOGO事業群</option>
							<option value="02">愛買事業群</option>
							<option value="03">全家事業群</option>
							<option value="04">遠傳事業群</option>
							<option value="99">無</option>
					</select></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">郵遞區號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="post" name="post">
					</TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店地址</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="address"
						name="address"></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="submit" value="儲存" /> <input value="回首頁"
						onclick="window.location='index.jsp'" type="button"></TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_6" style="display: none;" class="level1">
		<!--促銷活動查詢  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>促銷活動查詢</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="shopcode"
						name="shopcode"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店名稱</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="shopcode"
						name="shopcode"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">查詢期間</TD>
					<TD bgcolor='#85d6d2'><input type="date" id="startdate"
						name="startdate">~ <input type="date" id="enddate"
						name="enddate""></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="button" value="查詢" /></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'>促銷活動代碼</TH>
								<TH bgcolor='#85d6d2'>促銷活動名稱</TH>
								<TH bgcolor='#a9d999'>促銷生效日</TH>
								<TH bgcolor='#85d6d2'>促銷結束日</TH>
								<TH bgcolor='#a9d999'>促銷活動狀態</TH>
								<TH bgcolor='#85d6d2'>促銷活動說明</TH>
								<TH bgcolor='#a9d999'></TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>C050712</TD>
								<TD bgcolor='#85d6d2'>耶誕促銷活動</TD>
								<TD bgcolor='#a9d999'>2015/11/20</TD>
								<TD bgcolor='#85d6d2'>2015/12/21</TD>
								<TD bgcolor='#a9d999'>失效</TD>
								<TD bgcolor='#85d6d2'>買千送百，額外送點</TD>
								<TD bgcolor='#a9d999'><input type="button" value="設定" /></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>C050717</TD>
								<TD bgcolor='#85d6d2'>歡度耶誕活動</TD>
								<TD bgcolor='#a9d999'>2015/12/10</TD>
								<TD bgcolor='#85d6d2'>2015/12/31</TD>
								<TD bgcolor='#a9d999'>失效</TD>
								<TD bgcolor='#85d6d2'>買萬送千</TD>
								<TD bgcolor='#a9d999'><input type="button" value="設定" /></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>C050741</TD>
								<TD bgcolor='#85d6d2'>慶賀新年特銷</TD>
								<TD bgcolor='#a9d999'>2015/12/20</TD>
								<TD bgcolor='#85d6d2'>2016/01/05</TD>
								<TD bgcolor='#a9d999'>失效</TD>
								<TD bgcolor='#85d6d2'>滿額消費額外送50點</TD>
								<TD bgcolor='#a9d999'><input type="button" value="設定" /></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>C050792</TD>
								<TD bgcolor='#85d6d2'>封館促銷活動</TD>
								<TD bgcolor='#a9d999'>2016/01/10</TD>
								<TD bgcolor='#85d6d2'>2016/01/21</TD>
								<TD bgcolor='#a9d999'>失效</TD>
								<TD bgcolor='#85d6d2'>滿額贈點，額外送100點</TD>
								<TD bgcolor='#a9d999'><input type="button" value="設定" /></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>C050811</TD>
								<TD bgcolor='#85d6d2'>歡度過年活動</TD>
								<TD bgcolor='#a9d999'>2016/01/20</TD>
								<TD bgcolor='#85d6d2'>2016/02/05</TD>
								<TD bgcolor='#a9d999'>有效</TD>
								<TD bgcolor='#85d6d2'>買萬送千</TD>
								<TD bgcolor='#a9d999'><input type="button" value="設定" /></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>C050921</TD>
								<TD bgcolor='#85d6d2'>慶賀新年特銷</TD>
								<TD bgcolor='#a9d999'>2016/02/01</TD>
								<TD bgcolor='#85d6d2'>2016/02/15</TD>
								<TD bgcolor='#a9d999'>未生效</TD>
								<TD bgcolor='#85d6d2'>滿額消費額外送50點</TD>
								<TD bgcolor='#a9d999'><input type="button" value="設定" /></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_7" style="display: none;" class="level1">
		<!--新增促銷活動 -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>新增促銷活動</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">促銷活動代號</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="shopcode"
						name="shopcode"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">促銷活動名稱</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="taccode"
						name="taccode"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">促銷活動生效日</TD>
					<TD bgcolor='#85d6d2'><input type="date" id="enddate"
						name="enddate" /></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">促銷活動結束日</TD>
					<TD bgcolor='#85d6d2'><input type="date" id="enddate"
						name="enddate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">促銷活動封面</TD>
					<TD bgcolor='#85d6d2'><input type="button" id="address"
						name="address" value="上傳圖片"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">促銷活動說明</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="address"
						name="address"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">促銷活動特店</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="address"
						name="address"> <input type="button" value="新增" /><BR />
						<select name="sex" size="1" id="sex">
							<option value="01" selected>SOGO事業群</option>
							<option value="02">愛買事業群</option>
							<option value="03">全家事業群</option>
							<option value="04">遠傳事業群</option>
							<option value="99">無</option>
					</select></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="submit" value="儲存" /> <input value="回首頁"
						onclick="window.location='index.jsp'" type="button"></TD>
				</TR>
			</TABLE>
			<TABLE>
				
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'>特店代碼</TH>
								<TH bgcolor='#85d6d2'>特店名稱</TH>
								<TH bgcolor='#a9d999'></TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>S000000132</TD>
								<TD bgcolor='#85d6d2'>全家光幕店</TD>
								<TD bgcolor='#a9d999'>2015/11/20</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>S000000151</TD>
								<TD bgcolor='#85d6d2'>全家光雄店</TD>
								<TD bgcolor='#a9d999'>2015/12/10</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_8" style="display: none;" class="level1">
		<!--會員點數查詢  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>會員點數交易查詢</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員姓名</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">查詢期間</TD>
					<TD bgcolor='#85d6d2'><input type="date" id="startdate"
						name="startdate">~ <input type="date" id="enddate"
						name="enddate""></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="button" value="查詢" /></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'>消費日</TH>
								<TH bgcolor='#85d6d2'>消費地點</TH>
								<TH bgcolor='#a9d999'>消費金額</TH>
								<TH bgcolor='#85d6d2'>折抵金額</TH>
								<TH bgcolor='#a9d999'>消費給點</TH>
								<TH bgcolor='#85d6d2'>折抵點數</TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_9" style="display: none;" class="level1">
		<!--特店點數查詢  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>特店點數交易查詢</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店名稱</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">查詢期間</TD>
					<TD bgcolor='#85d6d2'><input type="date" id="startdate"
						name="startdate">~ <input type="date" id="enddate"
						name="enddate""></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="button" value="查詢" /></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'>消費日</TH>
								<TH bgcolor='#85d6d2'>消費地點</TH>
								<TH bgcolor='#a9d999'>消費金額</TH>
								<TH bgcolor='#85d6d2'>折抵金額</TH>
								<TH bgcolor='#a9d999'>消費給點</TH>
								<TH bgcolor='#85d6d2'>折抵點數</TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/15</TD>
								<TD bgcolor='#85d6d2'>全家光復南路店</TD>
								<TD bgcolor='#a9d999'>550</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>5</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21</TD>
								<TD bgcolor='#85d6d2'>SOGO南金店</TD>
								<TD bgcolor='#a9d999'>24,000</TD>
								<TD bgcolor='#85d6d2'>200</TD>
								<TD bgcolor='#a9d999'>200</TD>
								<TD bgcolor='#85d6d2'>10</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_10" style="display: none;" class="level1">
		<!--點數交易處理  -->
		<form action="main_mag.jsp" method="get"></form>
	</div>
	<div id="show_11" style="display: none;" class="level1">
		<!--登入管理  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>登入管理查詢</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">特店名稱</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員ID</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">會員姓名</TD>
					<TD bgcolor='#85d6d2'><input type="text" id="startdate"
						name="startdate"></TD>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">查詢期間</TD>
					<TD bgcolor='#85d6d2'><input type="date" id="startdate"
						name="startdate">~ <input type="date" id="enddate"
						name="enddate""></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center"><input
						type="button" value="查詢" /></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'>登入日期</TH>
								<TH bgcolor='#85d6d2'>登入者</TH>
								<TH bgcolor='#a9d999'>系統代碼</TH>
								<TH bgcolor='#85d6d2'>系統紀錄</TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21 12:30:24</TD>
								<TD bgcolor='#85d6d2'>C000012148</TD>
								<TD bgcolor='#a9d999'>CA05</TD>
								<TD bgcolor='#85d6d2'>會員:C000012148系統登入</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>2015/12/21 12:30:24</TD>
								<TD bgcolor='#85d6d2'>C000012148</TD>
								<TD bgcolor='#a9d999'>CA07</TD>
								<TD bgcolor='#85d6d2'></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_12" style="display: none;" class="level1">
		<!--權限設定  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>系統權限設定</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">使用者類型</TD>
					<TD bgcolor='#85d6d2'><select name="sex" size="1" id="sex">
							<option value="01" selected>會員</option>
							<option value="02">特店</option>
							<option value="03">線上客服</option>
							<option value="04">管理者</option>
					</select></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'></TH>
								<TH bgcolor='#85d6d2'>權限代碼</TH>
								<TH bgcolor='#a9d999'>權限名稱</TH>
								<TH bgcolor='#85d6d2'>對應網頁</TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'><input type="checkbox" id="startdate"
									name="startdate"></TD>
								<TD bgcolor='#85d6d2'>C01</TD>
								<TD bgcolor='#a9d999'>會員資料維護</TD>
								<TD bgcolor='#85d6d2'>cus_2.jsp</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'><input type="checkbox" id="startdate"
									name="startdate"></TD>
								<TD bgcolor='#85d6d2'>C02</TD>
								<TD bgcolor='#a9d999'>即時點數查詢</TD>
								<TD bgcolor='#85d6d2'>cus_3.jsp</TD>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'><input type="checkbox" id="startdate"
									name="startdate"></TD>
								<TD bgcolor='#85d6d2'>C03</TD>
								<TD bgcolor='#a9d999'>點數交易查詢</TD>
								<TD bgcolor='#85d6d2'>cus_4.jsp</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_13" style="display: none;" class="level1">
		<!--資料設定  -->
		<form action="main_mag.jsp" method="get">
			<TABLE>
				<TR>
					<TH colspan='2' bgcolor='#d4edec'><label>基本資料設定</label></TH>
				</TR>
				<TR>
					<TD bgcolor='#bce6e4' align="right">代碼群組</TD>
					<TD bgcolor='#85d6d2'><select name="sex" size="1" id="sex">
							<option value="01" selected>性別</option>
							<option value="02">會員狀態</option>
							<option value="03">特店狀態</option>
							<option value="04">特銷狀態</option>
							<option value="04">折扣現金比率</option>
							<option value="04">交易換點比率</option>
					</select>
					<input type="button" id="startdate"
									name="startdate"  value="新增群組項目"></TD>
				</TR>
				<TR>
					<TD colspan='2' bgcolor='#d4edec' align="center">
						<TABLE>
							<TR>
								<TH bgcolor='#a9d999'>代碼ID</TH>
								<TH bgcolor='#85d6d2'>代碼數值</TH>
								<TH bgcolor='#a9d999'>代碼說明</TH>
								<TH bgcolor='#85d6d2'></TH>
							</TR>
							<TR>
								<TD bgcolor='#a9d999'>1</TD>
								<TD bgcolor='#85d6d2'>男</TD>
								<TD bgcolor='#a9d999'>性別-男</TD>
								<TD bgcolor='#85d6d2'><input type="button" id="startdate"
									name="startdate"  value="修改"></TD>
							</TR>
						<TR>
								<TD bgcolor='#a9d999'>2</TD>
								<TD bgcolor='#85d6d2'>女</TD>
								<TD bgcolor='#a9d999'>性別-女</TD>
								<TD bgcolor='#85d6d2'><input type="button" id="startdate"
									name="startdate"  value="修改"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</form>
	</div>
	<div id="show_14" style="display: none;" class="level1">
		<!--現金折扣設定  -->
		<form action="main_mag.jsp" method="get"></form>
	</div>
</body>
</html>