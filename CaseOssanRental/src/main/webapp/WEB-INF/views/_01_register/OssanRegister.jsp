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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fillform.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/fram.js"></script>
	<script src="${pageContext.request.contextPath}/js/fillform.js"></script>
</head>
<body style="min-width: 1200px;">
	<!-- 頂部的LOGO 以及各個點擊頁籤 -->
	<jsp:include page="../fragment/top.jsp" />
	<!-- 註冊大叔-2 -->
	<section id="fillformblock">
		<div id="fillformtitle">
			註冊成為大叔
			<span></span>
		</div>
		<form:form id="form" method="POST" modelAttribute="ossanBean">
			<div>帳號 : </div>
			<form:input type="email" id="userid" path="email" placeholder="請輸入8~16個英文字或數字" />
			<span>${MsgMap.errorIDEmpty}${MsgMap.IDExistError}</span>
			<br><br>
			<div>密碼 : </div>
			<form:input type="password" id="password" path="password" placeholder="請輸入8~16個英文字或數字 " />
			<span>${MsgMap.errorPasswordEmpty}${MsgMap.passwordError}</span>
			<br><br>
<!-- 			<div>確認密碼 : </div> -->
<!-- 			<input type="password" id="confirmpassword" name="confirmpassword"placeholder="密碼確認" > -->
<%-- 			<span>${MsgMap.errorPassword2Empty}</span> --%>
<!-- 			<br><br> -->
			<div>真實姓名 : </div>
			<form:input type="text" id="username" path="name"/>
			<span>${MsgMap.errorName}</span>
			<br><br>
<!-- 			<div>暱稱 : </div> -->
<%-- 			<form:input type="text" id="nickname" name="nickname" value="${param.nickname}"/> --%>
<%-- 			<span>${MsgMap.errorNickname}</span> --%>
<!-- 			<br><br> -->
			<div>身分證字號 : </div>
			<form:input type="text" id="uid" path="uniqueId" />
			<span>${MsgMap.errorUid}</span>
			<br><br>
			<div>出生年月日 : </div>
			<form:input type="date" id="birth" path="birthday" min="1919-12-31" max="2009-12-31"/>
			<span>${MsgMap.errorBirthday}</span>
			<br><br>
			<div>地址 :	</div>			
			<form:input type="text" id="address" path="address"/>
			<span>${MsgMap.errorAddress}</span>
			<br><br>			
			<div>連絡電話 : </div>
			<form:input type="text" id="phone" path="phone"/>
			<span>${MsgMap.errorTel}</span>
			<br> <br>
			
			<button id="fillformsubmit"> 成為大叔 </button>
		</form:form >	
		
			
	</section>
	<!-- 信件寄出 -->
	<section id="success">
		<div>
			確認信件已寄出<br><br>
			若未收到確認信，請於個人資料維護畫面修改<br><br>
			三秒後將跳轉資料維護介面
		</div>
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