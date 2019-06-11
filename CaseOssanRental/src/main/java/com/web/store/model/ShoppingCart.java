package com.web.store.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {
	
	private Map<Integer, OrderItemBean> cart = new LinkedHashMap< >();
	
	public ShoppingCart() {
	}
	
	public void addCart(Integer ossanNo , OrderItemBean oib) {
		if (oib.getQuantity() <= 0 ) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( cart.get(ossanNo) == null ) {
		    cart.put(ossanNo, oib);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			OrderItemBean oi = cart.get(ossanNo);
			// 加購的數量：oib.getQuantity()
			// 原有的數量：oi.getQuantity()			
			oi.setQuantity(oi.getQuantity() + oib.getQuantity());
		}
	}
	
	public Map<Integer, OrderItemBean>  getContent() { // ${ShoppingCart.content}
		return cart;
	}
	
	public void deleteOssan(Integer ossanNo) {
		if(cart.get(ossanNo)!=null) {
			cart.remove(ossanNo);
		}else {
			System.out.println("購物車沒有此商品");
		}
	}
}
