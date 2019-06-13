package com.web.store.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.ArticleDao;
import com.web.store.model.ArticleBean;
import com.web.store.model.OssanBean;

import _00_init.util.SystemUtils2018;

@Repository
public class ArticleDaoImpl implements ArticleDao{

		@Autowired
		SessionFactory factory;
		
		int pageNo = 1; 
		int totalPages = -1;
		double recordsPerPage = 5;//設定每頁有幾筆資料
	
	@Override
	public void insertArticle(ArticleBean article, Integer ossanNo) {
		Session session = factory.getCurrentSession();
		OssanBean ossanbean = session.get(OssanBean.class, ossanNo);
		article.setOssanBean(ossanbean);
		session.save(article);
		
	}

	@Override
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	@Override
	public int getTotalPages(int ossanNo) {
		totalPages = (int) (Math.ceil(getRecordCounts(ossanNo) / (double) recordsPerPage));
		if(totalPages < 1) { //預防大叔還沒寫文章
			return 1 ;
		}else {
			return totalPages;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public long getRecordCounts(int ossanNo) {
		long count = 0; // 必須使用 long 型態
		Session session = factory.getCurrentSession();
		String hql = "SELECT count(*) FROM ArticleBean a where a.ossanBean.ossanNo = :ossanNo";		
		List<Long> list = session.createQuery(hql).setParameter("ossanNo", ossanNo).list();
		if (list.size() > 0) {
			count = list.get(0);
		}
		return count;
			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleBean> getPageArticles(int ossanNo) {
		List<ArticleBean> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM ArticleBean a WHERE a.ossanBean.ossanNo = :ossanId ORDER BY a.updateTime DESC";
		int startRecordNo = (int) ((pageNo - 1) * recordsPerPage);
		list = session.createQuery(hql).setParameter("ossanId", ossanNo).
				setFirstResult(startRecordNo).
				setMaxResults((int) recordsPerPage).
				list();
		
			for(ArticleBean art : list) {
				art.setsContent(SystemUtils2018.clobToString(art.getContent()));
			}		
		
		return list;
	}

	@Override
	public ArticleBean getArticle(Integer articleNo) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ArticleBean where articleNo = :articleNo";
		ArticleBean bean = (ArticleBean) session.createQuery(hql).setParameter("articleNo", articleNo).getSingleResult();
		return bean;
	}

	@Override
	public void updateArticle(ArticleBean articleBean) {
		Session session = factory.getCurrentSession();
		session.update(articleBean);
		
	}

	@Override
	public void deleteArticle(Integer articleNo) {
		Session session = factory.getCurrentSession();
		ArticleBean bean = new ArticleBean();
		bean.setArticleNo(articleNo);
		session.delete(bean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleBean> getOssanAllArticles(Integer ossanNo) {
		Session session = factory.getCurrentSession();
		List<ArticleBean> bean = new ArrayList<>();
		String hql = "FROM ArticleBean a where a.ossanBean.ossanNo = :ossanNo";
		bean = session.createQuery(hql).setParameter("ossanNo", ossanNo).list();
		if(bean.isEmpty()) {
			return null;
		}
		return bean;
	}

}
