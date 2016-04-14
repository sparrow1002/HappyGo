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


<title>登入頁面</title>
<script type="text/javascript" src="../js/jquery-2.2.2.min.js"></script>
<script type="text/javascript" src="../jquery-ui-1.11.4.custom/jquery-ui.min.js"></script> 
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
	
			<tr  style="width:635px; height:235px;">
				
								</tr>
								
								<tr  style="width:635px; height:235px;">	
								
									<td align="center">
					<form name="RegisterServlet" action="/pointscard/secure/login.do" method="POST" style="width:635px; height:235px;" >
						<table width="100%" border="0"  cellpadding="5" cellspacing="0">
							<tbody  >
								<tr align="center">
									<td  style="border: 1px solid pink;">
										<label>帳號：</label><input type="text" name="userId" id="userId"  class="basic" value="${param.userId}"  >
											<p> ${error.accountError }
											
												<p> 
												
										<label>密碼：</label><input type="password" name="userPassword" id="userPassword" class="basic" value="${param.userPassword}">
											<p> ${error.passwordError } 
											
												<p>
											<input type="submit" name="" value="登入" class="btn" style="cursor: pointer">																
									</td>		
									<td>
									${error.loginFailed }
									</td>											
								</tr>
								
								<tr  style="width:635px; height:235px;">
															
								</tr>
								
								<tr>
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