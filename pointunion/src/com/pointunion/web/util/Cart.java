package com.pointunion.web.util;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class Cart implements java.io.Serializable {
	private String cartID;

	private long creatTime;

	private long lastModifyTime;

	private Hashtable itemMap;

	public static Cart getSessionCart(javax.servlet.http.HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart",cart);
		}
		return cart;
	}

	public Cart() {
		this.itemMap = new Hashtable();
		this.cartID = "" + System.currentTimeMillis();
		this.creatTime = System.currentTimeMillis();
		this.lastModifyTime = System.currentTimeMillis();
	}

	public String getCartID() {
		return cartID;
	}

	public long getCreatTime() {
		return creatTime;
	}

	public long getLastModifyTime() {
		return lastModifyTime;
	}

	public Hashtable getItemMap() {
		return itemMap;
	}

	public String toString() {
		return "" + cartID + "," + creatTime + "," + lastModifyTime + "," + itemMap;
	}

	public synchronized void addItem(Item item){
		if (itemMap.containsKey(item.getProduct().getProductNo())) {
			Item i = ((Item) itemMap.get(item.getProduct().getProductNo()));
			i.setQuantity(i.getQuantity() + item.getQuantity());
		} else {
			item.setQuantity(1);
			itemMap.put(item.getProduct().getProductNo(), item);
		}
		lastModifyTime = System.currentTimeMillis();
	}

	public Collection getItems() {
		return itemMap.values();
	}

	public synchronized void deleteItem(String productNo) {
		itemMap.remove(productNo);
		lastModifyTime = System.currentTimeMillis();
	}

	public synchronized void updateItemQuantity(Item item){
		if (item.getQuantity() < 1) {
			itemMap.remove(item.getProduct().getProductNo());
			return;
		}

		if (!itemMap.containsKey(item.getProduct().getProductNo())) {
			addItem(item);
		}

		((Item) itemMap.get(item.getProduct().getProductNo())).setQuantity(item.getQuantity());
		lastModifyTime = System.currentTimeMillis();
	}

	public synchronized void empty() {
		itemMap.clear();
		lastModifyTime = System.currentTimeMillis();
	}

	public int getTotal() {
		int total = 0;
		for (Iterator i = itemMap.values().iterator(); i.hasNext();) {
			total += ((Item) i.next()).getSubTotal();
		}
		return total;
	}

	public int getCount() {
		int count = 0;
		for (Iterator i = itemMap.values().iterator(); i.hasNext();) {
			count += ((Item) i.next()).getQuantity();
		}
		return count;
	}
	
	public int getItemSize() {		
		return itemMap.size();
	}
}
