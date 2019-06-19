<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fram.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/fragment.js"></script>
<script src="${pageContext.request.contextPath}/js/searchOssan.js"></script>


<!-- <script -->
<%-- 	src="${pageContext.request.contextPath}/javascript/jquery-1.9.1.js"></script> --%>
<%-- <c:set var='debug' value='true' scope='application' /> --%>
<hr>
<table>
	<c:if
		test="${empty OssanLoginOK && empty ManagerLoginOK && empty AdminLoginOK}">
		<header id="topblock">
			<div id="topinsidecontext">
				<div id="logo">ossan.Rental</div>
				<div id="page">
					<ul id="pageblock">
						<li id="index"><a href="<c:url value='/'/>">首頁</a></li>
						<li id="searchossan"><a id="searchBar">搜尋大叔</a></li>
						<li id="searchOssanLi">
							<form action="<c:url value='/searchOssan'/>" id="searchForm" name="searchForm" method="POST">
								<input type="text" id="searchInput" name="keyword"> 
								<input type="image" 
									src="${pageContext.request.contextPath}/icon/search.png" onclick="document.searchForm.submit()"
									id="submitImage">
							</form>
						</li>
						<li id="story"><a href="story.html">大叔故事</a></li>
						<li id="join"><a href="<c:url value='/OssanRegister'/>">加入大叔</a></li>
						<li id="idea"><a href="idea.html">網站理念</a></li>
						<li id="checkout"><a href="<c:url value='/shoppingCart'/>">結帳</a></li>
						<li id="login"><a href="<c:url value='/login'/>">大叔登入</a></li>
					</ul>
				</div>
			</div>
			<div style="clear: all;"></div>
		</header>
	</c:if>

	<c:if
		test="${!empty OssanLoginOK && empty ManagerLoginOK && empty AdminLoginOK}">
		<header id="topblock">
			<div id="topinsidecontext">
				<div id="logo">ossan.Rental</div>
				<div id="page">
					<ul id="pageblock">
						<li id="index"><a href="<c:url value='/'/>">首頁</a></li>
						<!-- 						<li id="searchossan"><a href="">搜尋大叔</a></li> -->
						<!-- 						<li id="story"><a href="story.html">大叔故事</a></li> -->
						<li id="personalInfo"><a
							href="<c:url value='/personalInfo'/>">個人資料</a></li>
						<!-- 						<li id="idea"><a href="idea.html">網站理念</a></li> -->
						<li id="checkout"><a href="<c:url value='/shoppingCart'/>">結帳</a></li>
						<li id="logout"><a href="<c:url value='/logout'/>">大叔登出</a></li>
					</ul>
				</div>
			</div>
			<div style="clear: all;"></div>
		</header>
	</c:if>

	<c:if
		test="${empty OssanLoginOK && !empty ManagerLoginOK && empty AdminLoginOK}">
		<header id="topblock">
			<div id="topinsidecontext">
				<div id="logo">ossan.Rental</div>
				<div id="page">
					<ul id="pageblock">
						<li id="index"><a href="<c:url value='/'/>">首頁</a></li>
						<li id="searchossan"><a href="">全部大叔</a></li>
						<li id="story"><a href="story.html">全部大叔故事</a></li>
						<li id="idea"><a href="idea.html">客服</a></li>
						<li id="logout"><a href="/logout">大叔登出</a></li>
					</ul>
				</div>
			</div>
			<div style="clear: all;"></div>
		</header>
	</c:if>
	<c:if
		test="${empty OssanLoginOK && empty ManagerLoginOK && !empty AdminLoginOK}">
		<header id="topblock">
			<div id="topinsidecontext">
				<div id="logo">ossan.Rental</div>
				<div id="page">
					<ul id="pageblock">
						<li id="index"><a href="<c:url value='/'/>">首頁</a></li>
						<li id="searchossan"><a href="">搜尋大叔</a></li>
						<li id="story"><a href="story.html">大叔故事</a></li>
						<li id="join"><a href="join.html">加入大叔</a></li>
						<li id="idea"><a href="idea.html">網站理念</a></li>
						<li id="personalInfo"><a href="/personalInfo">個人資料</a></li>
						<li id="checkout"><a href="<c:url value='/shoppingCart'/>">結帳</a></li>
						<li id="logout"><a href="/logout">大叔登出</a></li>
					</ul>
				</div>
			</div>
			<div style="clear: all;"></div>
		</header>
	</c:if>
</table>
<hr>

