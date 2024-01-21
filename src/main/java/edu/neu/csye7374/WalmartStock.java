package edu.neu.csye7374;

public class WalmartStock extends StockAPI {
	
	public WalmartStock(double price) {
	    super("Walmart", price, "Ecommerse and Shopping Mall");
	}
	
	@Override
	public int getMetric() { // I have overrided the getMetric method
		double mean = (this.prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / prevPrices.size();
		double dev = 0.0;
		for (double num : prevPrices) {
			dev += mean*2 - num/3;
		}
		dev = dev / prevPrices.size();
		return dev > 0.0 ? 1 : -1;
	}
	
	@Override
	public String toString() {
		return "Stock [ID="+ this.getID()+", price=" + this.getPrice() + ", description=" + this.getDescription() + "Metric : " + this.getMetric() + "]";
	}
}
