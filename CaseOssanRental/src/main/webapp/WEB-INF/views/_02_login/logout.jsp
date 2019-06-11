<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登出</title>
</head>
<body>
<!-- 先將使用者名稱取出 -->
<c:set var="memberName" value="${ LoginOK.name }" />
<!-- 移除放在session物件內的屬性物件 -->
<c:remove var="LoginOK" scope="session" />
<c:remove var="OssanLoginOK" scope="session" />
<c:remove var="AdminLoginOK" scope="session" />
<c:remove var="ShoppingCart" scope="session" />
<c:remove var="OssanSessionPKey" scope="session" />
<c:remove var="ossanBean" scope="session" />

<!-- 引入共同的頁首 -->
<jsp:include page="../fragment/top.jsp" />
<!-- 下列六行敘述設定登出後要顯示的感謝訊息 -->
<%-- <c:set var="logoutMessage" scope="request"/> --%>
<!-- <font color='blue' ><BR> -->
<%-- 訪客${ memberName }，感謝您使用本系統。<BR> --%>
<!-- 您已經登出<BR> -->
<!-- </font> -->

    
<%-- <c:set target='${logoutBean}'  --%>
<%--    property='session'    value='${pageContext.session}'/> --%>
   
<%-- ${ logoutBean.logout } --%>

<c:redirect url="/"/>
</body> 
</html>