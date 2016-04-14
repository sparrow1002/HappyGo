<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${empty LoginOK}">
	<c:redirect url="../secure/login.jsp" />
</c:if>
<jsp:useBean id="orderBeans" class="shoppingCart.model.ShoppingOrderDAOJDBC" scope="page" />
<title>訂單列表</title>
</head>
<body >
<c:set var="funcName" value="ORD" scope="session"/>
	<!-- 引入共同的頁首 -->
    <p/>
    <center>
	<table>

		<tr >
			<th >${LoginOK.MBR_NAME}的訂購紀錄</th>
		</tr>
		<tr>
			<th>訂單編號</th>
			<th>訂購日期</th>
			<th>總金額</th>
			<th>送貨地址</th>
		</tr>
		<!-- 連到SingleOrderBean -->
		<c:forEach var="anOrderBean" varStatus="stat" 	items="${orderBeans.allOrders}">
				<c:if test="${anOrderBean.MBR_MEMBERID==LoginOK.MBR_MEMBERID}">
						<TR >
							<TD >
							    <a  href='orderDetail.do?memberId=${LoginOK.MBR_MEMBERID}&orderNo=${anOrderBean.ORD_no}'>
							         ${anOrderBean.ORD_no}
							    </a>
							  </TD>
							<TD width="100" align="center">${anOrderBean.ORD_date}</TD>
							<TD width="80" align="right">${anOrderBean.ORD_totalAmount}</TD>
							<TD width="400" align="left">&nbsp;${anOrderBean.ORD_shippingAddress}</TD> 

						</TR>
				</c:if>
		</c:forEach>
		
		<tr height='36'>
			<td align="center" colspan="4"><a href="../index.jsp">回首頁</a></td>
		</tr>
	</TABLE>
	</center>
</body>

</html>