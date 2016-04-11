<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
​
<script>
$(function() {	
	$("#today").datepicker({
		dateFormat: "yymmdd"
	});	
	$("#today").datepicker("setDate", new Date());
	
    $( "#datepicker" ).datepicker({
    	dateFormat: "yy/mm/dd"
    }).val();
  });  
</script>
<script type="text/javascript">
   $(document).ready(function(){
      $("#today").prop('readonly', true);
   });
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ContractStore</title>
</head>
<body>
<form action="<c:url value="/conStore/contractStore.controller"/>" method="get">
<table>
	<tr>
		<td>StoreID : </td>
		<td><input type="text" name="storeid" value="${param.cos_storeid}" ></td>
		<td></td>
	</tr>
	<tr>
		<td>Name : </td>
		<td><input type="text" name="name" value="${param.cos_name}"></td>
		<td></td>
	</tr>

	<tr>
		<td>PassWord : </td>
		<td><input type="text" name="pwd" value="${param.cos_pwd}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Taxcode : </td>
		<td><input type="text" name="taxcode" value="${param.cos_taxcode}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Address : </td>
		<td><input type="text" name="address" value="${param.cos_address}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Status : </td>
		<td><input type="text" name="status" value="${param.cos_status}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Phone : </td>
		<td><input type="text" name="phone" value="${param.cos_phone}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Contact : </td>
		<td><input type="text" name="contact" value="${param.cos_contact}"></td>
		<td></td>
	</tr>
	<tr>
		<td>Createtime : </td>
		<td><input type="text" id="today"  name="createtime" value="${param.cos_createtime}" ></td>
		<td>日曆</td>
	</tr>
	<tr>
		<td>Deletime : </td>
		<td><input type="text" id="datepicker"  name="deletime" value="${param.cos_deletime}"></td>
		<td>日曆</td>
	</tr>
	<tr>
		<td>Updatetime : </td>
		<td><input type="text" name="updatetime" value="${param.cos_updatetime}" ></td>
		<td></td>
	</tr>
	<tr>
		<td>Updateuser : </td>
		<td><input type="text" name="Updateuser" value="${param.cos_updateuser}"></td>
		<td></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="prodaction" value="Insert">
			<input type="submit" name="prodaction" value="Update">
		</td>
		<td>
			<input type="submit" name="prodaction" value="Delete">
			<input type="submit" name="prodaction" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>	
</table>
</form>

</body>
</html>