package com.course.testing.fizz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBussShould {

    @Test
    public void return_fizz_when_value_is_divisible_by_3(){
        assertThat(FizzBuss.fizzBuss(3), is("Fizz"));
    }

    @Test
    public void return_buss_when_value_is_divisible_by_5(){
        assertThat(FizzBuss.fizzBuss(5), is("Buzz"));
    }

    @Test
    public void return_buss_when_value_is_divisible_by_5_and_3(){
        assertThat(FizzBuss.fizzBuss(15), is("FizzBuzz"));
    }

}