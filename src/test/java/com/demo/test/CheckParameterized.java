package com.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

// @RunWith can determine by which method to run the test
// Here, we run the test by adopting various parameters.
@RunWith(Parameterized.class)
public class CheckParameterized {

    private int testNumber;
    private boolean result;

    private StateMachine stateMachine = new StateMachine();

    public CheckParameterized(Integer testNumber, Boolean result) {
        this.testNumber = testNumber;
        this.result = result;
    }

    @Parameterized.Parameters
    public static List<Object> testData() {
        return Arrays.asList(
                new Object[][]{
                        {0, true},
                        {1, false},
                        {2, false},
                        {3, true},
                        {4, false}
                }
        );
    }

    class StateMachine {
        public boolean checkNumber(int input) {
            return input % 3 == 0;
        }
    }

    // Unchanged
    // Wait for studying the details of Params in jupiter.api test package.
    @Test
    public void testCase() {
        assertEquals(stateMachine.checkNumber(testNumber), result);
    }
}
