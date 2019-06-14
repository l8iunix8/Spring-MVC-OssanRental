package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.ArticleDao;
import com.web.store.model.ArticleBean;
import com.web.store.service.ArticleService;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleDao dao;
		
	@Override
	public void insertArticle(ArticleBean article, Integer ossanNo) {
		dao.insertArticle(article,ossanNo);
		
	}

	@Override
	public void setPageNo(int pageNo) {
		dao.setPageNo(pageNo);
		
	}

	@Override
	public int getTotalPages(int ossanNo) {
		return dao.getTotalPages(ossanNo);
	}

	@Override
	public List<ArticleBean> getPageArticles(int ossanNo) {
		return dao.getPageArticles(ossanNo);
	}

	@Override
	public ArticleBean getArticle(Integer articleNo) {
		return dao.getArticle(articleNo);
	}

	@Override
	public void updateArticle(ArticleBean articleBean) {
		dao.updateArticle(articleBean);
		
	}

	@Override
	public void deleteArticle(Integer articleNo) {
		dao.deleteArticle(articleNo);
		
	}

	@Override
	public List<ArticleBean> getOssanAllArticles(Integer ossanNo) {
		return dao.getOssanAllArticles(ossanNo);
	}


	
}
