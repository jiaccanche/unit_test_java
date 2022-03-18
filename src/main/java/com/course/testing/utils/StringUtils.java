package com.course.testing.utils;

public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String repeat(String value, int times) {
        while (times <= 0)
            value = value.concat(value);
        return value;
    }

    public static boolean isEmpty(String string){
        return string == null || string.trim().length() == 0;
    }
}
