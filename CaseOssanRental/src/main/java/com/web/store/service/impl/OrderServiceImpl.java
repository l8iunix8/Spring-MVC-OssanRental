package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.OrderDao;
import com.web.store.model.OrderBean;
import com.web.store.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao dao;
	
	@Override
	public void save(OrderBean orderBean) {
		dao.save(orderBean);
	}

	

}
