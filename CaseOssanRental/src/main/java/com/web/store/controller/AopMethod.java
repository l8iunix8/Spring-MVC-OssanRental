package com.web.store.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.web.store.model.ArticleBean;
import com.web.store.model.OrderItemBean;
import com.web.store.model.OssanBean;
import com.web.store.service.ArticleService;
import com.web.store.service.OrderItemService;
import com.web.store.service.OssanService;

import _00_init.util.GlobalService;

@Component
@Aspect
public class AopMethod {
//	@Before("execution(* com.web.store.controller._02_login.login.*(..))")
//	public void index() {
//		System.out.println("00000000000000000000000");
//	}
	@Autowired
	private HttpSession session;
	@Autowired
	ArticleService articleService;
	
	@Autowired
	OssanService ossanService;
	
	@Autowired
	OrderItemService orderitemService;

	@Before("execution(* com.web.store.controller._02_login.login.*(..))")
	public void loginCookie() {
		System.out.println("000000000000000000000");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		// **********Remember Me****************
		String cookieName = "";
		String user = "";
		String password = "";
		String rememberMe = "";
		// 取出瀏覽器送來的Cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) { // 如果含有Cookie
			for (int i = 0; i < cookies.length; i++) { // 檢視每個Cookie
				cookieName = cookies[i].getName();
				if (cookieName.equals("user")) {
					// 找到user這個Cookie
					user = cookies[i].getValue();
				} else if (cookieName.equals("password")) {
					// 找到password這個Cookie
					String tmp = cookies[i].getValue();
					// 將密碼解密
					if (tmp != null) {
						password = GlobalService.decryptString(GlobalService.KEY, tmp);
					}
				} else if (cookieName.equals("rm")) {
					// 找到rm這個Cookie(rm: rememberMe)
					rememberMe = cookies[i].getValue();
				}
			}
		} else {
			// 找不到Cookie，沒有關係，就讓使用者輸入資料即可。
		}
		// 將這三項資料存入request物件
		request.setAttribute("rememberMe", rememberMe);
		request.setAttribute("user", user);
		request.setAttribute("password", password);
	}

	@Before("execution(* com.web.store.controller._03_personalInfo.PersonalInfo.putPersonalInfo(..))")
	public void intoPersonalPage() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getResponse();
		OssanBean ossanBean = (OssanBean) session.getAttribute("OssanLoginOK");
		Integer ossanNo = ossanBean.getOssanNo();
		String pageNoStr = request.getParameter("pageNo_up");
		int pageNo_up = 1;
		// 如果讀不到，代表第一次點選大叔故事
		if (pageNoStr == null) {
			pageNo_up = 1;
			// 讀取瀏覽器送來的所有 Cookies
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				// 逐筆檢視Cookie內的資料
				for (Cookie c : cookies) {
					if (c.getName().equals(ossanNo + "pageNo_up")) {
						try {
							pageNo_up = Integer.parseInt(c.getValue().trim());
						} catch (NumberFormatException e) {
							;
						}
						break;
					}
				}
			}
		} else {
			try {
				pageNo_up = Integer.parseInt(pageNoStr.trim());
			} catch (NumberFormatException e) {
				pageNo_up = 1;
			}
		}
		articleService.setPageNo(pageNo_up);
		Collection<ArticleBean> coll = articleService.getPageArticles(ossanNo);
		session.setAttribute("pageNo_up", pageNo_up);
		session.setAttribute("totalPages_up",String.valueOf( articleService.getTotalPages(ossanNo))); //個人頁面的文章數
		session.setAttribute("products_DPP", coll);
//		 使用Cookie來儲存目前讀取的網頁編號，Cookie的名稱為memberId + "pageNo"
//		 -----------------------
		Cookie pn_upCookie = new Cookie(ossanNo + "pageNo_up", String.valueOf(pageNo_up));
	    // 設定Cookie的存活期為30天
		pn_upCookie.setMaxAge(30 * 24 * 60 * 60);
	    // 設定Cookie的路徑為 Context Path		
		pn_upCookie.setPath(request.getContextPath());
		// 將Cookie加入回應物件內
		response.addCookie(pn_upCookie);
		
	}
	
	@Before("execution(* com.web.store.controller.HomePage.homePage(..))||execution(* com.web.store.controller.HomePage.indexHomePage(..))")
	public void intoIndex() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		List<OssanBean> allOssanBean = ossanService.getAllOssanBean();
		request.setAttribute("allOssanBean", allOssanBean);
	}
	
	@Before("execution(* com.web.store.controller._03_personalInfo.PersonalInfo.putPersonalInfo(..))")
	public void tradeRecord() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		List<OrderItemBean> ossanOrderItem = new ArrayList<>();
		OssanBean ossanBean = (OssanBean) session.getAttribute("OssanLoginOK");
		Integer ossanNo = ossanBean.getOssanNo();
		ossanOrderItem = orderitemService.getOrderItemList(ossanNo);
		session.setAttribute("personalOrderList", ossanOrderItem);
	}

}
