package com.supermarket.pricing.method;

/**
 * Price Calcul Method Base On Item Count
 * 
 * @author halleb
 *
 */
public class PriceCalculMethodBaseOnItemCount extends PriceCalculMethod {

	// item count for this calcul method
	private Integer itemCount;
	// total price
	private Double totalPrice;

	public PriceCalculMethodBaseOnItemCount(Integer itemCount, Double totalPrice) {
		this.itemCount = itemCount;
		this.totalPrice = totalPrice;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double getUnitPrice() {
		return totalPrice / itemCount;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
