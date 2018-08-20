package com.supermarket.pricing.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Product Pricing Manager
 * 
 * @author halleb
 *
 */
public class ProductPricingManager {

	// product list
	List<ProductDetail> productDetails;

	public ProductPricingManager() {
		productDetails = new ArrayList<ProductDetail>();
	}

	/**
	 * $ scan prodcut
	 * 
	 * @param productDetail
	 */
	public void add(ProductDetail productDetail) {
		productDetails.add(productDetail);
	}

	/**
	 *  get total price for product
	 * @return
	 */
	public Double getTotalPrice() {
		return productDetails.stream().map(productDetail -> productDetail.getCost()).reduce(0D, (x, y) -> x + y);
	}
}
