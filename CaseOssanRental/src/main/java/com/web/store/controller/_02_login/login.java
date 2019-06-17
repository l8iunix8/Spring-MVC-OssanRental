package com.web.store.controller._02_login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.store.model.OssanBean;
import com.web.store.service.ArticleRecommendService;
import com.web.store.service.OssanService;

import _00_init.util.GlobalService;

@Controller
public class login {
	@Autowired
	OssanService service;
	
	@Autowired
	ArticleRecommendService arService;

	private String ADMINID = "admin@gmail.com";
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin() {
		return "_02_login/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String putLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 定義存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();

		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		// 1. 讀取使用者輸入資料
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rm = request.getParameter("rememberMe");

		// 如果 userId 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (email == null || email.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}
		// 如果 password 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}

		// 如果 errorMsgMap 不是空的，表示有錯誤，交棒給login.jsp
		if (!errorMsgMap.isEmpty()) {

			return "_02_login/login";
		}
		// **********Remember Me****************************
		Cookie cookieUser = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
		// rm存放瀏覽器送來之RememberMe的選項，如果使用者對RememberMe打勾，rm就不會是null
		if (rm != null) {
			cookieUser = new Cookie("user", email);
			cookieUser.setMaxAge(7 * 24 * 60 * 60); // Cookie的存活期: 七天
			cookieUser.setPath(request.getContextPath());

			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(7 * 24 * 60 * 60);
			cookiePassword.setPath(request.getContextPath());

			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(7 * 24 * 60 * 60);
			cookieRememberMe.setPath(request.getContextPath());
		} else { // 使用者沒有對 RememberMe 打勾
			cookieUser = new Cookie("user", email);
			cookieUser.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
			cookieUser.setPath(request.getContextPath());

			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(0);
			cookiePassword.setPath(request.getContextPath());

			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(0);
			cookieRememberMe.setPath(request.getContextPath());
		}
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
		// ********************************************
		request.setAttribute("rememberMe", rm);
		request.setAttribute("user", email);
		request.setAttribute("password", password);
		password = GlobalService.getMD5Endocing(GlobalService.encryptString(password));
		
		boolean exist = service.ossanExist(email, password);
		if (exist) {
			Integer permission = arService.getPermission(email);
			if (permission==3) {
				OssanBean ossanBean = service.getOssanBean(email);
				session.setAttribute("AdminLoginOK", ossanBean);
			} else if (permission==2){
				OssanBean ossanBean = service.getOssanBean(email);
				session.setAttribute("ManagerLoginOK", ossanBean);
			}else{
				OssanBean ossanBean = service.getOssanBean(email);
				session.setAttribute("OssanLoginOK", ossanBean);
			}
		} else {
			errorMsgMap.put("DontHaveUser", "帳號或密碼輸入錯誤");
			
			return "_02_login/login";
		}

		return "redirect:/";
	}
}
