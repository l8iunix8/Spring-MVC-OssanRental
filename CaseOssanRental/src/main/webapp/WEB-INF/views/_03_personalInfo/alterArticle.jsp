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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alterArticle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script  src="https://code.jquery.com/jquery-3.4.0.js">
  	</script>

	<script src="${pageContext.request.contextPath}/js/fram.js"></script>
	<script src="${pageContext.request.contextPath}/js/alterArticle.js"></script>
</head>
<body style="min-width: 1200px;">
	<!-- 頂部的LOGO 以及各個點擊頁籤 -->
	<jsp:include page="../fragment/top.jsp" />	
		<!-- 文章管理===新增文章 -->
		<section id="alterArticle">
			<div id="alterArticletitle">新增文章</div>
			<span></span>
			<form:form action="alterArticlePage" id="uploadarticleform" method="POST" modelAttribute="articleBean" enctype="multipart/form-data">
				<form:input path="articleNo" type="hidden"/>

				
				<form:input path="articleImage" type="hidden"/>
				<form:input path="fileName" type="hidden"/>
				<div id="uploadarticleimageblock">
					<div id="uploadarticletitle">
					上傳文章照片
					</div>
					<div id="uploadarticleimage">
						<div id="articleimagefram">
							<img src="<c:url value='/getArticlePicture'/>" alt="" id="articleImage3">
						</div>			
						<br>	
						<form:input type="file" path="artImage" id="uploadarticleImage" onchange="verificationPicFile(this)"/> 
						<br><br><br><br>
						<input type="submit" value="修改" class="submit"> 
					</div>
				</div>
				
				<div id="uploadarticlecontentblock">
					<div id="articletitle" >文章標題 : <br>
						<form:input type="text" maxlength="50" path="title" style="width: 700px;"/>
					</div>
					<br>
					內容<br>
					<div id="articlecontent">
						<form:textarea path="sContent" id="articletextarea" cols="110" rows="29"/>	
					</div>
				</div>				
			</form:form>
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