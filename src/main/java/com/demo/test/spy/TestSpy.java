package com.demo.test.spy;

import com.demo.test.component.DependedOnComponent;
import com.demo.test.component.SystemUnderTest;
import org.junit.Test;
import org.mockito.Mockito;

public class TestSpy {

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
    public void testSutBySpy() {
        // Use static method, Mockito.spy(), to spy the class we want.
        DependedOnComponent dependedOnComponent = Mockito.spy(new DependedOnComponent());
        sut.setDependedOnComponent(dependedOnComponent);

        // Use method "when" to imitate the methods inside the class.
        Mockito.when(dependedOnComponent.doSomething()).thenReturn("Mock class ");

        System.out.println("----- testSutBySpy -----");
        sut.run();
        System.out.println("-------------------------\n");
        // It will print below
        // ----- testSutBySpy -----
        // Mock class  called by test class
        // In inner class's method two called by test class
        // -------------------------
        // The method, doSomethingTwo, here is not mocked, so it will use the original one.
    }
}