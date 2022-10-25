package junit5Tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class OrderedTestClass2 {

    @BeforeAll
    void beforeAll() {
        System.out.println("-This is the before method-");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("-- This is the before each method --");
    }

    @AfterAll
    void afterAll() {
        System.out.println("- This is the after all method-");
    }

    @AfterEach
    void afterEach() {
        System.out.println("-- This is the after each method --");
    }

    @Test
    // 1. Create a new method:
    // accessModifier returnType nameOfMethod(params)
    @Order(2)
    void firstMethod() {
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod() {
        System.out.println("This is the second test method");
    }

    @Test
    @Order(1)
    void thirdTest() {
        System.out.println("This is a third test method");
    }

}
