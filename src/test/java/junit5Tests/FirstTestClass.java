package junit5Tests;

import org.junit.jupiter.api.Test;

public class FirstTestClass {

    @Test
    // 1. Create a new method:
    // accessModifier returnType nameOfMethod(params)

    void firstMethod(){
        System.out.println("This is the first test method");
    }

    @Test
    void secondMethod(){
        System.out.println("This is the second test method");
    }
}
