package com.demo.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.demo.test.component.TestObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestAssertJ {

    @Test
    public void testDate() {
        LocalDate localDate = LocalDate.of(2020, 2, 10);
        LocalDate beforeDate = LocalDate.of(2020, 1, 10);
        LocalDate afterDate = LocalDate.of(2020, 4, 10);

        assertThat(localDate)
                .isBefore(afterDate)
                .isAfter(beforeDate)
                .isBetween(beforeDate, afterDate);

        // original JUnit use
//        Assert.assertTrue(localDate.isAfter(beforeDate));
//        Assert.assertTrue(localDate.isBefore(afterDate));
    }

    @Test
    public void testObjectList() {
        List<TestObject> testObjects = Arrays.asList(
                new TestObject("Me", "People"),
                new TestObject("You", "Reader")
        );
        Assertions.assertThat(testObjects)
                .anyMatch(x -> x.getName().equals("Me"))
                .doesNotContainNull();
    }
}


