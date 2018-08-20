package com.supermarket.pricing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.supermarket.pricing.method.PriceCalculMethod;
import com.supermarket.pricing.method.PriceCalculMethodBaseOnPackedWeight;
import com.supermarket.pricing.model.Product;

@RunWith(JUnit4.class)
public class PriceCalculMethodBaseOnPackedWeightTest {

	@Test
	public void pricingMethodBasedOnPackedWeight() {
		Double totalPrice = 10D;
		Double baseWeight = 2D;

		Double packetWeight = 5D;
		PriceCalculMethod priceWeightPricingStrategy = new PriceCalculMethodBaseOnPackedWeight(totalPrice, baseWeight,
				packetWeight);

		Product product = new Product("item sells 2Ltr for 10 euros ");
		product.setPriceCalculMethod(priceWeightPricingStrategy);

		Double expectedPrice = (totalPrice / baseWeight) * packetWeight;
		Assert.assertEquals(expectedPrice, product.getPrice());
	}

	@Test
	public void unitPriceBasedOnItemCountShoudBeTheSameForProductWithSamePrice() {
		Double totalPrice = 10D;
		Double baseWeight = 2D;

		Double packetWeight = 5D;
		PriceCalculMethod priceWeightPricingStrategy = new PriceCalculMethodBaseOnPackedWeight(totalPrice, baseWeight,
				packetWeight);

		Product productA = new Product("productA sells 2Ltr for 10 euros ");
		productA.setPriceCalculMethod(priceWeightPricingStrategy);

		Product productB = new Product("productB sells 2Ltr for 10 euros ");
		productB.setPriceCalculMethod(priceWeightPricingStrategy);

		Assert.assertEquals(productA.getPrice(), productB.getPrice());
	}

}
