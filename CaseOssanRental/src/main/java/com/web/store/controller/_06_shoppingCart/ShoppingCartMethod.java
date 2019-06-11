package com.web.store.controller._06_shoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.store.model.OrderItemBean;
import com.web.store.model.ShoppingCart;
import com.web.store.service.OssanService;

@Controller
public class ShoppingCartMethod {
	
	@Autowired
	OssanService service;
	@RequestMapping(value="ossanPage/addShoppingCart",method=RequestMethod.GET)
	public String putAddShoppingCart() {
		return"_05_ossanPage/ossanPage";
	}
	@RequestMapping(value="ossanPage/addShoppingCart",method=RequestMethod.POST)
	public String addShoppingCart(
			HttpServletRequest request,
			HttpSession session,
			@RequestParam(value="ossanNo") Integer ossanNo,
			@RequestParam(value="hours") String hours
	) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if(cart ==null) {
			cart = new ShoppingCart();
			session.setAttribute("ShoppingCart", cart);
		}		
		String sOssanNo = String.valueOf(ossanNo);
		int quantity = Integer.parseInt(hours);
		OrderItemBean oib = new OrderItemBean();
		oib.setOssanBean(service.getOssanBeanByID(ossanNo));
		oib.setQuantity(quantity);
		oib.setUnitPrice(150);
		cart.addCart(ossanNo, oib);
		
		return"redirect:/ossanPage/"+sOssanNo;
	}
	
}
