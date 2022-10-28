package junit5Tests;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MiscTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void timeout() throws InterruptedException {
        System.out.println("This is a test with a timeout");
        sleep(6000);
    }

    @Test
    @Timeout(90)
    @DisplayName("This is the nice method")
    @Tag("theTag")
    void annotatedMethod() {
        System.out.println("This is the annotated method");
    }

    @MyAnnotation
    void annotatedMethod2() {
        System.out.println("This is the custom annotated method");
    }


    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest {
        @BeforeAll
        void beforeAll() {
            System.out.println("Before all in nested Test");
        }

        @Test
        void nestedMethod() {
            System.out.println("This is a main method");
        }

    }
}
