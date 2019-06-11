<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title> 出 租 |大 叔.</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ossan.css">	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fram.css">
	<!-- slider套件 -->
	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/fram.js"></script>
	<script src="${pageContext.request.contextPath}/js/ossan.js"></script>


</head>
<body style="min-width: 1200px;">

	<!-- 頂部的LOGO 以及各個點擊頁籤 -->
	<jsp:include page="../fragment/top.jsp" />
	
	<!-- 大叔個人及購買頁面 -->
	<section id="ossanPersonal">
		<div>
			<header>
				<br>
				<br>
				<br>
				<br>
				<div id="ossanImage">
<%-- 					<img src="<c:url value='getIndexOssanImage/${allOssanBean.ossanNo}'/>"> --%>
					<img src="<c:url value='getIndexOssanImage/${ossanBean.ossanNo}'/>" alt="" >
				</div>
				<div id="ossanBuy">
					<div class="hr"></div><br>
					<form id="shoppingCartForm" action="addShoppingCart" method="Post">
						<div id="ossanName"> ${ossanBean.name}</div><br>
						<div id="quote"> ${ossanBean.quote}</div><br><br>
						<input type="hidden" value="${ossanBean.ossanNo}" name="ossanNo">
						<select name="hours" id="formSelect" >
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>  &nbsp;&nbsp;&nbsp;&nbsp;/小時
						<br><br>
						<input type="submit" value="加入購物車" id="addCart">
					</form><br><br><br>
					<div class="hr"></div><br>

				</div>
			</header>
			<br><br><br><br><br><br>
			<div class="hr"></div>
			<br><br><br><br>
			<footer id="ossanIntro">				
				${ossanBean.sIntro}
				
			</footer>
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