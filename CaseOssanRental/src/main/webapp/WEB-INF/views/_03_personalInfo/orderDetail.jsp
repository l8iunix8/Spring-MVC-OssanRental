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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fram.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/orderDetail.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fram.js"></script>
</head>
<body style="min-width: 2000px;">
	<!-- 頂部的LOGO 以及各個點擊頁籤 -->
	<jsp:include page="../fragment/top.jsp" />
	<!-- 加入大叔 -->
	<section id="orderDetail">
		<div id="orderTitle">訂單細節</div>
		<span></span>
		<table id="orderTable">
			<tr>
				<td>訂單編號</td>
				<td>客戶姓名</td>
				<td>電話號碼</td>
				<td>電子郵件</td>
				<td>時數</td>
				<td>價錢</td>
			</tr>
			
				<tr>
					<td>${orderItemBean.orderBean.orderNo}</td>
					<td>${orderItemBean.orderBean.invoiceTitle}</td>
					<td>${orderItemBean.orderBean.phone}</td>
					<td>${orderItemBean.orderBean.email}</td>
					<td>${orderItemBean.quantity}</td>
					<td>${orderItemBean.orderBean.totalAmount}</td>
				</tr>
			
			<!-- 			<tr> -->
			<!-- 				<td>訂單編號</td> -->
			<!-- 				<td>客戶姓名</td> -->
			<!-- 				<td>電話號碼</td> -->
			<!-- 				<td>電子郵件</td> -->
			<!-- 				<td>時數</td> -->
			<!-- 				<td>價錢</td> -->
			<!-- 			</tr> -->
		</table>
	</section>

	<!-- 聯絡方式 -->
	<section id="information">
		<div id="address">
			<img src="${pageContext.request.contextPath}/icon/home.png" alt="">
			<br> <span>北科204</span>
		</div>
		<div id="phone">
			<img
				src="${pageContext.request.contextPath}/icon/smartphone-call.png"
				alt=""> <br> <span>0911-111-222</span>
		</div>
		<div id="email">
			<img
				src="${pageContext.request.contextPath}/icon/message-closed-envelope.png"
				alt=""> <br> <span>QQ123@ntut.edu.tw</span>
		</div>
	</section>
	<!-- 最底部 版權 -->
	<footer id="copyright">
		<div>版權所有，翻印必究</div>
	</footer>
</body>
</html>