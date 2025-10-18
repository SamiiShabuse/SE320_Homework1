package edu.drexel.se320;

// Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.lessThan;

// Core JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;


public class OpenBoxTests extends BinarySearchBase {
    @Test
    @DisplayName("Found immediately at first mid (cmp == 0)")
    void foundImmediateMid() {
        Integer[] arr = {1, 3, 5, 7, 9}; // mid=5 on first step
        int idx = BinarySearch.binarySearchImplementation(arr, 5);
        assertEquals(5, arr[idx]);
    }

    @Test
    @DisplayName("Go left then find (cmp < 0 path exercised)")
    void goLeftThenFind() {
        Integer[] arr = {2, 4, 6, 8, 10, 12}; // first mid=8; target smaller
        int idx = BinarySearch.binarySearchImplementation(arr, 4);
        assertEquals(4, arr[idx]);
    }

    @Test
    @DisplayName("Go right then find (cmp > 0 path exercised)")
    void goRightThenFind() {
        Integer[] arr = {2, 4, 6, 8, 10, 12}; // first mid=8; target greater
        int idx = BinarySearch.binarySearchImplementation(arr, 12);
        assertEquals(12, arr[idx]);
    }
}

