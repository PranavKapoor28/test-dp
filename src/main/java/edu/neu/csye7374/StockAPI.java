package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockAPI implements Tradable {

	private String ID;

	private double price;

	private String description;
	
	private int metric;

	protected List<Double> prevPrices = new ArrayList<>();

	public StockAPI() {
		super();
	}

	public StockAPI(String ID, double price, String description) {
		super();
		this.ID=ID;
		this.price = price;
		this.description = description;
		init(price);
	}

	private void init(double price) {
		prevPrices.add(price);
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Stock [ID=" + ID + ", price=" + price + ", description=" + description + "Metric : " + metric + "]";
	}

	@Override
	public int getMetric() {
		double mean = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / prevPrices.size();
		double dev = 0.0;
		for (double num : prevPrices) {
			dev += mean - num;
		}
		dev = dev / prevPrices.size();
		this.metric = dev > 0.0 ? 1 : -1;
		return this.metric;
	}
	
	@Override
	public void setBid(double bid) {
	    prevPrices.add(bid);
	    double newPrice = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum())/prevPrices.size();
	    StockMarket.getInstance().updatePrice(this, newPrice);
	}
}