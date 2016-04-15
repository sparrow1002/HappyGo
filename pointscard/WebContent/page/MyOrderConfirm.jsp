<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 取得今天的日期，今天的日期應當在最後確認時才取得 -->
<jsp:useBean   id="today"  class="java.util.Date" scope="session"/> 

<title>Insert title here</title>

<script type="text/javascript">
function cancelOrder() {
	if (confirm("確定取消此份訂單 ? ") ) {
		// 接收此資料的Servlet會使用 finalDecision 參數的值
		document.forms[0].finalDecision.value = "CANCEL";
		return true;
	} else {
		return false;
	}
}
function reconfirmOrder() {
	if (confirm("確定送出此份訂單 ? ") ) {
		// 接收此資料的Servlet會使用 finalDecision 參數的值
		document.forms[0].finalDecision.value = "ORDER";
		return true;
	} else {
		return false;
	}
}
</script>
</head>
<body >
<c:set var="funcName" value="CHE" scope="session"/>
<BR>
請確認下列訊息：
<CENTER>

<FORM action="<c:url value='ProcessOrder.do' />" method="POST">
   <TABLE>
      <TR >
         <TD >會員編號：${LoginOK.MBR_MEMBERID}</TD>
         <TD >客戶姓名：${LoginOK.MBR_NAME}</TD>
         <TD >訂單日期：<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/></TD>
      </TR>
      <TR>
         <TD >會員地址：${LoginOK.MBR_ARRDESS}</TD>
      </TR>
      <TR>
         <TD>
           出貨地址：<Input name="ShippingAddress" value="${LoginOK.MBR_ARRDESS}">
         </TD>
      </TR>
      <TR>
         <TD>
         
   <TABLE >
      
     <TR><TH >商品名稱</TH>
         <TH >單價</TH>
         <TH >數量</TH>
         <TH>小計</TH></TR>
     <!-- 取出MyOrderItemBean -->
     <c:forEach varStatus="vs" var="anEntry" items="${ShoppingCart.content}">
                                                    
        <TR height='16'>
          <TD>${anEntry.value.PD_name}</TD>
          <TD>${anEntry.value.price}</TD>
          <TD> ${anEntry.value.qty}   </TD>
          <TD><fmt:formatNumber value="${anEntry.value.price * anEntry.value.qty}" pattern="#,###,###" />元</TD>
        </TR>
     </c:forEach>
     
        <TR >
          <TD>合計金額：</TD>
          <TD ><fmt:formatNumber value="${ShoppingCart.subtotal}" pattern="#,###,###" />元</TD>
                  
        </TR>
    
        <TR>
          <TD >總計金額：</TD>
          <TD><fmt:formatNumber value="${ShoppingCart.subtotal }" pattern="#,###,###" />元</TD>
                   
        </TR>
   </TABLE>
 
         </TD>
      </TR>
 
   </TABLE><P/>
   <INPUT TYPE="hidden" name="finalDecision"  value="">   
   <INPUT TYPE="SUBMIT" name="OrderBtn"  value="確定送出" onclick="return reconfirmOrder();">
   <INPUT TYPE="SUBMIT" name="CancelBtn" value="取消訂單" onclick="return cancelOrder();">
</FORM>
</CENTER>
</body>
</html>