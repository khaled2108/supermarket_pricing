package com.supermarket.pricing.method;
/**
 * Price Calcul Method Base On Packed Weight
 * @author halleb
 *
 */
public class PriceCalculMethodBaseOnPackedWeight extends PriceCalculMethod {

	//product base Weight
	private Double baseWeight;
	//product packet Weight
	private Double packetWeight;
	//total price
	private Double totalPrice;

	public PriceCalculMethodBaseOnPackedWeight(Double totalPrice, Double baseWeight, Double packetWeight) {
		this.totalPrice = totalPrice;
		this.baseWeight = baseWeight;
		this.packetWeight = packetWeight;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double getUnitPrice() {
		return (totalPrice / baseWeight) * packetWeight;
	}
	
	public Double getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(Double baseWeight) {
		this.baseWeight = baseWeight;
	}

	public Double getPacketWeight() {
		return packetWeight;
	}

	public void setPacketWeight(Double packetWeight) {
		this.packetWeight = packetWeight;
	}

	

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
