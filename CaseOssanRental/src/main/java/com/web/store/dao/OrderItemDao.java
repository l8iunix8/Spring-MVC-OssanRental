package com.web.store.dao;

import java.util.List;

import com.web.store.model.OrderItemBean;

public interface OrderItemDao {
	List<OrderItemBean> getOrderItemList(Integer ossanNo);
	OrderItemBean getOrderItem(Integer orderNo , Integer ossanNo);
}
