package edu.neu.csye7374;

public class NvidiaStock extends StockAPI {

    public NvidiaStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setPrice(double price) {
        if (price > this.getPrice()) {
            int value = (int) ((price - this.getPrice()) * 200 / this.getPrice());
            setMetric(this.getMetric() + value);
        } else {
            int value = (int) ((price - this.getPrice()) * 5 / this.getPrice());
            setMetric(this.getMetric() + value);
        }
        this.price = price;
    }
}
