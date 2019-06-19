package com.web.store.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.store.model.OssanBean;
import com.web.store.service.OssanService;

import _00_init.util.SystemUtils2018;

@Controller
public class SearchOssan {

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	OssanService service;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "searchOssan", method = RequestMethod.POST)
	public String searchOssanPost() {
		String keyword = request.getParameter("keyword");
		if (keyword.trim().length() == 0 || keyword == null) {
			return "/";
		}
		List<OssanBean> list = service.searchOssan(keyword);
		if(list.isEmpty()||list==null) {
			return "index";
		}
		for (OssanBean bean : list) {
			System.out.println("00000000000000000000000000000000000000000000000");
			bean.setsIntro(SystemUtils2018.clobToString(bean.getIntro()));
		}
		session.setAttribute("searchOssanList", list);
		session.setAttribute("keyword", keyword);
		return "redirect:/searchOssan";

	}

	@RequestMapping(value = "searchOssan", method = RequestMethod.GET)
	public String searchOssanGet() {

		return "_07_searchOssan/SearchOssan";

	}

	@RequestMapping(value = "/getSearchOssanPicture/{ossanNo}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getSearchPicture(HttpServletResponse resp, HttpSession session,
			@PathVariable("ossanNo") Integer ossanNo) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		OssanBean bean = service.getOssanBeanByID(ossanNo);
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
}
