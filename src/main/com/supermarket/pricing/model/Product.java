package com.supermarket.pricing.model;

import java.security.SecureRandom;

import com.supermarket.pricing.method.PriceCalculMethod;

/**
 * Product
 * @author halleb
 *
 */
public class Product {

	private static volatile SecureRandom numberGenerator = null;
	private static final long MSB = 0x8000000000000000L;

	// product name
	private String name;
	// product serial number
	private String productSerialNumber;
	// price method calcul
	private PriceCalculMethod priceCalculMethod;

	public Product(String name) {
		this.productSerialNumber = generateUniqueProductNumber();
		this.name = name;

	}

	public Product(String name, PriceCalculMethod priceCalculMethod) {
		this.productSerialNumber = generateUniqueProductNumber();
		this.name = name;
		this.priceCalculMethod = priceCalculMethod;

	}

	public Double getPrice() {
		return priceCalculMethod.getUnitPrice();
	}

	public PriceCalculMethod getPriceCalculMethod() {
		return priceCalculMethod;
	}

	public void setPriceCalculMethod(PriceCalculMethod priceCalculMethod) {
		this.priceCalculMethod = priceCalculMethod;
	}

	public String getName() {
		return this.name;
	}

	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * generate unique product number
	 * @return
	 */
	public static String generateUniqueProductNumber() {
		if (numberGenerator == null) {
			numberGenerator = new SecureRandom();
		}

		return Long.toHexString(MSB | numberGenerator.nextLong()) + Long.toHexString(MSB | numberGenerator.nextLong());
	}
}
