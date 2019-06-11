package com.web.store.service;

import java.util.List;

import com.web.store.model.OrderItemBean;

public interface OrderItemService {
	List<OrderItemBean> getOrderItemList(Integer ossanNo);
	OrderItemBean getOrderItem(Integer orderNo , Integer ossanNo);
}
