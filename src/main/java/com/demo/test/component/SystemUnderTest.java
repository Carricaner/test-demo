package com.demo.test.component;

import com.demo.test.component.DependedOnComponent;

public class SystemUnderTest {
    private DependedOnComponent dependedOnComponent;
    public void setDependedOnComponent(DependedOnComponent dependedOnComponent) {
        this.dependedOnComponent = dependedOnComponent;
    }
    public void run() {
        System.out.println(dependedOnComponent.doSomething() + " called by test class");
        System.out.println(dependedOnComponent.doSomethingTwo() + " called by test class");
    }
}