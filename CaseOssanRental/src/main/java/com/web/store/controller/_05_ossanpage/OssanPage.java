package com.web.store.controller._05_ossanpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.store.model.ArticleBean;
import com.web.store.model.OssanBean;
import com.web.store.service.ArticleRecommendService;
import com.web.store.service.ArticleService;
import com.web.store.service.OssanService;

import _00_init.util.SystemUtils2018;

@Controller
public class OssanPage {
	
		@Autowired
		OssanService service;
	
		@Autowired
		ArticleService articleService;
		@Autowired
		ArticleRecommendService arService;
		
		@Autowired
		ServletContext context;
		@RequestMapping("ossanPage/{ossanNo}")
		public String intoOssanPage(HttpServletRequest request,HttpSession session,@PathVariable Integer ossanNo
		) {
			OssanBean ossanBean = service.getOssanBeanByID(ossanNo);
			ossanBean.setsIntro(SystemUtils2018.clobToString(ossanBean.getIntro()));
			List<ArticleBean> articleBean = new ArrayList<>();
			articleBean = articleService.getOssanAllArticles(ossanNo);
			if(articleBean!=null) {
				for(ArticleBean bean:articleBean) {
					bean.setsContent(SystemUtils2018.clobToString(bean.getContent()));
					
				}
			}
			Integer recommendArticleNo = arService.getRecommend(ossanNo);
			
			if(recommendArticleNo!=null) {
				ArticleBean recommendArticle = articleService.getArticle(recommendArticleNo);
				recommendArticle.setsContent(SystemUtils2018.clobToString(recommendArticle.getContent()));
				request.setAttribute("recommendArticle", recommendArticle);
			}
			
			
			request.setAttribute("articleBeans",articleBean);
			request.setAttribute("ossanBean", ossanBean);
			return "_05_ossanPage/ossanPage";
		}
		
		@RequestMapping(value="randomOssan")
		public String goRandomOssan() {
			int n = 1;
			n = (int) (Math.random()*service.getCount()+1);
			
			return "redirect:/ossanPage/"+n+"";
		}
		@RequestMapping(value="getOneArticle/{articleNo}")
		public @ResponseBody Map<String, Object> getAjaxArticle(@PathVariable Integer articleNo,HttpSession session){
			Map<String, Object> result = new HashMap<String, Object>();
			System.out.println("00000000");
			ArticleBean articleBean = articleService.getArticle(articleNo);
			Blob blob = articleBean.getArticleImage();
			byte[] imageBinary = null;
			if(articleBean.getArticleImage()!=null) {
				try {
					imageBinary = blob.getBytes(1, (int) blob.length());
					
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}else {
				String filePath = "/resources/images/NoImage.jpg";
				imageBinary = toByteArray(filePath);
				System.out.println("2222222222");
				result.put("ajaxImage", imageBinary);
			}
			
			String content = (SystemUtils2018.clobToString(articleBean.getContent()));
			String title = articleBean.getTitle();
			result.put("ajaxTitle", title);
			result.put("ajaxContent", content);
			result.put("ajaxImage", imageBinary);
			
			
			System.out.println(result);
			return result;
			
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
