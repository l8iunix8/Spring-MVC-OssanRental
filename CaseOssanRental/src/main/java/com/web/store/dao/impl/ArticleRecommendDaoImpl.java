package com.web.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.ArticleRecommendDao;
import com.web.store.model.OssanBean;
import com.web.store.model.OssanRecommendBean;

@Repository
public class ArticleRecommendDaoImpl implements ArticleRecommendDao {
	@Autowired
	SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public void setRecommend(Integer ossanNo, Integer articleNo) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OssanRecommendBean a where a.ossanBean.ossanNo = :ossanNo";
		List<OssanRecommendBean> list = session.createQuery(hql).setParameter("ossanNo", ossanNo).list();
		if(list.isEmpty()) {
			OssanRecommendBean arBean = new OssanRecommendBean();
			OssanBean ossanBean = new OssanBean();
			ossanBean.setOssanNo(ossanNo);
			arBean.setOssanBean(ossanBean);
			arBean.setRecommend(articleNo);
			session.save(arBean);
			
		}else {
			for (OssanRecommendBean bean : list) {
				bean.setRecommend(articleNo);
				session.save(bean);
				
			}
		}
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getRecommend(Integer ossanNo) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT recommend FROM OssanRecommendBean a where a.ossanBean.ossanNo = :ossanNo";
		List<Integer> list = session.createQuery(hql).setParameter("ossanNo", ossanNo).list();
		if (!list.isEmpty()) {
			for (Integer recommend : list) {
				return recommend;
			}
		}
		return null;

	}

}
