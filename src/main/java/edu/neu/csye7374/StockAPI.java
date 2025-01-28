package edu.neu.csye7374;

public class StockAPI implements Tradable {

    private String name;

    private String description;
    protected double price;

    private int metric;


    public StockAPI(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.metric = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(this.price > price) {
            setMetric(this.metric - 10);
        }else {
            setMetric(this.metric + 10);
        }
        this.price = price;
    }

    @Override
    public void setBid(String bid) {
        setPrice(Double.parseDouble(bid));
    }

    @Override
    public int getMetric() {
        return this.metric;
    }

    public void setMetric(int metric) {
        this.metric = metric;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", metric=" + metric +
                '}';
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
