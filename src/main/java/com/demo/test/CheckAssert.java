package com.demo.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckAssert {

    String t1 = "t1";
    int i1 = 1;
    boolean b1 = true;
    int[] ia = new int[]{1, 2, 3};
    List<Integer> il = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void testT1Equal() {
        Assert.assertEquals(t1, "t1");
    }

    @Test
    public void testI1Equal() {
        Assert.assertEquals(i1, 1);
    }

    @Test
    public void testB1() {
        Assert.assertTrue(b1);
        Assert.assertNotEquals(b1, false);
    }

    @Test
    public void testIA() {
        Assert.assertArrayEquals(ia, new int[]{1, 2, 3});
    }

    @Test
    public void testIL() {
        // It will compare them by reference.
        Assert.assertNotSame(il, Arrays.asList(1, 2, 3, 4, 5));

        // If using assertEquals series on reference type, it will only compare two by values.
        Assert.assertEquals(il, Arrays.asList(1, 2, 3, 4, 5));
    }
}
