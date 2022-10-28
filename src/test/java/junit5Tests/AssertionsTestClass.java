package junit5Tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTestClass {

    @Test
    void assertEqualsTest() {
        assertEquals("first string", "second string", "The string values were not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = asList("first string", "second string", "third string");
        List<String> actualValues = asList("first string", "second string");
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

    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, hasKey("secondKey"));
        assertThat(theMap, hasValue(3));
    }

    @Test
    void assertForList() {
        List<String> theList = asList("firstString", "secondString", "thirdString");

        assertThat(theList, hasItem("thirdString"));
    }

    @Test
    void assertForAnyOf() {
        List<String> theList = asList("firstString", "secondString", "thirdString");
        assertThat(theList, anyOf(hasItem("thirdString"), hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder() {
        List<String> theList = asList("firstString", "secondString", "thirdString");
        assertThat(theList, containsInAnyOrder("firstString", "thirdString", "secondString"));
    }
}
