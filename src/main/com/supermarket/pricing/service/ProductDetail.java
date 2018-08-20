package com.supermarket.pricing.service;

import com.supermarket.pricing.model.Product;

/**
 * Product Detail
 * 
 * @author halleb
 *
 */
public class ProductDetail {

	// product
	private Product product;
	// quantity
	private Integer quantity;

	public ProductDetail(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * calcul product costs
	 * @return
	 */
	public Double getCost() {

		return product.getPrice() * quantity;

	}

}
