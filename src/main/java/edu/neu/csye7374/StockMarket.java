package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private final List<StockAPI> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(StockAPI stock) {
        if (stock != null) {
            stocks.add(stock);
        }
    }

    public void showAllStocks() {
        if (stocks.isEmpty()) {
            System.out.println("No stocks available in the market.");
        } else {
            stocks.forEach(System.out::println);
        }
    }

    public void tradeStock(String name, String bid) {
        stocks.stream()
                .filter(stock -> stock.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(stock -> stock.setBid(bid));
    }

    public void removeStock(String name) {
        boolean removed = stocks.removeIf(stock -> stock.getName().equalsIgnoreCase(name));
        if (!removed) {
            System.out.printf("Stock with name '%s' not found.\n", name);
        }
    }

    public void startTrading() {
        System.out.println("Trading starts here\n");

        addStock(new NvidiaStock("NvidiaStock", 50, "This is the stock for Nvidia 3T"));
        addStock(new AmazonStock("AmazonStock", 150, "This is the stock for Amazon/AWS"));

        System.out.println("All the stocks available in the stock market at the start:");
        showAllStocks();

        String[][] trades = {
                {"NvidiaStock", "35"}, {"AmazonStock", "145"},
                {"NvidiaStock", "39"}, {"AmazonStock", "129"},
                {"NvidiaStock", "29"}, {"AmazonStock", "159"},
                {"NvidiaStock", "42"}, {"AmazonStock", "167"},
                {"NvidiaStock", "39"}, {"AmazonStock", "170"},
                {"NvidiaStock", "36"}, {"AmazonStock", "150"}
        };

        int bidCount = 1;
        for (String[] trade : trades) {
            tradeStock(trade[0], trade[1]);
            System.out.printf("\nCurrent status of the Stocks in the stock market after bid %d:\n", bidCount++);
            showAllStocks();
        }

        removeStock("NvidiaStock");
        System.out.println("\nStocks available in the stock market after removing a stock:");
        showAllStocks();
    }
}
