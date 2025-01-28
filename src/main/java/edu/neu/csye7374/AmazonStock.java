package edu.neu.csye7374;

public class AmazonStock extends StockAPI {
    public AmazonStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setPrice(double price) {
        if (price > this.getPrice()) {
            int value = (int) ((price - this.getPrice()) * 1.1 / this.getPrice());
            setMetric(this.getMetric() + value);
        } else {
            int value = (int) ((price - this.getPrice()) * 0.8 / this.getPrice());
            setMetric(this.getMetric() + value);
        }
        this.price = price;
    }

}
