<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../jquery-ui-1.11.4.custom/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../css/register.css" />
<link rel="stylesheet" type="text/css" href="../css/index.css" />


<title>註冊</title>
<script type="text/javascript" src="../js/jquery-2.2.2.min.js"></script>
<script type="text/javascript" src="../jquery-ui-1.11.4.custom/jquery-ui.min.js"></script> 
<script type="text/javascript">
   $(function() {
    $( "#datepicker" ).datepicker();
    
    $( "#name" ).selectmenu();
    
    $( "#cities" ).selectmenu();
 
    $( "#number" )
      .selectmenu()
      .selectmenu( "menuWidget" )
      .addClass( "overflow" );
  });
   
   $(function() {
	    $( "input[type=submit], a, button" )
	      .button()
	      .click(function( event ) {
	        event.preventDefault();
	      });
	  });
   
   </script>

</head>
<body >
<table width="990" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tbody>
			<tr>
				<td height="10" valign="top"></td>
			</tr>
			<tr>
				<td height="100" valign="top">

					<table width="961" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tbody>

							<tr>
								<td align="left"><a href="/pointscard/index.jsp"> <img
										alt="" src="../imgs/Logo.png" width="508"></a></td>
								<td><a href="http://www.facebook.com"> <img alt=""
										src="../imgs/Facebook_logo.png"></a></td>
								<td width="109" valign="bottom">

									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td height="32" align="right">
													<table width="387" border="0" cellspacing="0"
														cellpadding="0">
														<tbody id="menu">
															<tr>
																<td class="headTables"><a href="">最新消息</a></td>

																<td class="headTables"><a href="">會員中心</a></td>

																<td class="headTables"><a href="">門市據點</a></td>

																<td class="headTables"><a href="">關於我們</a></td>
																
																<c:if test="${ empty LoginOK }">
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/secure/login.jsp">登入</a></td>
																</c:if>
																<c:if test="${ not empty LoginOK }">
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/secure/LogOut.jsp">登出</a></td>
																</c:if>
																<c:if test="${ empty LoginOK }">	
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/register/register.jsp" >註冊</a></td>
																</c:if>
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/ShoppingCart/CheckOut.jsp" >購物車</a></td>
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/orderform/OrderSuccess.jsp" >查看訂單</a></td>

															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td width="990" height="14"></td>
			</tr>
	
			<tr>
				<td>
					<form name="RegisterServlet" action="/pointscard/register/Register.do" method="POST" style="width:1035px; height:735px; border: 1px solid pink;" >
						<table width="100%" border="0"  cellpadding="5" cellspacing="0" >
							<tbody>
								<tr >
									<td height="180px" width="100px" style="border: 1px solid pink;"><label>帳號: </label> <input name="customerId" value="${param.customerId}" class="basic" type="text"><p>${error.errorId}</td>
									<td width="100px" style="border: 1px solid pink;"><label>密碼:</label> <input class="basic" name="customerPassword" value="${param.customerPassword}" type="password"><p> ${error.errorPassword}</td>
									<td width="100px" style="border: 1px solid pink;"><label>暱稱:</label> <input  class="basic" name="customerName" value="${param.customerName}" type="text"><p> ${error.errorCustomerName}</td>
									<td width="100px" style="border: 1px solid pink;"><label for="speed">選擇性別</label> <select name="sex" id="name" style="width: 100px;"> 
																											<option value="女">女</option>
																											<option value="男" selected="selected">男</option>
																						</select>	
										
									</td>
				
								</tr>
								<tr >
									<td  height="180px" style="border: 1px solid pink;"><label>身份證字號: </label> <input name="identityId" value="${param.identityId}" class="basic" type="text" ><p> ${error.identityId}</td>
									<td style="border: 1px solid pink;"><label>手機號碼: </label> <input name="phoneNumber" value="${param.phoneNumber}" class="basic" type="text"> </td>
									<td style="border: 1px solid pink;"><label>電子郵件:</label> <input name="email" value="${param.email}" class="basic" type="text">  </td>
									<td style="border: 1px solid pink;"><label>選擇出生年月日: </label> <input name="birthDay" value="${param.birthDay}" class="basic" type="text" id="datepicker"> </td>
								</tr>
								
								<tr >
									<td  height="180px" style="border: 1px solid pink;" ><label for="files">選擇居住城市</label> 
											<select  name="cities" id="cities" style="width: 200px" onchange="getCities()" >
												<option value="台北市">台北市</option>
												<option value="桃園市">桃園市</option>
												<option value="新竹市">新竹市</option>
												<option value="苗栗市">苗栗市</option>
												<option value="台中市">台中市</option>
												<option value="嘉義市">嘉義市</option>
												<option value="南投市">南投市</option>
												<option value="台南市">台南市</option>
												<option value="高雄市">高雄市</option>
												<option value="屏東市">屏東市</option>
												<option value="台東市">台東市</option>
												<option value="花蓮市">花蓮市</option>
												<option value="宜蘭市">宜蘭市</option>			
											</select> 
									</td>
									
<!-- 									<td><label for="number">選擇職業類型</label>  -->
<!-- 													<select name="number" id="number" style="width: 200px"> -->
<!-- 														<option value="">金融業</option> -->
<!-- 														<option value="" selected="selected">選擇職業</option> -->
<!-- 														<option value="">服務業</option> -->
<!-- 														<option value="">學生</option> -->
<!-- 														<option value="">製造業</option> -->
<!-- 														<option value="">醫療業</option> -->
<!-- 													</select></td>						 -->
								</tr>
								
								<tr>
									<td  height="80px" > 
										<a href="/pointscard/index.jsp"><input type="button" value="回首頁" class="btn" style="cursor: pointer"></a>
									</td>
									<td  height="80px" >
										
									</td>
									<td  height="80px" >
									<input type="submit"  name="customerData" value="確認送出!" class="btn" style="cursor: pointer">
										<input type="reset" value="清除重填" class="btn" style="cursor: pointer">
									</td>
									<td  height="80px" >
									
										
											
											
													
									</td>
								</tr>
								
								
								<tr>
									<td></td>
								</tr>
	
								<tr>
									<td>
										<table style="margin-left: 15px">
											<tbody>
												<tr>
													<td width="302" height="180" align="center" valign="bottom">
													
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</td>
			</tr>
			
	
			<tr>
				<td></td>
			</tr>
	
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>