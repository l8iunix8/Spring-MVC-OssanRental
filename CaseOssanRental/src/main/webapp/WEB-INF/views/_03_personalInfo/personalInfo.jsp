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
	href="${pageContext.request.contextPath}/css/personalinfo.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.0.js">
	
</script>
<script src="${pageContext.request.contextPath}/js/personalinfo.js"></script>
<script src="${pageContext.request.contextPath}/js/fram.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		var stage = ${stage}; 
		console.log(stage);
		switch(stage){
			case 1:
				$('#infocontent01').css('display','block');
		        $('#infocontent02').css('display','none');
		        $('#infocontent03').css('display','none');
		        $('#infocontent04').css('display','none');
		        $('#infocontent05').css('display','none');
		        $('#infocontent06').css('display','none');
		        $('#infocontent07').css('display','none');
				break;
			case 2:
				$('#infocontent01').css('display','none');
		        $('#infocontent02').css('display','block');
		        $('#infocontent03').css('display','none');
		        $('#infocontent04').css('display','none');
		        $('#infocontent05').css('display','none');
		        $('#infocontent06').css('display','none');
		        $('#infocontent07').css('display','none');
		        break;
			case 3:
				$('#infocontent01').css('display','none');
		        $('#infocontent02').css('display','none');
		        $('#infocontent03').css('display','block');
		        $('#infocontent04').css('display','none');
		        $('#infocontent05').css('display','none');
		        $('#infocontent06').css('display','none');
		        $('#infocontent07').css('display','none');
				break;
			case 4:
				$('#infocontent01').css('display','none');
		        $('#infocontent02').css('display','none');
		        $('#infocontent03').css('display','none');
		        $('#infocontent04').css('display','block');
		        $('#infocontent05').css('display','none');
		        $('#infocontent06').css('display','none');
		        $('#infocontent07').css('display','none');
				break;
			case 5:
				$('#infocontent01').css('display','none');
		        $('#infocontent02').css('display','none');
		        $('#infocontent03').css('display','none');
		        $('#infocontent04').css('display','none');
		        $('#infocontent05').css('display','block');
		        $('#infocontent06').css('display','none');
		        $('#infocontent07').css('display','none');
				break;
			case 6:
				$('#infocontent01').css('display','none');
		        $('#infocontent02').css('display','none');
		        $('#infocontent03').css('display','none');
		        $('#infocontent04').css('display','none');
		        $('#infocontent05').css('display','none');
		        $('#infocontent06').css('display','block');
		        $('#infocontent07').css('display','none');
				break;
			case 7:
				$('#infocontent01').css('display','none');
		        $('#infocontent02').css('display','none');
		        $('#infocontent03').css('display','none');
		        $('#infocontent04').css('display','none');
		        $('#infocontent05').css('display','none');
		        $('#infocontent06').css('display','none');
		        $('#infocontent07').css('display','block');
				break;
		}
	});
	
	

</script>

</head>
<body style="min-width: 1200px;">

	<!-- 頂部的LOGO 以及各個點擊頁籤 -->
	<jsp:include page="../fragment/top.jsp" />
	<!-- 個人資料 -->
	<section id="personalinfoblock">
		<div id="infotitle">
			<div id="infotitleblock">
				<span id="listpersonalinfo" style="cursor: pointer">個人基本資料</span><br>
				<br> <span id="listuploadimage" style="cursor: pointer">上傳照片及介紹</span><br>
				<br> <span id="listpayinfo" style="cursor: pointer">付款資料</span><br>
				<br> <span id="listarticlemanage" style="cursor: pointer">文章管理</span><br>
				<br> <span id="listchangepassword" style="cursor: pointer">變更密碼</span><br>
				<br> <span id="transactionrecord" style="cursor: pointer">交易紀錄</span><br>
				<br>

			</div>
			<div id="listarticlemanagelist">
				<span id="listarticlemanagelist01" style="cursor: pointer"><a
					href="<c:url value='listArticle_Ossan.do'/>  ">文章列表</a> </span>
				<hr>
				<span id="listarticlemanagelist02" style="cursor: pointer">新增文章</span>
			</div>
		</div>

		<!-- 個人資料內容 -->
		<div id="infocontent01">
			<%-- 		<c:set var="name" value='${ossanBean.name}'/> --%>
			<%-- 		<c:set var="nickname" value='${ossanBean.nickname}'/> --%>
			<%-- 		<c:set var="uid" value='${ossanBean.uid}'/> --%>
			<%-- 		<c:set var="birth" value='${ossanBean.birthday}'/> --%>
			<%-- 		<c:set var="address" value='${ossanBean.address}'/> --%>
			<%-- 		<c:set var="tel" value='${ossanBean.tel}'/> --%>
			<%-- 		<c:set var="email" value='${ossanBean.email}'/> --%>
			<%-- 		<c:set var="area" value='${ossanBean.area}'/> --%>
			<%-- 		${errorMsgs.errMemberId} --%>
			<!-- 個人基本資料 -->
			<form:form action="personalInfo01" id="personalform" method="POST"
				modelAttribute="ossanBean">
				<div>真實姓名</div>
				<form:input type="text" path="name" />${ErrMsg.errMemberId}<br>
				<br>
				<div>暱稱</div>
				<form:input type="text" path="nickname" />
				<br>
				<br>
				<%-- 				<div>身分證字號</div><form:input type="text" path="uniqueId" value="${uid}"/>${ErrMsg.errUid}<br><br> --%>
				<div>出生年月日</div>
				<form:input type="date" path="birthday" />${ErrMsg.errBirthday}<br>
				<br>
				<div>地址</div>
				<form:input type="text" style="width:216px" path="address" />${ErrMsg.errAddress}<br>
				<br>
				<div>連絡電話</div>
				<form:input type="text" path="phone" />${ErrMsg.errTel}<br>
				<br>
				<!-- 				&nbsp;&nbsp;<input type="button" value="重新寄送確認信" style="width: 100px;"><br><br> -->
				所在地區 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<form:radiobutton value="north" path="area" />北部
				<form:radiobutton value="mid" path="area" />中部
				<form:radiobutton value="south" path="area" />南部
				<form:radiobutton value="east" path="area" />東部
				${ErrMsg.errArea}
				<!-- <p>電子郵件(確認)</p><input type="text"> -->
				<button type="submit" class="submit">存檔</button>>
			</form:form>
		</div>

		<!-- 上傳照片 -->
		<div id="infocontent02">
			<form:form action="personalInfo02" id="introduceform"
				enctype="multipart/form-data" method="POST"
				modelAttribute="ossanBean">
				<div id="uploadimagetitle">
					上傳個人照片及簡介 <span></span>
				</div>
				<div id="uploadpersonalimage">
					<div id="imagefram">
						<img src="<c:url value='/getOssanPicture'/>" alt="" id="img">
					</div>
					<br>

					<form:input type="file" path="introImage" id="uploadImage"
						onchange="verificationPicFile(this)" />
					<br>
					<br>
					<br>
					<br> <input type="submit" value="修改" class="submit">
				</div>
				<div id="word">
					<div>
						<span>個人格言或語錄 :</span><br>
						<br>
						<form:input type="text" path="quote" style="width: 100%;"
							placeholder="${ErrMsg.errQuote}" />
					</div>
					<br>
					<br>
					<div>
						<span>個人介紹(讓大家認識你) :</span><br>
						<br>
						<form:textarea path="sIntro" id="" cols="90" rows="18"
							style="resize: none; overflow-y: scroll;" />${ErrMsg.errIntro}
					</div>
				</div>
			</form:form>
		</div>
		${ErrMsg.errTitle}
		<!-- 付款資料 -->
		<div id="infocontent03">
			<form action="post" id="paymentleft">
				<span>大叔收款帳號</span><br>
				<br>
				<div>銀行</div>
				<input type="text"><br>
				<br>
				<div>銀行代碼</div>
				<input type="text"><br>
				<br>
				<div>銀行帳號</div>
				<input type="text"><br>
				<br> <input type="submit" value="儲存" id="payleftsubmit">
			</form>
			<div id="paymentmid">
				<span>預約面試</span><br>
				<br>

				<div>
					<p>您是第一次使用本服務嗎?</p>
					<br>
					<p>如果是，請先與我們的專人預約面試</p>
					<br>
					<p>才可以成為正式會員喔~</p>
				</div>
				<a href="www." id="appointment">我要預約</a>
			</div>
			<form action="post" id="paymentright">
				<span>大叔訂閱服務</span><br>
				<br>
				<div id="hint">(您必須開通此功能才可以將您的資料上架)</div>
				<br> <input type="checkbox" name="subscribe">月繳:&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="subscribe">季繳<br>
				<br> <input type="checkbox" name="subscribe">半年繳&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="subscribe">年繳<br>
				<br> <input type="submit" value="進入繳費畫面" id="payrightsubmit">
			</form>
		</div>
		<!-- 文章管理===文章列表 -->
		<div id="infocontent04">
			<div id="articlelist">
				<div class="articlelisttitle">文章列表</div>
				<span></span>
				<div id="articlelistform">
					<select name="sequence" id="sequence">
						<option value="從新到舊">從新到舊</option>
						<option value="從舊到新">從舊到新</option>
					</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文章是否要上架 <input
						type="radio" value="yes" name="online" checked="checked">是
					<input type="radio" value="yes" name="online">否 <br>
					<br>
					<table id="querytable">
						<tr>
							<td>標題</td>
							<td>內文</td>
							<td>最後修改時間</td>
							<td>操作</td>
						</tr>
						<c:forEach varStatus="stVar" var="aOssanBean"
							items="${products_DPP}">
							<tr>
								<td>${aOssanBean.title}</td>
								<td>${aOssanBean.sContent}</td>
								<td><c:out value="${aOssanBean.updateTime}" /></td>
								<td>

									<form method="GET"
										action="alterArticle/${aOssanBean.articleNo}">
										<input type="hidden" value="${aOssanBean.articleNo}"
											name="articleNo"> <input type="submit" value="編輯">
									</form>
									<form method="GET"
										action="deleteArticle/${aOssanBean.articleNo}">
										<input type="submit" value="刪除">
									</form> <input type="submit" value="設為推薦文章" name="文章編號">

								</td>
							</tr>
						</c:forEach>
					</table>
					<br>
					<br>
					<div id="changepage">
						<c:if test="${pageNo_up > 1}">
							<a href="<c:url value='personalInfo?pageNo_up=${pageNo_up-1}'/> "
								style="color: black; text-decoration: none">上一頁</a>
								/
							</c:if>
						<c:if test="${pageNo_up != totalPages_up}">
							<a href="<c:url value='personalInfo?pageNo_up=${pageNo_up+1}'/>"
								style="color: black; text-decoration: none">下一頁</a>
						</c:if>
					</div>

					<br>
					<br>
					<div class="articlelisttitle">目前推薦文章</div>
					<table id="recommendarticle">
						<tr>
							<td>5</td>
							<td>曾經的記憶04</td>
							<td></td>
							<td></td>
							<td></td>
							<td><input type="submit" value="編輯" name="文章編號"> <input
								type="submit" value="刪除" name="文章編號"></td>
						</tr>
					</table>
				</div>
				<br>
			</div>
		</div>
		<!-- 文章管理===新增文章 -->
		<div id="infocontent05">
			<form:form action="insertArticle" id="uploadarticleform"
				enctype="multipart/form-data" method="POST"
				modelAttribute="articleBean">

				<div id="uploadarticleimageblock">
					<div id="uploadarticletitle">上傳文章照片</div>
					<div id="uploadarticleimage">
						<div id="articleimagefram">
							<img src="" alt="" id="articleImage">
						</div>
						<br>
						<form:input type="file" path="artImage" id="uploadarticleImage"
							onchange="verificationPicFile(this)" />
						<br>
						<br>
						<br>
						<br> <input type="submit" value="修改" class="submit">
					</div>
				</div>

				<div id="uploadarticlecontentblock">
					<div id="articletitle">
						文章標題 : <br>
						<form:input type="text" maxlength="50" style="width: 700px;"
							path="title" />
					</div>
					<br> 內容<br>
					<div id="articlecontent">
						<form:textarea path="sContent" id="articletextarea" cols="110"
							rows="29" />
					</div>
				</div>
			</form:form>
		</div>
		<!-- 變更密碼 -->
		<div id="infocontent06">

			<div id="changepassword">
				<div>變更密碼</div>
				<span></span> <br>
				<br>
				<br>
				<form action="alterPassword.do" method="POST"
					enctype="multipart/form-data">
					輸入舊密碼 : <br>
					<input type="password" maxlength="16" name="password">${ErrMsg.errPassword}<br>
					<br> 輸入新密碼 :<br>
					<input type="password" maxlength="16" name="newPassword">${ErrMsg.errNewPassword}<br>
					<br> 確認新密碼 :<br>
					<input type="password" maxlength="16" name="newPasswordConfirm">${ErrMsg.errNewPasswordConfirm}<br>
					<br>
					${ErrMsg.errWrongPassword}${ErrMsg.errConfirmPassword}${ErrMsg.errTitle}${ErrMsg.passwordError}
					<br>
					<br>
					<br> <input type="submit" value="提交"
						style="width: 50px; height: 20px; border: 0px; border-radius: 5px;">
				</form>
			</div>


		</div>
		<!-- 交易紀錄 -->
		<div id="infocontent07">
			<div id="transactionrecordtitle">交易紀錄</div>
			<span id="transactionrecordtitleline"></span>
			<table id="transactionrecordtable">

				<tr>
					<td>訂單編號</td>
					<td>客戶姓名</td>
					<td>電話號碼</td>
					<td>電子郵件</td>
					<td>操作</td>
				</tr>
				<c:forEach var="ossanOrderList" items="${personalOrderList}">
					<tr>
						<td>${ossanOrderList.orderBean.orderNo}</td>
						<td>${ossanOrderList.orderBean.invoiceTitle}</td>
						<td>${ossanOrderList.orderBean.phone}</td>
						<td>${ossanOrderList.orderBean.email}</td>
						<td><form
								action="orderDetail/${ossanOrderList.orderBean.orderNo}">
								<input type="submit" value="詳情"> &nbsp;
							</form></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
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