<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>出 租 |大 叔.</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fram.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/fram.js"></script>
</head>
<body style="min-width: 1200px;">
	<!-- 頂部的LOGO 以及各個點擊頁籤 -->
	<jsp:include page="../fragment/top.jsp" />
	<!-- 登入 -->
	<section id="loginblock">
		<form action="login.do" method="POST">
			
			
			<div id="loginform" >

				帳號 :
				<input type="email" name="email" value="${requestScope.user}${param.userId}">
				<span>${ErrorMsgKey.AccountEmptyError}${ErrorMsgKey.DontHaveUser}</span>
				<br><br>
				密碼 :
				<input type="text" name="password" value="${requestScope.password}${param.pswd}">
				<span>${ErrorMsgKey.PasswordEmptyError}</span>
				<br><br>				
				記住密碼 :
           			<input type="checkbox" name="rememberMe" id= "rememberMe"
           			       <c:if test='${requestScope.rememberMe==true}'>
                  					checked='checked'
               				</c:if>               				          			
           			 value="true" >
           			 <span>${ErrorMsgKey.LoginError}</span> 
           		<br><br>
           		<input type="submit" value="登入">
			</div>
			
		</form>
		
	</section>
	
	<!-- 聯絡方式 -->
	<section id="information">
		<div id="address">
			<img src="${pageContext.request.contextPath}/icon/home.png" alt="">
			<br>
			<span>北科204</span>
		</div>
		<div id="phone">
			<img src="${pageContext.request.contextPath}/icon/smartphone-call.png" alt="">
			<br>
			<span>0911-111-222</span>
		</div>
		<div id="email">
			<img src="${pageContext.request.contextPath}/icon/message-closed-envelope.png" alt="">
			<br>
			<span>QQ123@ntut.edu.tw</span>			
		</div>
	</section>
	<!-- 最底部 版權 -->
	<footer id="copyright">
		<div>版權所有，翻印必究</div>
	</footer>	
</body>
</html>