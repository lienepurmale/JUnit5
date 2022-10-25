package junit5Tests;

import org.junit.jupiter.api.*;

public class RepeatingTests {


    @RepeatedTest(5)
    void firstMethod() {
        System.out.println("We are repeating this test");
    }

    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}. Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    void secondMethod() {
        System.out.println("We are repeating a new test");
    }

    @RepeatedTest(3)
    void thirdMethod(RepetitionInfo repetitionInfo) {
        System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3,
        () -> System.out.println("This code runs only for repetition 3"));
    }
}
