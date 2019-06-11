package com.web.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.OrderDao;
import com.web.store.model.OrderBean;
import com.web.store.model.OrderItemBean;


@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public void save(OrderBean orderBean) {
		Session session = factory.getCurrentSession();
		session.save(orderBean);
	}

	

}
