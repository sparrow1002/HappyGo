<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>註冊</h1>
<table>
	<tr>
		<td>特店代號 : </td>
		<td><input type="text" name="storeid" value="" ></td>
		<td></td>
	</tr>
	<tr>
		<td>特店名稱 : </td>
		<td><input type="text" name="name" value=""></td>
		<td></td>
	</tr>

	<tr>
		<td>特店密碼 : </td>
		<td><input type="text" name="pwd" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>統一編號 : </td>
		<td><input type="text" name="taxcode" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>特店地址 : </td>
		<td><input type="text" name="address" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>特店狀態 : </td>
		<td><input type="text" name="status" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>連絡電話 : </td>
		<td><input type="text" name="phone" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>聯絡人 : </td>
		<td><input type="text" name="contact" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>特店生效日 : </td>
		<td><input type="text" id="today"  name="createtime" value="" ></td>
		<td>日曆</td>
	</tr>
	<tr>
		<td>特店失效日 : </td>
		<td><input type="text" id="datepicker"  name="deletime" value=""></td>
		<td>日曆</td>
	</tr>
	<tr>
		<td>異動日期 : </td>
		<td><input type="text" name="updatetime" value="" ></td>
		<td></td>
	</tr>
	<tr>
		<td>異動者 : </td>
		<td><input type="text" name="Updateuser" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>		
			<input type="submit" name="prodaction" value="insert">
		</td>		
	</tr>	
</table>
</body>
</html>