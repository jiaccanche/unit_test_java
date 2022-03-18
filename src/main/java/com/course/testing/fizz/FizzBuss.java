package com.course.testing.fizz;

public class FizzBuss {
    public static String fizzBuss(int value) {
        boolean flagFizz = value % 3 == 0;
        boolean flagBuzz = value % 5 == 0;

        if( flagBuzz && flagFizz ) return "FizzBuzz";
        if (flagFizz) return "Fizz";
        if(flagBuzz) return "Buzz";
        return null;
    }
}
