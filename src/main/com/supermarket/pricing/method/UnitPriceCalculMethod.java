package com.supermarket.pricing.method;

/**
 * Unit Price Calcul Method
 * 
 * @author halleb
 *
 */
public class UnitPriceCalculMethod extends PriceCalculMethod {

	// product unit price
	private Double unitPrice;

	public UnitPriceCalculMethod(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double getUnitPrice() {
		return unitPrice;
	}
}
