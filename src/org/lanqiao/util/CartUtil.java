package org.lanqiao.util;

import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Cart;
import org.lanqiao.entity.CookieItem;
import org.lanqiao.entity.Good;
import org.lanqiao.service.GoodService;
import org.lanqiao.service.impl.GoodServiceImpl;

public class CartUtil {
	public static List<Cart> convertCookieItemListToCartList(List<CookieItem> itemList){
		if(itemList==null)return null;
		List<Cart> cart = new ArrayList<Cart>();
		Cart c = null;
		GoodService gs = new GoodServiceImpl();
		for (int i = 0; i < itemList.size(); i++) {
			CookieItem item = itemList.get(i);
			Good good = gs.getGoodById(itemList.get(i).getGid());
			c = new Cart(item.getGid(), good.getGtitle(), good.getGsaleprice(), good.getGinprice(), item.getAmount());
			cart.add(c);
		}
		return cart;
	}
}
