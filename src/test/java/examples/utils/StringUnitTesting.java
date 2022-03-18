package examples.utils;

import com.course.testing.utils.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringUnitTesting {

    @Test
    public void test_repeat(){
        System.out.println("test simple");
        Assert.assertEquals(
                "hola", StringUtils.repeat("hola",1)

        );
    }

    @Test
    public void test_simulate(){

    }
}
