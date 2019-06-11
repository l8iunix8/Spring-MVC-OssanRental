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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/FlexSlider-master/flexslider-rtl-min.css">
	
	<!-- slider套件 -->
	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugin/FlexSlider-master/jquery.flexslider.js"></script>
	<!-- <script src="../plugin/infinite-scroll-docs/infinite-scroll.pkgd.min.js"></script>	 -->
	<script type="text/javascript" charset="utf-8">
  		$(window).load(function() {
    		$('.flexslider').flexslider({
    			controlNav: false,
    			directionNav: false,
    			slideshowSpeed: 4500,
    		});   
    		
    		areaState = 0;
    		
    		$('#topninelist li:nth-child(2)').click(function(){
    			areaState = 2;
//     			console.log(areaState);
    		});
    		$('#topninelist li:nth-child(3)').click(function(){
    			areaState = 3;
//     			console.log(areaState);
    		});
    		$('#topninelist li:nth-child(4)').click(function(){
    			areaState = 4;
//     			console.log(areaState);
    		});
    		$('#topninelist li:nth-child(5)').click(function(){
    			areaState = 5;
//     			console.log(areaState);
    		});
  		});
	</script>
	<!-- slider套件 -->
	<script src="${pageContext.request.contextPath}/js/new.js"></script>
</head>
<body style="min-width: 1200px;">

	<!-- 頂部的LOGO 以及各個點擊頁籤 -->
	<jsp:include page="fragment/top.jsp" />
	
	<!-- 中間slider -->
	<section id="slideblock">
		<!-- <img src="../images/slide-2.jpg" alt=""> -->
		<div class="flexslider">
  			<ul class="slides">
    			<li>
      				<img src="${pageContext.request.contextPath}/images/slide-2.jpg" />
    			</li>
    			<li>
      				<img src="${pageContext.request.contextPath}/images/slide-3.jpg" />
    			</li>
    			<li>
      				<img src="${pageContext.request.contextPath}/images/slide-4.jpg" />
    			</li>
  			</ul>
		</div>
		<div id="scrolltext">
			<h2> 出 租 | 大 叔</h2>
			<span></span>
			<p> 情緒在角落時，我知道</p>
			<p> 有一個聲音會無條件的支持我</p>
			<p id="match"><a href="www.">隨機配對</a></p>
		</div>
	</section>
	<!-- 人氣大叔列表 取九位 -->
	<section id="topnine">
		<p>大叔列表</p>
		<span id="topninehead"></span>
		<div id="topninechoiseblock">
			<ul id="topninelist">
<!-- 				<li><a href="www.">篩選 :</a></li> -->
<!-- 				<li><a href="www.">全部</a></li> -->
<!-- 				<li><a href="www.">北部</a></li> -->
<!-- 				<li><a href="www.">中部</a></li> -->
<!-- 				<li><a href="www.">南部</a></li> -->
				<li>篩選 :</li>
				<li>全部</li>
				<li>北部</li>
				<li>中部</li>
				<li>南部</li>
			</ul>
		</div>
		<div id="ossanlist">
			<ol>
				<c:forEach varStatus="stVar"  var="allOssanBean"  items="${allOssanBean}">
					<ul onclick="window.location='ossanPage/${allOssanBean.ossanNo}'">
<!-- 					<ul> -->
						<img src="<c:url value='getIndexOssanImage/${allOssanBean.ossanNo}'/>">
						<div>${allOssanBean.quote}</div>
					</ul>
				</c:forEach>
<!-- 				<ul><img src="images/work/1.jpg" alt=""><div>人生沒有如果，只有結果與後果</div></ul> -->
<!-- 				<ul><img src="images/work/2.jpg" alt=""><div>最簡單的事是堅持，最難的事還是堅持</div></ul> -->
<!-- 				<ul><img src="images/work/3.jpg" alt=""><div>學會堅強，做一隻沙漠中永不哭泣的駱駝!</div></ul> -->
<!-- 				<ul><img src="images/work/4.jpg" alt=""><div>請註意寬容與忍讓的區別，前者是平靜的大海，後者是待噴的火山。</div></ul> -->
<!-- 				<ul><img src="images/work/5.jpg" alt=""><div>世界上最大的容器叫胸懷。</div></ul> -->
<!-- 				<ul><img src="images/work/6.jpg" alt=""><div>海的偉大是因為它能容納千江萬河;海的平凡是因為它來源於一點一滴。</div></ul> -->
<!-- 				<ul><img src="images/work/7.jpg" alt=""><div>檢驗兩隻雞的友誼，要等出現一條蟲子的時候。</div></ul> -->
<!-- 				<ul><img src="images/work/8.jpg" alt=""><div>真誠是交友的最高技藝，洞察力是交友的重要安全保障，寬容是培植友情的沃土。</div></ul> -->
<!-- 				<ul><img src="images/work/9.jpg" alt=""><div>陽光能驅走嚴寒，友誼能化解憂愁。</div></ul> -->
<!-- 				<ul><img src="images/work/1.jpg" alt=""><div>鮮花要用水澆灌，友誼要靠人珍惜。</div></ul> -->
<!-- 				<ul><img src="images/work/2.jpg" alt=""><div>驕傲是勝利下的蛋，孵出來的卻是失敗</div></ul> -->
<!-- 				<ul><img src="images/work/3.jpg" alt=""><div>創業艱辛須努力，求知深廣要謙虛。</div></ul>				 -->
<!-- 				<ul><img src="images/work/4.jpg" alt=""><div>不是山，卻需要攀登的是人生;不是淵，卻需要跨越的是自己</div></ul>				 -->
<!-- 				<ul><img src="images/work/5.jpg" alt=""><div>不懈奮鬥，生命才有輝煌;努力學習，思想才有靈光。</div></ul>				 -->
<!-- 				<ul><img src="images/work/6.jpg" alt=""><div>生命因短暫而寶貴，友誼因真誠而珍貴。</div></ul>				 -->
<!-- 				<ul><img src="images/work/7.jpg" alt=""><div>花中牡丹最鮮艷，人間友情最可貴。</div></ul>				 -->
			</ol>
			<div style="clear:both"></div>	
		</div>    	
	</section>
	<!-- 聯絡方式 -->
<!-- 	<section id="information"> -->
<!-- 		<div id="address"> -->
<!-- 			<img src="icon/home.png" alt=""> -->
<!-- 			<br> -->
<!-- 			<span>北科204</span> -->
<!-- 		</div> -->
<!-- 		<div id="phone"> -->
<!-- 			<img src="icon/smartphone-call.png" alt=""> -->
<!-- 			<br> -->
<!-- 			<span>0911-111-222</span> -->
<!-- 		</div> -->
<!-- 		<div id="email"> -->
<!-- 			<img src="icon/message-closed-envelope.png" alt=""> -->
<!-- 			<br> -->
<!-- 			<span>QQ123@ntut.edu.tw</span>			 -->
<!-- 		</div> -->
<!-- 	</section> -->
<!-- 	<!-- 最底部 版權 --> -->
<!-- 	<footer id="copyright"> -->
<!-- 		<div>版權所有，翻印必究</div> -->
<!-- 	</footer>	 -->
</body>
</html>