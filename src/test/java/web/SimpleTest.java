package web;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    @Test(expected = ArithmeticException.class)
    public void test(){
        int i =0;
        int il = 1/i;
        

    }
}
