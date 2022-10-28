package junit5Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTestClass {

    @Test
    void assertEqualsTest() {
        assertEquals("first string", "second string", "The string values were not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("first string", "second string", "third string");
        List<String> actualValues = Arrays.asList("first string", "second string");
        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArraysEqualsTest() {
        int[] expectedValues = {1, 8, 6};
        int[] actualValues = {1, 4, 6};
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest() {
        assertFalse(false);
        assertTrue(false, "This boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals("first string", "second string", "The string values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "This boolean condition did not evaluate to true")
        );
    }

}
