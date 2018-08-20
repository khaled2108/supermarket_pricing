package com.supermarket.pricing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.supermarket.pricing.method.PriceCalculMethod;
import com.supermarket.pricing.method.PriceCalculMethodBaseOnItemCount;
import com.supermarket.pricing.method.PriceCalculMethodBaseOnPackedWeight;
import com.supermarket.pricing.method.UnitPriceCalculMethod;
import com.supermarket.pricing.model.Product;
import com.supermarket.pricing.service.ProductDetail;
import com.supermarket.pricing.service.ProductPricingManager;

@RunWith(JUnit4.class)
public class ProductPricingTest {

	@Test
	public void unitProductPurchased() {
		ProductPricingManager productPricingManager = new ProductPricingManager();

		Product productA = new Product("unit price test");
		UnitPriceCalculMethod unitPriceCalculMethod = new UnitPriceCalculMethod(3.5D);
		productA.setPriceCalculMethod(unitPriceCalculMethod);

		ProductDetail itemDetail = new ProductDetail(productA, 3);

		productPricingManager.add(itemDetail);
		Double totalPrice = productPricingManager.getTotalPrice();
		Double expectedPrice = productA.getPrice() * 3;
		Assert.assertEquals(totalPrice, itemDetail.getCost());
		Assert.assertEquals(totalPrice, expectedPrice);
	}

	@Test
	public void priceBasedOnItemCountProductPurchased() {
		PriceCalculMethod priceCalculMethodBaseOnItemCount = new PriceCalculMethodBaseOnItemCount(3, 1.00D);
		Product product = new Product("product sells 3 for 1 euro");
		product.setPriceCalculMethod(priceCalculMethodBaseOnItemCount);

		ProductDetail itemDetail = new ProductDetail(product, 3);

		ProductPricingManager productPricingManager = new ProductPricingManager();
		productPricingManager.add(itemDetail);
		Double totalPrice = productPricingManager.getTotalPrice();
		Double expectedPrice = product.getPrice() * 3;
		Assert.assertEquals(totalPrice, itemDetail.getCost());
		Assert.assertEquals(totalPrice, expectedPrice);
	}

	@Test
	public void priceBaseOnPackedWeightProductPurchased() {
		PriceCalculMethod priceWeightPricingStrategy = new PriceCalculMethodBaseOnPackedWeight(10D, 2D, 5D);
		Product product = new Product("product sells 2Ltr for 10 euros ");
		product.setPriceCalculMethod(priceWeightPricingStrategy);

		ProductDetail itemDetail = new ProductDetail(product, 3);

		ProductPricingManager productPricingManager = new ProductPricingManager();
		productPricingManager.add(itemDetail);
		Double totalPrice = productPricingManager.getTotalPrice();
		Double expectedPrice = product.getPrice() * 3;
		Assert.assertEquals(totalPrice, itemDetail.getCost());
		Assert.assertEquals(totalPrice, expectedPrice);
	}

	@Test
	public void multipleProductPurchased() {

		Product unitPriceProduct = new Product("unit price test");
		UnitPriceCalculMethod unitPriceCalculMethod = new UnitPriceCalculMethod(3.5D);
		unitPriceProduct.setPriceCalculMethod(unitPriceCalculMethod);

		ProductDetail unitPriceDetail = new ProductDetail(unitPriceProduct, 3);

		PriceCalculMethod priceCalculMethodBaseOnItemCount = new PriceCalculMethodBaseOnItemCount(3, 1.00D);
		Product productBaseOnItemCount = new Product("product sells 3 for 1 euro");
		productBaseOnItemCount.setPriceCalculMethod(priceCalculMethodBaseOnItemCount);

		ProductDetail productBaseOnItemCountDetail = new ProductDetail(productBaseOnItemCount, 4);

		PriceCalculMethod priceWeightPricingStrategy = new PriceCalculMethodBaseOnPackedWeight(10D, 2D, 5D);
		Product packedWeightproduct = new Product("product sells 2Ltr for 10 euros ");
		packedWeightproduct.setPriceCalculMethod(priceWeightPricingStrategy);

		ProductDetail packedWeightproductDetail = new ProductDetail(packedWeightproduct, 1);

		ProductPricingManager productPricingManager = new ProductPricingManager();

		productPricingManager.add(unitPriceDetail);
		productPricingManager.add(productBaseOnItemCountDetail);
		productPricingManager.add(packedWeightproductDetail);
		Double totalPrice = productPricingManager.getTotalPrice();
		Double expectedPrice = unitPriceProduct.getPrice() * 3 + productBaseOnItemCount.getPrice() * 4
				+ packedWeightproduct.getPrice() * 1;
		Double productDetailCosts = unitPriceDetail.getCost() + productBaseOnItemCountDetail.getCost()
				+ packedWeightproductDetail.getCost();
		Assert.assertEquals(totalPrice, productDetailCosts);
		Assert.assertEquals(totalPrice, expectedPrice);
	}
}
