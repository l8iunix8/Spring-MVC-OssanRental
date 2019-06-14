package com.web.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.ArticleRecommendDao;
import com.web.store.service.ArticleRecommendService;
@Service
@Transactional
public class ArticleRecommendServiceImpl implements ArticleRecommendService {

	@Autowired
	ArticleRecommendDao dao;
	
	@Override
	public void setRecommend(Integer ossanNo, Integer articleNo) {
		dao.setRecommend(ossanNo, articleNo);
		
	}

	@Override
	public Integer getRecommend(Integer ossanNo) {
		return dao.getRecommend(ossanNo);
	}

}
