package com.web.store.controller._03_personalInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.store.model.OrderItemBean;
import com.web.store.model.OssanBean;
import com.web.store.service.OrderItemService;

@Controller
public class PersonalOrder {
	@Autowired
	OrderItemService service;
	
	@RequestMapping("orderDetail/{orderNo}")
	public String getOrderDetail(@PathVariable Integer orderNo,HttpSession session,HttpServletRequest request) {
		OssanBean ossanBean = (OssanBean) session.getAttribute("OssanLoginOK");
		Integer ossanNo = ossanBean.getOssanNo();
		OrderItemBean orderItemBean = service.getOrderItem(orderNo, ossanNo);
		request.setAttribute("orderItemBean", orderItemBean);		
		return "_03_personalInfo/orderDetail";
	}
}
