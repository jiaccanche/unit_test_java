package com.course.testing.discounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorPriceCalculatorShould {

    @Test
    public void total_zero_when_there_are_prices(){
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_then_sum_of_prices(){
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.1);
        calculator.addPrice(14.9);
        assertThat(calculator.getTotal(), is(25.0));
    }

    @Test
    public void apply_discount_to_prices(){
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(11.1);
        calculator.addPrice(18.9);
        calculator.setDiscout(25);
        assertThat(calculator.getTotal(), is(22.5));
    }

}