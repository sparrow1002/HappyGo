<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="utf-8" />
<title>text-align_CSS参考手册_web前端开发参考手册系列</title>
<meta name="author" content="Joy Du(飘零雾雨), dooyoe@gmail.com, www.doyoe.com" />
<style>
.test p{border:1px solid #000;}
.left p{text-align:left;}
.center p{text-align:center;}
.right p{text-align:right;}
.justify p{width:200px;text-align:justify;}
.start p{text-align:start;}
.end p{text-align:end;}
</style>


<script type="text/javascript">
function getOption()
  {
  var x=document.getElementById("mySelect")
  alert(x.options[x.selectedIndex].text)
  }
</script>
</head>
<body>
<form>
Select your favorite fruit:
<select id="mySelect">
  <option>Apple</option>
  <option>Orange</option>
  <option>Pineapple</option>
  <option>Banana</option>
</select>
<br /><br />
<input type="button" onclick="getOption()" value="Alert text of selected option">
</form>
</body>