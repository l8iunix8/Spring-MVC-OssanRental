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
	href="${pageContext.request.contextPath}/css/shoppingCart.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fram.js"></script>
<script src="${pageContext.request.contextPath}/js/shoppingCart.js"></script>
<script>
	function confirmDelete(n) {
		if (confirm("確定刪除此項商品 ? ") ) {
			document.forms[0].action="deleteOneOssan/"+n+"" ;
			document.forms[0].method="POST";
			document.forms[0].submit();
		} else {
		
		}
	}
	function confirmDeleteAll(){
		if (confirm("確定刪除全部商品 ? ") ) {
			document.forms[0].action="<c:url value='UpdateItem.do?cmd=DEL&bookID=" + n +"' />" ;
			document.forms[0].method="POST";
			document.forms[0].submit();
		} else {
		
		}
	}
	function confirmForm(){
		if (confirm("確定購買 ? ") ) {
			$('#confirmForm').submit()
		} else {
			return false;
		}
	}
	</script>

</head>
<body style="min-width: 1200px;">

	<!-- 頂部的LOGO 以及各個點擊頁籤 -->
	<jsp:include page="../fragment/top.jsp" />
	<!-- 購物車結帳頁面 -->
	<section id="shoppingCart" style="min-height: 520px;">
		<header>結帳頁面</header>
		<span></span>
		<c:if test="${not empty ShoppingCart}">
			<form:form method="POST" action="shoppingCart" id="confirmForm"
				modelAttribute="orderBean">
				<table id="shoppingCartTable">
					<tr>
						<td>大叔姓名</td>
						<td>購買時數</td>
						<td>總價位</td>
						<td>操作</td>
					</tr>

					<c:forEach varStatus="stVar" var="Cart"
						items="${ShoppingCart.content}">
						<tr>
							<td>${Cart.value.ossanBean.name}</td>
							<td>${Cart.value.quantity}</td>
							<td>${Cart.value.quantity * Cart.value.unitPrice}</td>
							<td><input type="number" min="1"
								value="${Cart.value.quantity}" name="${Cart.key}count"
								id="count"> <input type="button" value="刪除" id="delete"
								onclick="confirmDelete(${Cart.value.ossanBean.ossanNo})">
							</td>
						</tr>
					</c:forEach>
				</table>
				<div id="customerInfo">
					<div>真實姓名 :</div>
					<form:input type="text" id="username" path="invoiceTitle" />
					${ErrMsg.errName} <br> <br>
					<div>連絡電話 :</div>
					<form:input type="text" id="phone" path="phone" />
					${ErrMsg.errPhone}<br> <br>
					<div>電子郵件 :</div>
					<form:input type="email" id="email" path="email" />
					${ErrMsg.errEmail}<br> <br>
					<div>地址 :</div>
					<form:input type="text" id="address" path="address" />
					${ErrMsg.errAddr}<br> <br>

				</div>
				<div id="buttonArea">
					<input type="button" value="確認購買" class="submit"
						onclick="confirmForm()"> <input type="button" value="全部清空"
						class="submit" onclick="confirmDeleteAll()">
				</div>

			</form:form>
		</c:if>

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