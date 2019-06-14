package com.web.store.dao;

public interface ArticleRecommendDao {
	void setRecommend(Integer ossanNo,Integer articleNo);
	Integer getRecommend(Integer ossanNo);
}
