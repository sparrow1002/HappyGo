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
${ProductBean.PD_ID}


<table>
	<c:forEach var="bean" items="${ProductAllBean}">

		<c:url value="../productDisplay/ProductDetail.jsp" var="path" scope="session">
			<c:param name="name" value="${bean.PD_name}" />
		</c:url>
		
		<tr>
			<td> 
			<a href="${path}">${bean.PD_name}</a>
			</td>
			<td>
			
			</td>
		</tr>
	</c:forEach>
</table>



</body>
</html>