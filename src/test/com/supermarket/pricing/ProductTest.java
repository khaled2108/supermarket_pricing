package com.supermarket.pricing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.supermarket.pricing.model.Product;

@RunWith(JUnit4.class)
public class ProductTest {

	@Test
	public void productShouldHaveANameAssociatedToIt() {
		Product product = new Product("item_1");
		assertEquals("item_1", product.getName());
	}

	@Test
	public void productShouldHaveANotNullProductSerialNumber() {
		Product product = new Product("item_1");
		assertNotNull(product.getProductSerialNumber());
	}

	@Test
	public void productShouldHaveAUniqueProductSerialNumber() {
		Product productA = new Product("item_1");
		Product productB = new Product("item_2");
		assertNotEquals(productA.getProductSerialNumber(), productB.getProductSerialNumber());
	}
}
