package com.web.store.dao;

import java.util.List;

import com.web.store.model.ArticleBean;

public interface ArticleDao {
	void insertArticle(ArticleBean article , Integer ossanNo);
	void setPageNo(int pageNo);
	long getRecordCounts(int ossanNo);
	int getTotalPages(int ossanNo);
	List<ArticleBean> getPageArticles(int ossanNo);
	ArticleBean getArticle(Integer articleNo);
	void updateArticle(ArticleBean articleBean);
	void deleteArticle(Integer articleNo);
}
