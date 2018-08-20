package com.supermarket.pricing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.supermarket.pricing.method.UnitPriceCalculMethod;
import com.supermarket.pricing.model.Product;

@RunWith(JUnit4.class)
public class UnitPriceCalculMethodTest {

	@Test
	public void unitPricingMethodReturnsTheUnitpriceForTheProduct() {
		Double unitPrice = 50D;
		UnitPriceCalculMethod unitPriceCalculMethod = new UnitPriceCalculMethod(unitPrice);

		Product product = new Product("product1");
		product.setPriceCalculMethod(unitPriceCalculMethod);

		Assert.assertEquals(unitPrice, product.getPrice());
	}
	
	
	@Test
	public void unitPricingMethodReturnsTheSamePriceForProductThatHaveSameUnitPrice() {
		Double unitPrice = 1D;
		UnitPriceCalculMethod unitPriceCalculMethod = new UnitPriceCalculMethod(unitPrice);

		Product productA = new Product("productA");
		productA.setPriceCalculMethod(unitPriceCalculMethod);

		Product productB = new Product("productB");
		productB.setPriceCalculMethod(unitPriceCalculMethod);
		
		Assert.assertEquals(productA.getPrice(), productB.getPrice());
	}
	 
}
