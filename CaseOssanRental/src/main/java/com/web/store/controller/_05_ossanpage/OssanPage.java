package com.web.store.controller._05_ossanpage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.store.model.OssanBean;
import com.web.store.service.OssanService;

import _00_init.util.SystemUtils2018;

@Controller
public class OssanPage {
	
		@Autowired
		OssanService service;
	
		@RequestMapping("ossanPage/{ossanNo}")
		public String intoOssanPage(HttpServletRequest request,HttpSession session,@PathVariable Integer ossanNo
		) {
			OssanBean ossanBean = service.getOssanBeanByID(ossanNo);
			ossanBean.setsIntro(SystemUtils2018.clobToString(ossanBean.getIntro()));
			request.setAttribute("ossanBean", ossanBean);
			return "_05_ossanPage/ossanPage";
		}
}
