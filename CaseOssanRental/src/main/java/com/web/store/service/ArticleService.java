package com.web.store.service;

import java.util.List;

import com.web.store.model.ArticleBean;

public interface ArticleService {
	void insertArticle(ArticleBean article , Integer ossanNo);
	void setPageNo(int pageNo);
	int getTotalPages(int ossanNo);
	List<ArticleBean> getPageArticles(int ossanNo);
	ArticleBean getArticle(Integer articleNo);
	void updateArticle(ArticleBean articleBean);
	void deleteArticle(Integer articleNo);
}
