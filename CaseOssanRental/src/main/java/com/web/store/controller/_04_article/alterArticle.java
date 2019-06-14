package com.web.store.controller._04_article;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.web.store.model.ArticleBean;
import com.web.store.model.OssanBean;
import com.web.store.service.ArticleRecommendService;
import com.web.store.service.ArticleService;

import _00_init.util.SystemUtils2018;

@Controller
public class alterArticle {

	@Autowired
	ArticleService service;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	ArticleRecommendService arService;

	@RequestMapping(value = "alterArticle/{articleNo}", method = RequestMethod.GET)
	public String putAlterArticle(@PathVariable("articleNo") Integer articleNo, HttpSession session,
			HttpServletRequest request, Model model) {
		ArticleBean articleBean = service.getArticle(articleNo);
		articleBean.setsContent(SystemUtils2018.clobToString(articleBean.getContent()));
		model.addAttribute("articleBean", articleBean);
		session.setAttribute("articleNo", articleNo);
		return "_03_personalInfo/alterArticle";
	}

	@RequestMapping(value="alterArticle/alterArticlePage", method=RequestMethod.POST)
	public String getAlterArticle(@ModelAttribute("articleBean") ArticleBean articleBean,BindingResult result, HttpSession session,
			HttpServletRequest request
	) {
		ArticleBean bean = service.getArticle(articleBean.getArticleNo());
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("ErrMsg", errorMsgs);
		String articleNo = String.valueOf(articleBean.getArticleNo());
		String title = articleBean.getTitle();
		String sContent = articleBean.getsContent();
		MultipartFile file = articleBean.getArtImage();
		Blob blob = null;
		String fileName = file.getOriginalFilename();
		if (title.trim().length() == 0 || title == null) {
			errorMsgs.put("errTitle", "標題不可為空白");
		}
		if (sContent.trim().length() == 0 || sContent == null) {
			errorMsgs.put("errSContent", "內容不可為空白");
		}
		if(!errorMsgs.isEmpty()) {
			session.setAttribute("stage","4");
			return "_03_personalInfo/alterArticle/"+articleNo+"";
		}
		if(file!=null && !file.isEmpty()) {
			try {
				byte[] b = file.getBytes();
				blob = new SerialBlob(b);
				fileName.substring(fileName.lastIndexOf("."));
				articleBean.setArticleImage(blob);
				articleBean.setFileName(fileName);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳異常");
			}
		}else {
			articleBean.setArticleImage(bean.getArticleImage());
		}
		
		Timestamp updateTime = new java.sql.Timestamp(System.currentTimeMillis());
		articleBean.setUpdateTime(updateTime);
		articleBean.setOssanBean(bean.getOssanBean());
		Clob content = SystemUtils2018.stringToClob(sContent);
		articleBean.setContent(content);
		service.updateArticle(articleBean);
		session.setAttribute("stage","4");
		return "redirect:/personalInfo";
	}

	@RequestMapping(value = "deleteArticle/{articleNo}", method = RequestMethod.GET)
	public String deleteArticle(@PathVariable("articleNo") Integer articleNo, HttpSession session, HttpServletRequest request) {
//		ArticleBean articleBean = service.getArticle(articleNo);
		service.deleteArticle(articleNo);
		return "redirect:/personalInfo";
	}
	@RequestMapping(value ="setRecommend/{articleNo}",method = RequestMethod.GET)
	public String setRecommend(@PathVariable("articleNo") Integer articleNo, HttpSession session, HttpServletRequest request) {
		OssanBean bean = (OssanBean) session.getAttribute("OssanLoginOK");
		
		Integer ossanNo = bean.getOssanNo();
		arService.setRecommend(ossanNo, articleNo);
		return"redirect:/personalInfo";
	}
	
	@RequestMapping(value = "/getArticlePicture", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp,HttpSession session,HttpServletRequest request) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		Integer articleNo = (Integer) session.getAttribute("articleNo");
		System.out.println(articleNo);
		ArticleBean bean = service.getArticle(articleNo);
		if (bean != null) {
			Blob blob = bean.getArticleImage();
			filename = bean.getFileName();
			if (blob != null) {
				try {
					len = (int) blob.length();
					media = blob.getBytes(1, len);
				} catch (SQLException e) {
					throw new RuntimeException("ProductController的getPicture()發生SQLException: " + e.getMessage());
				}
			} else {
				media = toByteArray(filePath);
				filename = filePath;
			}
		} else {
			media = toByteArray(filePath);
			filename = filePath;
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		String mimeType = context.getMimeType(filename);
		MediaType mediaType = MediaType.valueOf(mimeType);
		System.out.println("mediaType =" + mediaType);
		headers.setContentType(mediaType);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}

	private byte[] toByteArray(String filepath) {
		byte[] b = null;
		try {
			String realPath = context.getRealPath(filepath);
			File file = new File(realPath);
			long size = file.length();
			b = new byte[(int) size];
			InputStream fis = context.getResourceAsStream(filepath);
			fis.read(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

}
