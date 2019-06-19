package com.web.store.controller._03_personalInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.web.store.model.ArticleBean;
import com.web.store.model.OssanBean;
import com.web.store.model.OssanRecommendBean;
import com.web.store.service.ArticleRecommendService;
import com.web.store.service.ArticleService;
import com.web.store.service.OssanService;

import _00_init.util.SystemUtils2018;

@Controller
public class PersonalInfo {
	
	@Autowired
	OssanService service;
	@Autowired
	ServletContext context;
	
	@Autowired
	ArticleRecommendService arService;
	
	@Autowired
	ArticleService aService;
	
	@RequestMapping(value="personalInfo",method=RequestMethod.GET)
	public String putPersonalInfo(Model model , HttpSession session,HttpServletRequest request) {
		OssanBean ossanBean =  (OssanBean) session.getAttribute("OssanLoginOK");
		String sIntro = SystemUtils2018.clobToString(ossanBean.getIntro());
		ossanBean.setsIntro(sIntro);
		ArticleBean articleBean = new ArticleBean();
		model.addAttribute("articleBean",articleBean);
		model.addAttribute("ossanBean", ossanBean);
		if(articleBean.getArticleNo()!=null) {
			ArticleBean bean = aService.getArticle(arService.getRecommend(ossanBean.getOssanNo()));
			bean.setsContent(SystemUtils2018.clobToString(bean.getContent()));
			request.setAttribute("recommendArticle", bean);
		}
		
		return "_03_personalInfo/personalInfo";
	}
	
	@RequestMapping(value="personalInfo01",method=RequestMethod.POST)
	public String getPersonalInfo01(
			@ModelAttribute("ossanBean") OssanBean ossanBean,
			BindingResult result,
			HttpSession session,
			HttpServletRequest request
			
	){
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("ErrMsg", errorMsgs);
		String name = ossanBean.getName();
		String nickname = ossanBean.getNickname();
		Date birthday = ossanBean.getBirthday();
		String address = ossanBean.getAddress();
		String phone = ossanBean.getPhone();
		String area = ossanBean.getArea();
		if (name == null || name.trim().length() == 0) {
			errorMsgs.put("errMemberId", "必須輸入姓名");
		}if (address == null || address.trim().length() == 0) {
			errorMsgs.put("errAddress", "必須輸入地址");
		}if (phone == null || phone.trim().length() == 0) {
			errorMsgs.put("errTel", "必須輸入電話");
		}if (birthday == null) {
			errorMsgs.put("errBirthday", "必須輸入出生日期");
		}if (area == null) {
			errorMsgs.put("errArea", "必須輸入地區");
		}
		if(!errorMsgs.isEmpty()) {
			session.setAttribute("stage","1");
			return "_03_personalInfo/personalInfo";			
		}
		OssanBean ob = (OssanBean) session.getAttribute("OssanLoginOK");
		ob.setName(name);
		ob.setNickname(nickname);
		ob.setBirthday(birthday);
		ob.setAddress(address);
		ob.setPhone(phone);
		ob.setArea(area);
		service.update(ob);
		session.setAttribute("OssanLoginOK", ob);
		session.setAttribute("stage","1");
		return "redirect:/personalInfo";
	}
	@RequestMapping(value="personalInfo02",method=RequestMethod.POST)
	public String getPersonalInfo02(
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("ossanBean") OssanBean ossanBean,
			BindingResult result
	) {
		OssanBean ob = (OssanBean) session.getAttribute("OssanLoginOK");
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("ErrMsg", errorMsgs);
		MultipartFile file = ossanBean.getIntroImage();
		String fileName = file.getOriginalFilename();
		ossanBean.setFileName(fileName);
		String quote = ossanBean.getQuote();
		String intro = ossanBean.getsIntro();
		Blob blob = null;
		if(quote==null||quote.trim().length()==0) {
			errorMsgs.put("errQuote","請輸入座右銘" );
		}if(intro==null||intro.trim().length()==0) {
			errorMsgs.put("errIntro","請輸入自我介紹" );
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
		}else {
			blob = ob.getOssanImage();
			fileName = ob.getFileName();
		}
		if(!errorMsgs.isEmpty()) {
			session.setAttribute("stage","2");
			return "_03_personalInfo/personalInfo";
		}
		Clob clob = SystemUtils2018.stringToClob(intro);		
		ob.setOssanImage(blob);
		ob.setQuote(ossanBean.getQuote());
		ob.setIntro(clob);
		ob.setFileName(fileName);
		
		
		
		service.update(ob);
		session.setAttribute("OssanLoginOK", ob);
		session.setAttribute("stage","2");
		
		return "redirect:/personalInfo";
	}
	@RequestMapping(value = "/getOssanPicture", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp,HttpSession session) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		OssanBean bean = (OssanBean) session.getAttribute("OssanLoginOK");
		if (bean != null) {
			Blob blob = bean.getOssanImage();
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
	
//	@InitBinder
//	protected void initPersonalBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(Blob.class,"ossanImage" ,new LongEditor());
//	}

}
