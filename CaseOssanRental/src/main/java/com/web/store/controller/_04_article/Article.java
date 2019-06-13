package com.web.store.controller._04_article;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.web.store.model.ArticleBean;
import com.web.store.model.OssanBean;
import com.web.store.service.ArticleService;

import _00_init.util.SystemUtils2018;

@Controller
public class Article {

	@Autowired
	ArticleService service;

//	@RequestMapping(value = "personalInfo", method = RequestMethod.GET)
//	public String putArticle(Model model) {
//		ArticleBean articleBean = new ArticleBean();
//		model.addAttribute("articleBean",articleBean);
//		return "_03_personalInfo/personalInfo";
//	}

	@RequestMapping(value = "insertArticle", method = RequestMethod.POST)
	public String getArticle(
			@ModelAttribute("articleBean") ArticleBean articleBean,
			BindingResult result,
			HttpServletRequest request, 
			HttpSession session
			
		) {
		OssanBean ob = (OssanBean) session.getAttribute("OssanLoginOK");
		System.out.println(ob.getOssanNo());
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("ErrMsg", errorMsgs);
		MultipartFile file = articleBean.getArtImage();
		String fileName = file.getOriginalFilename();
		String sContent = articleBean.getsContent();
		String title = articleBean.getTitle();
		Date updateTime = new java.sql.Timestamp(System.currentTimeMillis());
		Blob blob = null;
		Clob clob = null;
		if(sContent==null||sContent.trim().length()==0) {
			errorMsgs.put("errContent","請輸入內容" );
		}
		if(title==null||title.trim().length()==0) {
			errorMsgs.put("errTitle","請輸入標題" );
		}
		if(file !=null && !file.isEmpty()) {
			try {
				byte[] b = file.getBytes();
				blob = new SerialBlob(b);
				fileName.substring(fileName.lastIndexOf("."));
			} catch (IOException | SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳異常");
			}
		}if(!errorMsgs.isEmpty()) {
			session.setAttribute("stage","4");
			return "redirect:/personalInfo";
		}
		clob = SystemUtils2018.stringToClob(sContent);		
		articleBean.setContent(clob);
		articleBean.setArticleImage(blob);
		articleBean.setFileName(fileName);
		articleBean.setUpdateTime(updateTime);
		service.insertArticle(articleBean, ob.getOssanNo());
		session.setAttribute("stage","4");
		return "redirect:/personalInfo";
	}

	

}
