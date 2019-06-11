package com.web.store.controller._01_register;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.store.model.OssanBean;
import com.web.store.service.OssanService;

import _00_init.util.GlobalService;

@Controller
public class RegisterOssan {

	@Autowired
	OssanService service;

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";
	private Pattern pattern = null;
	private Matcher matcher = null;

	@RequestMapping(value = "OssanRegister", method = RequestMethod.GET)
	public String putRegisterOssan(Model model) {
		OssanBean ossanBean = new OssanBean();
		model.addAttribute("ossanBean", ossanBean);

		return "_01_register/OssanRegister";
	}

	@RequestMapping(value = "OssanRegister", method = RequestMethod.POST)
	public String getRegisterOssan(@ModelAttribute("ossanBean") OssanBean ossanBean, BindingResult result,
			HttpServletRequest request) {
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		String email = ossanBean.getEmail();
		String password = ossanBean.getPassword();
		String name = ossanBean.getName();
		String address = ossanBean.getAddress();
		String phone = ossanBean.getPhone();
		String uniqueId = ossanBean.getUniqueId();
		Date birthday = ossanBean.getBirthday();
		Timestamp registerTime = new java.sql.Timestamp(System.currentTimeMillis());
		if (email == null || email.trim().length() == 0) {
			errorMsg.put("errorIDEmpty", "帳號欄必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.put("errorPasswordEmpty", "密碼欄必須輸入");
		}

		if (name == null || name.trim().length() == 0) {
			errorMsg.put("errorName", "姓名欄必須輸入");
		}

		if (uniqueId == null || uniqueId.trim().length() == 0) {
			errorMsg.put("errorUid", "身分證字號必須輸入");
		}

		if (address == null || address.trim().length() == 0) {
			errorMsg.put("errorAddress", "地址欄必須輸入");
		}
		if (email == null || email.trim().length() == 0) {
			errorMsg.put("errorEmail", "電子郵件欄必須輸入");
		}

		if (phone == null || phone.trim().length() == 0) {
			errorMsg.put("errorTel", "電話號碼欄必須輸入");
		}

		if (birthday == null) {
			errorMsg.put("errorBirthday", "生日欄必須輸入");
		}

		if (errorMsg.isEmpty()) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				errorMsg.put("passwordError", "密碼至少含有一個大寫字母、小寫字母、數字與!@#$%!^'\"等四組資料組合而成，且長度不能小於八個字元");
			}
			boolean exist = service.isExist(email);
			if (exist) {
				errorMsg.put("IDExistError", "此帳號已存在");
			}
		}
		if (!errorMsg.isEmpty()) {
			return "_01_register/OssanRegister";
		}
		password = GlobalService.getMD5Endocing(GlobalService.encryptString(password));
		ossanBean.setPassword(password);
		ossanBean.setRegisterTime(registerTime);
		service.save(ossanBean);
		return "redirect:/";
	}

}
