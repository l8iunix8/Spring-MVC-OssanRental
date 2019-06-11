package com.web.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.OrderItemDao;
import com.web.store.model.OrderItemBean;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
	
	@Autowired
	SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItemBean> getOrderItemList(Integer ossanNo) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderItemBean a where a.ossanBean.ossanNo = :ossanNo";
		List<OrderItemBean> list = session.createQuery(hql).setParameter("ossanNo", ossanNo).list();
		if(list.isEmpty()) {
			return null;
		}		
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public OrderItemBean getOrderItem(Integer orderNo, Integer ossanNo) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderItemBean a where a.orderBean.orderNo = :orderNo AND a.ossanBean.ossanNo = :ossanNo";
		List<OrderItemBean> list = session.createQuery(hql).setParameter("orderNo", orderNo).setParameter("ossanNo", ossanNo).list();
		if(list.isEmpty()) {
			return null;
		}else {
			for(OrderItemBean orderItemBean:list) {
				return orderItemBean;
			}
		}
		return null;
	}

}
