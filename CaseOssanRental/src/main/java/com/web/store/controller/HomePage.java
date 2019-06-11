package com.web.store.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletContext;
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

import com.web.store.model.OssanBean;
import com.web.store.service.OssanService;

@Controller
public class HomePage {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	OssanService ossanService;
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	@RequestMapping("index")
	public String indexHomePage() {
		return "index";
	}
	@RequestMapping(value= {"getIndexOssanImage/{ossanNo}","ossanPage/getIndexOssanImage/{ossanNo}"})
	public ResponseEntity<byte[]> getIndexOssanImage(HttpServletResponse resp,HttpSession session,@PathVariable Integer ossanNo) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		System.out.println(ossanNo);
		OssanBean bean = ossanService.getOssanBeanByID(ossanNo);
		System.out.println(bean);
		if (bean != null) {
			Blob blob = bean.getOssanImage();
			filename = bean.getFileName();
			System.out.println(filename);
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
