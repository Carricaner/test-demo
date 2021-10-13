package com.demo.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestJunitTestLifeCycle {

    @BeforeAll
    public static void checkBeforeClass() {
        // This will be executed before the class.
        System.out.println("[[ Before Class Check Start ]]");
    }

    @BeforeEach
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

    @Disabled
    public void wontRun() {
        // This test won't run because the annotation @Ignore.
        System.out.println("(( Ignore This Test ))");
    }

    
    // Caveat! The expected and timeout annotation elements of org.junit.Test are handled by dedicated Jupiter assertions.
    @Test
    public void checkTimeout() {
        Assertions.assertTimeout(
                Duration.ofSeconds(5L),
                () -> TimeUnit.SECONDS.sleep(1)
        );
        System.out.println("(( Check Timeout Test ))");
    }

    // Caveat! The expected and timeout annotation elements of org.junit.Test are handled by dedicated Jupiter assertions.
    @Test
    public void checkException() {
        // Check it out next time
//        Assertions.assertThrows(
//                RuntimeException.class,
//                () -> {throw new RuntimeException()}
//        );
    }

    @AfterEach
    public void cleanMethod() {
        // This will be executed after every method.
        System.out.println("<< After Method Clean Start >>");
    }

    @AfterAll
    public static void cleanClass() {
        // This will be executed after the class.
        System.out.println("[[ After Class Clean Start ]]");
    }

}
