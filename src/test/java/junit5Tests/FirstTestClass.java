package junit5Tests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class FirstTestClass {

    @BeforeAll
    void beforeAll(){
        System.out.println("-This is the before method-");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("-- This is the before each method --");
    }

    @AfterAll
    void afterAll(){
        System.out.println("- This is the after all method-");
    }

    @AfterEach
    void afterEach(){
        System.out.println("-- This is the after each method --");
    }

    @Test
    // 1. Create a new method:
    // accessModifier returnType nameOfMethod(params)

    void firstMethod(){
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod(){
        System.out.println("This is the second test method");
    }
}
