package com.web.store.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.OssanDao;
import com.web.store.model.OssanBean;

import _00_init.util.SystemUtils2018;


@Repository
public class OssanDaoImpl implements OssanDao {
	@Autowired
	SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExist(String email) {//判斷帳號是否已註冊
		Session session = factory.getCurrentSession();
		String hql = "From OssanBean where email = :email";
		List<OssanBean> list = new ArrayList<>();
		boolean exist = true;
		list = session.createQuery(hql).setParameter("email", email).list();
		if(list.isEmpty()) {
			exist = false;
		}
		return exist;
	}

	@Override
	public void save(OssanBean ossanBean) {
		Session session = factory.getCurrentSession();
		session.save(ossanBean);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean ossanExist(String email, String password) {
		Session session = factory.getCurrentSession();
		String hql = "From OssanBean where email = :email AND password = :password";
		List<OssanBean> list = new ArrayList<>();
		boolean exist = true;
		list = session.createQuery(hql).setParameter("email", email).setParameter("password", password).list();		
		if(list.isEmpty()) {
			exist = false;
		}
		return exist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public OssanBean getOssanBean(String email) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OssanBean where email = :email";
		List<OssanBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("email", email).list();
		for(OssanBean bean:list) {
			return bean;			
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public OssanBean getOssanBeanByID(Integer ossanNo) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OssanBean where ossanNo = :ossanNo";
		List<OssanBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("ossanNo", ossanNo).list();
		for(OssanBean bean:list) {
			
			return bean;			
		}
		return null;
	}

	@Override
	public void update(OssanBean ossanBean) {
		Session session = factory.getCurrentSession();
		session.update(ossanBean);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OssanBean> getAllOssanBean() {
		Session session = factory.getCurrentSession();
		List<OssanBean> list = new ArrayList<>();
		String hql =  "FROM OssanBean";
		list = session.createQuery(hql).list();
		for(OssanBean ossanBean:list) {
			ossanBean.setsIntro(SystemUtils2018.clobToString(ossanBean.getIntro()));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCount() {
		long count = 0;
		Session session = factory.getCurrentSession();
		String hql = "SELECT count(*) from OssanBean ";
		List<Long> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			count = list.get(0);
		}
		return (int) count;
	}

	
}
