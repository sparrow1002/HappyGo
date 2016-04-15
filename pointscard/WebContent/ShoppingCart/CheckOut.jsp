<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function confirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='UpdateItem.do?cmd=DEL&PD_ID=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}
function modify(key, qty, index) {
	var x = "newQty" + index;
	var newQty = document.getElementById(x).value;
	if  (newQty < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newQty == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = qty;
		return ; 
	}
	if  (newQty == qty ) {
		window.alert ("新、舊數量相同，不必修改");
		return ; 
	}
	if (confirm("確定將此商品的數量由" + qty + " 改為 " + newQty + " ? ") ) {
		document.forms[0].action="<c:url value='UpdateItem.do?cmd=MOD&PD_ID=" + key + "&newQty=" + newQty +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = qty;
	}
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57)){
      return false;
   }
   return true;
}
function Checkout(qty) {
	if (qty == 0)  {
		alert("無購買任何商品，不需結帳");
		return false;
	}
	if (confirm("再次確認訂單內容 ? ") ) {
		return true;
	} else {
		return false;
	}
}
function Abort() {
	if (confirm("確定放棄購物 ? ") ) {
		return true;
	} else {
		return false;
	}
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購物清單</title>
</head>
<body>
<c:set var="funcName" value="CHE" scope="session"/>

<c:choose>
   <c:when test="${ShoppingCart.itemNumber > 0}">
      <c:set var="cartContent" value="購物車內有${ShoppingCart.itemNumber}項商品"/>
   </c:when>
   <c:otherwise>
      <c:set var="cartContent" value="您尚未購買任何商品"/>        
   </c:otherwise>
</c:choose>
<p/>
<TABLE >
<TR>
<TD>
<!--   購物車的標題          --> 
   <TABLE width="820">
<%--      <TR >${AppName}</FONT></TD> --%>
     <TR ><TD ><FONT  size='+2'>購 物 清 單</FONT></TD><TD></TD></TR>
   </TABLE>
</TD></TR>

<TR>
   <TD><font size='-1' face='標楷體, Arial'> 
   <TABLE>
     <TR>
     <TH >商品名稱</TH>
     <TH width="60">單價</TH>
     <TH width="40">數量</TH>
     <TH width="110">小計</TH>
     <TH width="110">修改</TH>
     </TR>
     <c:forEach varStatus="vs" var="anEntry" items="${ShoppingCart.content}">
        <TR height='16'>
          <TD >${anEntry.value.PD_ID}</TD>
          <TD>${anEntry.value.PD_name}</TD>
          <TD> <!-- what the fuck is vs.index?? -->
                <Input id="newQty${vs.index}" name="newQty" type="text" value="<fmt:formatNumber value="${anEntry.value.qty}" />" name="qty" onkeypress="return isNumberKey(event)"  />
          </TD>
          <TD><fmt:formatNumber value="${anEntry.value.price * anEntry.value.qty}" pattern="#,###,###" />元</TD>
          <TD ><Input type="button" name="update" value="修改" onClick="modify(${anEntry.key}, ${anEntry.value.qty}, ${vs.index})">
               <Input type="button" name="delete" value="刪除" onClick="confirmDelete(${anEntry.key})"></TD> <!-- 這兩個按鍵無法作用,有可能是ShoppingCart 類別的問題0412 -->
        </TR>
        <p>
     </c:forEach>
   </TABLE>
   </font>
   </TD>
</TR>
<TR height='80'>
   <TD > 
     <TABLE border='1'>
        <TR >
          <TD width="260" align='center'>
              <A href="<c:url value='../productPage/Products.jsp' />">繼續購物</A>
          </TD>
          <TD width="260" align='center'>
              <A href="<c:url value='checkout.do' />" onClick="return Checkout(${subtotal});">再次確認</A>
          </TD>
         <TD width="260" align='center'>
              <A href="<c:url value='abort.do' />" onClick="return Abort();">放棄購物</A>
          </TD>
        </TR>
     </TABLE>
   </TD>
</TR>
</TABLE>
</center>
    
<form>
   <input type="hidden" name="a"/>
</form>

</body>

</html>