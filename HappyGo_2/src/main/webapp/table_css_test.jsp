<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*.tableEff *.tWrapper {
	width: 80%;
}

*.tableEff table {
	width: 100%;
	border-collapse: collapse;
}

*.tableEff caption {
	background: #63C;
	color: white;
	text-align: center;
	padding: 0.5em;
	font-size: 125%;
}

*.tableEff caption *.notes {
	float: right;
	margin-top: 0.3em;
	font-size: 80%;
}

*.tableEff col:first-of-type {
	min-width: 4em;
}

*.tableEff col:nth-of-type(2) {
	width: 4em;
}

*.tableEff col:nth-of-type(3) {
	width: 4em;
}

*.tableEff col:last-of-type {
	width: 7em;
}

*.tableEff thead {
	background: #FFee00;
}

*.tableEff tbody tr, *.tableEff td {
	transition: all 0.5s;
}

*.tableEff th {
	font-weight: normal;
	padding: 0.5em 0.1em;
}

*.tableEff td {
	text-align: center;
}

*.tableEff tbody th, *.tableEff td {
	border: 1px solid white;
}

*.tableEff tbody tr:nth-child(2n) {
	background: #e3e3ff;
}

*.tableEff tbody tr:hover {
	background: #ecf;
}

*.tableEff tbody tr:nth-child(2n):hover {
	background: #ccf;
}

*.tableEff tbody tr:hover td:hover {
	background: blue;
	color: white;
	box-shadow: 3px 3px 2px rgba(0, 0, 0, 0.4);
}




</style>
</head>
<body>
	<header>
	<h1>
		<abbr title="Cascading Style Sheet" lang="en">css</abbr> 玩視覺特效<img
			src="http://webchain.oreilly.tw/boohover/images/boohover.png"
			style="display: none">
	</h1>
	</header>	
	<article class="tableEff">
	<div class="tWrapper">
		<table>
			<caption>
				氣溫觀測 <span class="notes">單位：攝氏度</span>
			</caption>
			<col>
			<col span="12">
			<col>
			<col>
			<thead>
				<tr>
					<th>地名</th>
					<th axis="month">一月</th>
					<th axis="month">二月</th>
					<th axis="month">三月</th>
					<th axis="month">四月</th>
					<th axis="month">五月</th>
					<th axis="month">六月</th>
					<th axis="month">七月</th>
					<th axis="month">八月</th>
					<th axis="month">九月</th>
					<th axis="month">十月</th>
					<th axis="month">十一月</th>
					<th axis="month">十二月</th>
					<th>平均</th>
					<th>統計期間</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th axis="item">淡水</th>
					<td>15.2</td>
					<td>15.6</td>
					<td>17.4</td>
					<td>21.1</td>
					<td>24.5</td>
					<td>26.9</td>
					<td>28.8</td>
					<td>28.6</td>
					<td>26.7</td>
					<td>23.7</td>
					<td>20.6</td>
					<td>16.9</td>
					<td>22.2</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">鞍部</th>
					<td>10.1</td>
					<td>10.9</td>
					<td>13.0</td>
					<td>16.4</td>
					<td>19.4</td>
					<td>21.8</td>
					<td>23.2</td>
					<td>22.9</td>
					<td>21.0</td>
					<td>17.9</td>
					<td>14.9</td>
					<td>11.4</td>
					<td>16.9</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">臺北</th>
					<td>16.1</td>
					<td>16.5</td>
					<td>18.5</td>
					<td>21.9</td>
					<td>25.2</td>
					<td>27.7</td>
					<td>29.6</td>
					<td>29.2</td>
					<td>27.4</td>
					<td>24.5</td>
					<td>21.5</td>
					<td>17.9</td>
					<td>23</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">竹子湖</th>
					<td>11.8</td>
					<td>12.5</td>
					<td>14.7</td>
					<td>18.0</td>
					<td>21.0</td>
					<td>23.3</td>
					<td>24.8</td>
					<td>24.6</td>
					<td>22.7</td>
					<td>19.8</td>
					<td>16.8</td>
					<td>13.3</td>
					<td>18.6</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">基隆</th>
					<td>16.0</td>
					<td>16.2</td>
					<td>17.9</td>
					<td>21.3</td>
					<td>24.5</td>
					<td>27.3</td>
					<td>29.3</td>
					<td>28.9</td>
					<td>27.0</td>
					<td>24.1</td>
					<td>21.2</td>
					<td>17.7</td>
					<td>22.6</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">彭佳嶼</th>
					<td>15.7</td>
					<td>15.9</td>
					<td>17.5</td>
					<td>20.4</td>
					<td>23.4</td>
					<td>26.0</td>
					<td>28.0</td>
					<td>27.9</td>
					<td>26.3</td>
					<td>23.7</td>
					<td>20.7</td>
					<td>17.4</td>
					<td>21.9</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">花蓮</th>
					<td>18.0</td>
					<td>18.4</td>
					<td>20.2</td>
					<td>22.7</td>
					<td>25.1</td>
					<td>27.1</td>
					<td>28.5</td>
					<td>28.2</td>
					<td>26.8</td>
					<td>24.8</td>
					<td>22.2</td>
					<td>19.3</td>
					<td>23.4</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">蘇澳</th>
					<td>16.4</td>
					<td>16.9</td>
					<td>18.8</td>
					<td>21.6</td>
					<td>24.4</td>
					<td>26.9</td>
					<td>28.6</td>
					<td>28.2</td>
					<td>26.6</td>
					<td>23.8</td>
					<td>20.9</td>
					<td>17.7</td>
					<td>22.6</td>
					<td>1982-2010</td>
				</tr>
				<tr>
					<th axis="item">宜蘭</th>
					<td>16.3</td>
					<td>16.9</td>
					<td>18.9</td>
					<td>21.7</td>
					<td>24.4</td>
					<td>26.8</td>
					<td>28.6</td>
					<td>28.3</td>
					<td>26.5</td>
					<td>23.6</td>
					<td>20.6</td>
					<td>17.5</td>
					<td>22.5</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">東吉島</th>
					<td>17.8</td>
					<td>18.2</td>
					<td>20.3</td>
					<td>23.3</td>
					<td>25.7</td>
					<td>27.4</td>
					<td>28.4</td>
					<td>28.2</td>
					<td>27.3</td>
					<td>25.3</td>
					<td>22.7</td>
					<td>19.6</td>
					<td>23.7</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">澎湖</th>
					<td>16.9</td>
					<td>17.1</td>
					<td>19.5</td>
					<td>23.0</td>
					<td>25.7</td>
					<td>27.6</td>
					<td>28.7</td>
					<td>28.6</td>
					<td>27.8</td>
					<td>25.4</td>
					<td>22.4</td>
					<td>18.9</td>
					<td>23.5</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">臺南</th>
					<td>17.6</td>
					<td>18.6</td>
					<td>21.2</td>
					<td>24.5</td>
					<td>27.2</td>
					<td>28.5</td>
					<td>29.2</td>
					<td>28.8</td>
					<td>28.1</td>
					<td>26.1</td>
					<td>22.8</td>
					<td>19.1</td>
					<td>24.3</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">高雄</th>
					<td>19.3</td>
					<td>20.3</td>
					<td>22.6</td>
					<td>25.4</td>
					<td>27.5</td>
					<td>28.5</td>
					<td>29.2</td>
					<td>28.7</td>
					<td>28.1</td>
					<td>26.7</td>
					<td>24.0</td>
					<td>20.6</td>
					<td>25.1</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">嘉義</th>
					<td>16.5</td>
					<td>17.3</td>
					<td>19.7</td>
					<td>23.0</td>
					<td>25.8</td>
					<td>27.8</td>
					<td>28.6</td>
					<td>28.2</td>
					<td>27.0</td>
					<td>24.5</td>
					<td>21.3</td>
					<td>17.7</td>
					<td>23.1</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">臺中</th>
					<td>16.6</td>
					<td>17.3</td>
					<td>19.6</td>
					<td>23.1</td>
					<td>26.0</td>
					<td>27.6</td>
					<td>28.6</td>
					<td>28.3</td>
					<td>27.4</td>
					<td>25.2</td>
					<td>21.9</td>
					<td>18.1</td>
					<td>23.3</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">阿里山</th>
					<td>6.2</td>
					<td>7.2</td>
					<td>9.3</td>
					<td>11.4</td>
					<td>12.9</td>
					<td>14.2</td>
					<td>14.6</td>
					<td>14.4</td>
					<td>13.7</td>
					<td>12.3</td>
					<td>10.3</td>
					<td>7.3</td>
					<td>11.2</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">大武</th>
					<td>20.3</td>
					<td>20.9</td>
					<td>22.6</td>
					<td>24.7</td>
					<td>26.5</td>
					<td>28.0</td>
					<td>28.6</td>
					<td>28.2</td>
					<td>27.2</td>
					<td>26.0</td>
					<td>24.0</td>
					<td>21.3</td>
					<td>24.9</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">玉山</th>
					<td>-1.1</td>
					<td>-0.5</td>
					<td>1.1</td>
					<td>3.4</td>
					<td>5.7</td>
					<td>7.1</td>
					<td>7.9</td>
					<td>7.8</td>
					<td>7.1</td>
					<td>6.5</td>
					<td>4.0</td>
					<td>0.8</td>
					<td>4.2</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">新竹</th>
					<td>15.5</td>
					<td>15.9</td>
					<td>17.9</td>
					<td>21.7</td>
					<td>24.9</td>
					<td>27.4</td>
					<td>29.0</td>
					<td>28.7</td>
					<td>27.1</td>
					<td>24.2</td>
					<td>21.2</td>
					<td>17.7</td>
					<td>22.6</td>
					<td>1992-2010</td>
				</tr>
				<tr>
					<th axis="item">恆春</th>
					<td>20.7</td>
					<td>21.4</td>
					<td>23.2</td>
					<td>25.2</td>
					<td>27.0</td>
					<td>27.9</td>
					<td>28.4</td>
					<td>28.1</td>
					<td>27.4</td>
					<td>26.3</td>
					<td>24.3</td>
					<td>21.7</td>
					<td>25.1</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">成功</th>
					<td>18.9</td>
					<td>19.4</td>
					<td>21.0</td>
					<td>23.2</td>
					<td>25.3</td>
					<td>27.1</td>
					<td>28.1</td>
					<td>27.9</td>
					<td>26.8</td>
					<td>25.2</td>
					<td>22.7</td>
					<td>20.0</td>
					<td>23.8</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">蘭嶼</th>
					<td>18.5</td>
					<td>19.0</td>
					<td>20.5</td>
					<td>22.4</td>
					<td>24.3</td>
					<td>25.7</td>
					<td>26.3</td>
					<td>26.1</td>
					<td>25.2</td>
					<td>23.8</td>
					<td>21.7</td>
					<td>19.4</td>
					<td>22.7</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">日月潭</th>
					<td>14.2</td>
					<td>15.1</td>
					<td>16.9</td>
					<td>19.2</td>
					<td>21.0</td>
					<td>22.2</td>
					<td>23.0</td>
					<td>22.7</td>
					<td>22.1</td>
					<td>20.7</td>
					<td>18.3</td>
					<td>15.2</td>
					<td>19.2</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">臺東</th>
					<td>19.5</td>
					<td>20.0</td>
					<td>21.8</td>
					<td>24.1</td>
					<td>26.2</td>
					<td>27.8</td>
					<td>28.9</td>
					<td>28.7</td>
					<td>27.5</td>
					<td>25.7</td>
					<td>23.3</td>
					<td>20.5</td>
					<td>24.5</td>
					<td>1981-2010</td>
				</tr>
				<tr>
					<th axis="item">梧棲</th>
					<td>16.0</td>
					<td>16.3</td>
					<td>18.5</td>
					<td>22.4</td>
					<td>25.5</td>
					<td>27.8</td>
					<td>29.0</td>
					<td>28.8</td>
					<td>27.4</td>
					<td>24.6</td>
					<td>21.4</td>
					<td>17.7</td>
					<td>23.0</td>
					<td>1981-2010</td>
				</tr>
			</tbody>
		</table>
	</div>
	</article>

	
	<script src="../jquery/jquery-2.1.4.min.js"></script>
	<script src="../jquery/jquery-ui.min.js"></script>
	<script src="jquery/jquery-2.1.4.min.js"></script>
	<script src="jquery/jquery-ui.min.js"></script>
	
</body>
</html>