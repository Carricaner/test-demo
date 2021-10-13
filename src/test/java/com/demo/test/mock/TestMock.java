package com.demo.test.mock;

import com.demo.test.component.DependedOnComponent;
import com.demo.test.component.SystemUnderTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMock {

    SystemUnderTest sut = new SystemUnderTest();

    @Test
    public void originalClass() {
        DependedOnComponent testInterface = new DependedOnComponent();
        sut.setDependedOnComponent(testInterface);
        System.out.println("----- Original run -----");
        sut.run();
        System.out.println("------------------------\n");
    }

    @Test
    public void testSutByMock() {
        // Use static method, Mockito.mock(), to imitate the class we want.
        DependedOnComponent dependedOnComponent = Mockito.mock(DependedOnComponent.class);
        sut.setDependedOnComponent(dependedOnComponent);

        // Use method "when" to imitate the methods inside the class.
        Mockito.when(dependedOnComponent.doSomething()).thenReturn("Mock class");

        System.out.println("----- testSutByMock -----");
        sut.run();
        System.out.println("-------------------------\n");
        // It will print below
        // ----- testSutByMock -----
        // Mock class called by test class
        // null called by test class
        // -------------------------
        // The method, doSomethingTwo, here is not mocked, so it will print out null.

    }
}
