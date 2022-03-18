package com.course.testing.utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void test_empty_null (){
        boolean result = StringUtils.isEmpty(null);
        assertTrue(result);
    }

    @Test
    public void test_empty_empty (){
        boolean result = StringUtils.isEmpty("");
        assertTrue(result);
    }

    @Test
    public void test_empty_space (){
        boolean result = StringUtils.isEmpty(" ");
        assertTrue(result);
    }

    @Test
    public void test_empty_multiple_space (){
        boolean result = StringUtils.isEmpty("    ");
        assertTrue(result);
    }

}