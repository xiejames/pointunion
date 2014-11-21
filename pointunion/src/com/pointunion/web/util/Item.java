package com.pointunion.web.util;

import java.io.Serializable;
import java.sql.SQLException;

import com.pointunion.domain.dto.Product;

public class Item implements Serializable {
	private int quantity = 1;
	private int realPoint;
	private Product product;

	public Item(Product product) throws SQLException {
		this.product = product;
		this.realPoint = product.getPoint().intValue();
	}

	public Item(Product product, int realPoint) throws SQLException {
		this.product = product;
		this.realPoint = realPoint;
	}

	public void add() {
		setQuantity(getQuantity() + 1);
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			this.quantity = 0;
		} else {
			this.quantity = quantity;
		}
	}

	public Product getProduct() {
		return product;
	}

	public int getRealPoint() {
		return realPoint;
	}

	public void setRealPoint(int realPoint) {
		this.realPoint = realPoint;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSubTotal() {
		return getRealPoint() * getQuantity();
	}
}