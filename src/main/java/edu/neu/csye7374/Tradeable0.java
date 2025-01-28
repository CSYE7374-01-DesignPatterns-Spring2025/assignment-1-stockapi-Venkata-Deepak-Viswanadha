package edu.neu.csye7374;

public interface Tradeable0 extends Tradable {
    default void setBid(String bid) {
        System.out.println("Tradeable0 setBid: " + bid);
    }
    default int getMetric() {
        return 0;
    }
}