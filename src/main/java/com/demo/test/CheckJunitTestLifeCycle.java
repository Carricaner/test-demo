package com.demo.test;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CheckJunitTestLifeCycle {

    @BeforeClass
    public static void checkBeforeClass() {
        // This will be executed before the class.
        System.out.println("[[ Before Class Check Start ]]");
    }

    @Before
    public void checkBefore() {
        // This will be executed before every method.
        System.out.println("<< Before Method Check Start >>");
    }

    @Test
    public void doSomething() {
        System.out.println("(( Test One ))");
    }

    @Test
    public void doSomethingTwo() {
        System.out.println("(( Test Two ))");
    }

    @Ignore
    public void wontRun() {
        // This test won't run because the annotation @Ignore.
        System.out.println("(( Ignore This Test ))");
    }

    @Test(timeout = 5000)
    public void checkTimeout() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Time Out!");
        }
        System.out.println("(( Check Timeout Test ))");
    }

    @Test(expected = RuntimeException.class)
    public void checkException() {
        throw new RuntimeException();
    }

    @After
    public void cleanMethod() {
        // This will be executed after every method.
        System.out.println("<< After Method Clean Start >>");
    }

    @AfterClass
    public static void cleanClass() {
        // This will be executed after the class.
        System.out.println("[[ After Class Clean Start ]]");
    }

}
