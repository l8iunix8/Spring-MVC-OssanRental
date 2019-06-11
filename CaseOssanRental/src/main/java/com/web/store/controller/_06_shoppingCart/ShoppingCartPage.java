package com.web.store.controller._06_shoppingCart;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.store.model.OrderBean;
import com.web.store.model.OrderItemBean;
import com.web.store.model.ShoppingCart;
import com.web.store.service.OrderService;
import com.web.store.service.OssanService;

@Controller
public class ShoppingCartPage {

	@Autowired
	OrderService orderService;
	@Autowired
	OssanService ossanService;
	
	
	@RequestMapping(value="shoppingCart" , method=RequestMethod.GET)
	public String putShoppingCart(Model model , HttpSession session) {
		OrderBean orderBean = new OrderBean();
		model.addAttribute("orderBean",orderBean);
		return"_06_shoppingCart/shoppingCart";
	}
	
	@RequestMapping(value="shoppingCart" , method=RequestMethod.POST)
	public String getShoppingCart(
			@ModelAttribute("orderBean") OrderBean orderBean,
			BindingResult result,
			HttpServletRequest request,
			HttpSession session
	) {
		
		String hours;

		Timestamp orderDate = new java.sql.Timestamp(System.currentTimeMillis());
		orderBean.setOrderDate(orderDate);
		int totalAmount = 0;
		Set<OrderItemBean> ossanInCart = new HashSet<OrderItemBean>();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if(shoppingCart==null) {
			return "redirect:/";
		}
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("ErrMsg", errorMsgs);
		String address = orderBean.getAddress();
		String email = orderBean.getEmail();
		String invoiceTitle = orderBean.getInvoiceTitle();
		String phone = orderBean.getPhone();
		if(address.trim().length()==0||address ==null) {
			errorMsgs.put("errAddr", "地址欄必須填寫");
		}if(email.trim().length()==0||email ==null) {
			errorMsgs.put("errEmail", "信箱欄必須填寫");
		}if(invoiceTitle.trim().length()==0||invoiceTitle ==null) {
			errorMsgs.put("errName", "姓名欄必須填寫");
		}if(phone.trim().length()==0||phone ==null) {
			errorMsgs.put("errPhone", "手機欄必須填寫");
		}if(!errorMsgs.isEmpty()) {
			return"_06_shoppingCart/shoppingCart";
		}
		Map<Integer, OrderItemBean> cart = shoppingCart.getContent();
		Set<Integer> cartKeySet = cart.keySet();
		for(Integer ossanNo : cartKeySet) {
			OrderItemBean oi = cart.get(ossanNo);	
			hours = request.getParameter(ossanNo + "count");
			int hour = Integer.parseInt(hours);
			totalAmount += hour*oi.getUnitPrice();
			oi.setOssanBean(ossanService.getOssanBeanByID(ossanNo));
			oi.setQuantity(hour);
			oi.setOrderBean(orderBean);
			ossanInCart.add(oi);
		}
		orderBean.setTotalAmount(totalAmount);
		orderBean.setOrderItemBean(ossanInCart);
		orderService.save(orderBean);
		session.removeAttribute("ShoppingCart");
		
		 
		return "redirect:/";
	}
	
	@RequestMapping(value="deleteOneOssan/{ossanNo}" , method=RequestMethod.POST)
	public String deleteOneOssan(HttpServletRequest request,HttpSession session,@PathVariable Integer ossanNo) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		cart.deleteOssan(ossanNo);
		return "redirect:/shoppingCart";
	}
}
