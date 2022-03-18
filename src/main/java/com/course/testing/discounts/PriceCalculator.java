package com.course.testing.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();
    private double discout = 0;

    public double getTotal() {
        double result = 0.0;
        for (Double price : prices) {
            result += price;
        }
        return result * ((100 - discout) / 100);
    }

    public void addPrice(double v) {
        prices.add(v);
    }

    public void setDiscout(double discout) {
        this.discout = discout;
    }
}
