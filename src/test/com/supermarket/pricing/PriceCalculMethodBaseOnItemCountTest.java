package com.supermarket.pricing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.supermarket.pricing.method.PriceCalculMethod;
import com.supermarket.pricing.method.PriceCalculMethodBaseOnItemCount;
import com.supermarket.pricing.model.Product;

@RunWith(JUnit4.class)
public class PriceCalculMethodBaseOnItemCountTest {

	@Test
	public void pricingMethodBasedOnItemsCountShouldReturnUnitPriceBasedOnTheParametersPassed() {
		int itemCount = 3;
		Double totalPrice = 1.00D;
		PriceCalculMethod countBasedPricingStrategy = new PriceCalculMethodBaseOnItemCount(itemCount, totalPrice);

		Product product = new Product("item sells 3 for 1 euro");
		product.setPriceCalculMethod(countBasedPricingStrategy);
		Double itemPrice = product.getPrice();

		Double expectedPrice = totalPrice / itemCount;
		Assert.assertEquals(expectedPrice, itemPrice);
	}

	@Test
	public void unitPriceBasedOnItemCountShoudBeTheSameForProductWithSamePrice() {
		int itemCount = 3;
		Double totalPrice = 1.00D;
		PriceCalculMethod countBasedPricingStrategy = new PriceCalculMethodBaseOnItemCount(itemCount, totalPrice);

		Product productA = new Product("productA sells 3 for 1 euro");
		productA.setPriceCalculMethod(countBasedPricingStrategy);

		Product productB = new Product("productB sells 3 for 1 euro");
		productB.setPriceCalculMethod(countBasedPricingStrategy);
		Assert.assertEquals(productA.getPrice(), productB.getPrice());
	}
	
}
