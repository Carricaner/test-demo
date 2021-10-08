package com.demo.test.suit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//TestSuite.class
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestOne.class,
        TestTwo.class
})
public class TestSuite {
}

