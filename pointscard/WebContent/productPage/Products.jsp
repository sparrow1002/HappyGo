<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/index.css" />

<script type="text/javascript" src="../js/jquery-2.2.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.cycle.js"></script>
<script type="text/javascript" src="../js/index.js"></script>

<script type="text/javascript">
	// jQuery(document).ready(function($) {
	// 	$('#advs').cycle({   
	//         fx:'fade',  
	//         speed:900,
	//         timeout:1000,
	//         random:0
	//        });
	// });
	

</script>


<title>購物網</title>
<style type="text/css">
.productList {
	padding: 0px;
	margin: 0px 2px 0px 0px;
	width: 200px;
	display: block;
	float: left;
	height: 400px;
}
</style>


</head>

<body>
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
																<td class="headTables" style="border: 1px solid pink;"><a
																	href="">最新消息</a></td>

																<td class="headTables" style="border: 1px solid pink;"><a
																	href="/pointscard/page/MemberCenter.jsp">會員中心</a></td>

																<td class="headTables" style="border: 1px solid pink;"><a
																	href="">門市據點</a></td>

																<td class="headTables" style="border: 1px solid pink;"><a
																	href="">關於我們</a></td>


																<c:if test="${ empty LoginOK }">
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/secure/login.jsp">登入</a></td>
																</c:if>
																<c:if test="${ not empty LoginOK }">
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/secure/LogOut.jsp">登出</a></td>
																</c:if>
																<c:if test="${ empty LoginOK }">	
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/register/register.jsp" >註冊</a></td>
																</c:if>
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/ShoppingCart/CheckOut.jsp" >購物車<c:if test="${not empty ShoppingCart }">(1)</c:if></a></td>
																<td class="headTables" style="border: 1px solid pink;"><a href="/pointscard/orderform/OrderSuccess.jsp" >查看訂單</a></td>



															</tr>
															<tr>
																<h6>哈囉！</h6>${user.MBR_NAME}</tr>
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
				<td>
					<ul id="nav">
						<li id="nav-men" class="items" value="male"><a href="/pointscard/productPage/Products.jsp">男裝、配件</a></li>
						<li id="nav-women" class="items">女裝、配件</li>
						<li id="nav-chidren" class="items">童裝、配件</li>
						<li id="nav-3c" class="items">家電、音響</li>
						<li id="nav-furniture" class="items">家具、家飾</li>
						<li id="nav-toys" class="items">玩具、收藏</li>
						<li id="nav-pets" class="items">寵物、周邊</li>
						<li id="nav-camera" class="items">相機、攝影</li>

					</ul>
				</td>
			</tr>

			<tr>
				<td width="990" height="14"></td>
			</tr>

			<tr>
				<td>
					<table width="96%" border="0" align="center" cellpadding="5"
						cellspacing="0">
						<tbody>
							<tr>
								<td width="135px" valign="top" style="border: 1px solid pink;">
									<table>
										<tbody>
											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 1</li>
																<li>list 2</li>
																<li>list 3</li>
																<li>list 4</li>
																<li>list 5</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>

											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 111111111</li>
																<li>list 2111111</li>
																<li>list 31111111</li>
																<li>list 4111111</li>
																<li>list 5111111</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>

											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 1</li>
																<li>list 2</li>
																<li>list 3</li>
																<li>list 4</li>
																<li>list 5</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>

											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 1</li>
																<li>list 2</li>
																<li>list 3</li>
																<li>list 4</li>
																<li>list 5</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>

											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 1</li>
																<li>list 2</li>
																<li>list 3</li>
																<li>list 4</li>
																<li>list 5</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>

											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 1</li>
																<li>list 2</li>
																<li>list 3</li>
																<li>list 4</li>
																<li>list 5</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>

											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 1</li>
																<li>list 2</li>
																<li>list 3</li>
																<li>list 4</li>
																<li>list 5</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>
											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 1</li>
																<li>list 2</li>
																<li>list 3</li>
																<li>list 4</li>
																<li>list 5</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>

											<tr>
												<td style="border: 1px solid pink;">
													<ul>
														<li>first category title</li>
														<li>
															<ul>
																<li>list 1</li>
																<li>list 2</li>
																<li>list 3</li>
																<li>list 4</li>
																<li>list 5</li>
															</ul>
														</li>

													</ul>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
								<td width="1700" valign="top" style="border: 1px solid pink;">
									<table>
										<tbody>
											<tr height="32">
												<!-- 調整高度 -->
											</tr>
											<tr>
												<!-- 商品列開始 -->
												<td>


													<table width="100%">
														<tbody>
															<tr>
																<td>
																	<div class="productList">
																		<!-- 商品格 -->
																		<!-- 																	<form action="/pointscard/productDisplay/BuyProduct.do" method="POST"> -->

																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a
																										href="/pointscard/productDisplay/BuyProduct.do?param1=01">

																											<img 
																											id="1"
																											name="pd01"
																											alt="this is a product"
																											src="../imgs/products/product03.jpg"
																											>
																										

																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a
																												href="/pointscard/productDisplay/BuyProduct.do?param1=01">
																												this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																		<!-- 																	</form> -->

																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a
																										href="/pointscard/productDisplay/BuyProduct.do?param2=02">

																											<img 
																											
																											alt="this is product"
																											src="../imgs/products/product03.jpg"
																										
																											>
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href="/pointscard/productDisplay/BuyProduct.do?param2=02">
																												this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											
																											alt="this is product"
																											src="../imgs/products/product03.jpg" >
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>

																	<div class="productList">
																		<!-- 商品格 -->
																		<table align="center">
																			<tbody>
																				<tr>
																					<td>
																						<table>
																							<!-- 商品格第二層 -->
																							<tbody>
																								<tr>
																									<!-- 商品圖片 -->
																									<td><a href=""> <img
																											alt="this is product"
																											src="../imgs/products/product03.jpg">
																									</a></td>

																								</tr>
																								<tr>
																									<td width="200px" align="center">
																										<div class="productTitle">
																											<a href=""> this is product introduce </a>
																										</div>
																									</td>
																								</tr>
																								<tr>
																									<td align="center"><span>price:2000</span>
																									</td>
																								</tr>

																							</tbody>

																						</table>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																	</div>




																</td>
																<!-- 商品列結束 -->
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
				<td></td>
			</tr>
			<tr>
				<td>
					<table width="100%" align="center" cellpadding="" cellspacing=""
						id="footer">
						<tbody>
							<tr>
								<td width="25%" align="center"><a href="" class="items">客服中心</a>
								</td>
								<td width="25%" align="center"><a href="" class="items">人才招募</a>
								</td>
								<td width="25%" align="center"><a href="" class="items">地址查詢</a>
								</td>
								<td>COPYRIGHT©NET CO.,LTD.ALL RIGHTS RESERVED.</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>