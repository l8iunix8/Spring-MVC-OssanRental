package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.OrderItemDao;
import com.web.store.model.OrderBean;
import com.web.store.model.OrderItemBean;
import com.web.store.service.OrderItemService;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemDao dao;
	
	@Override
	public List<OrderItemBean> getOrderItemList(Integer ossanNo) {
		return dao.getOrderItemList(ossanNo);
	}
	@Override
	public OrderItemBean getOrderItem(Integer orderNo, Integer ossanNo) {
		return dao.getOrderItem(orderNo, ossanNo);
	}

}
