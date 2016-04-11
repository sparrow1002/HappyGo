<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #ppp{
   width:600px;
   height:220px;
   margin:0 auto;
   border:1px solid #666;
   background-color:pink;
  }
</style> 
<script type="text/javascript">
	function aa(){
		document.getElementById("ppp").innerHTML = document.getElementById("ttt").value;
	}
</script>
</head>
<body>
 <input type="text" id="ttt" /><br /><br />
	<input type="button" value="提 交" onclick="aa()" />
	<div id="ppp"></div>
	
	<!-- add new item Dynamically in the show block -->
  <div id="showBlock"></div>
  <!-- click the button to add new item -->
  <input type="button" id="btn" value="addItem" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script>
  //set the default value
  var txtId = 1;
  
  //add input block in showBlock
  $("#btn").click(function () {
      $("#showBlock").append('<div id="div' + txtId + '">Input:<input type="text" name="test[]" /> <input type="button" value="del" onclick="deltxt('+txtId+')"></div>');
      txtId++;
  });
  //remove div
  function deltxt(id) {
      $("#div"+id).remove();
  }
</script> 
</body>
</html>