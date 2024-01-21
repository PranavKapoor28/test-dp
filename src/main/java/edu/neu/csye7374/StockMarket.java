package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

	private static StockMarket instance;

	private List<StockAPI> stocks = new ArrayList<>();

	private StockMarket() {
		instance = null;
	}

	public static StockMarket getInstance() {

		if (instance == null) {
			instance = new StockMarket();
		}

		return instance;
	}

	public StockAPI getStockItem(String ID, double price, String description) {
		return new StockAPI(ID, price, description);
	}

	public void add(StockAPI stock) {
		stocks.add(stock);
	}

	public void remove(StockAPI s) {

		boolean removed = this.stocks.remove(s);

		if (!removed) {
			System.out.println("stock not found");
		}
	}

	public void displayStocks() {
		for (StockAPI s : this.stocks) {
			System.out.println(s.toString());
		}
	}

	public void updatePrice(StockAPI s, double price) {

		if (this.stocks.contains(s)) {
			s.setPrice(price);
			return;
		}

		System.out.println("stock not found");
	}

	public static void demo() {
		
		System.out.println("");
		
		MicrosoftStock microsoftStock = new MicrosoftStock(100);
		WalmartStock walmartStock = new WalmartStock(60);
		
		StockMarket.getInstance().add(walmartStock);
		StockMarket.getInstance().add(microsoftStock);
		
		walmartStock.setBid(10);
		
		walmartStock.setBid(40);
		
		walmartStock.setBid(50);

		walmartStock.setBid(60);
		
		walmartStock.setBid(70);
		
		walmartStock.setBid(80);
		
		walmartStock.getMetric();
		
		microsoftStock.setBid(10);
		
		microsoftStock.setBid(40);
		
		microsoftStock.setBid(50);

		microsoftStock.setBid(60);
		
		microsoftStock.setBid(70);
		
		microsoftStock.setBid(80);
		
		microsoftStock.getMetric();
		
		StockMarket.getInstance().displayStocks();
	}
}