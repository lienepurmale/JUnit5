package junit5Tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 8})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);   //soutp as a short-cut
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    // works as combo @NullAndEmptySource
    @ValueSource(strings = {"first string", "second string"})
    void stringValues(String theParam) {
        System.out.println("theParam = " + theParam);
    }


}
