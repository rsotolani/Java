package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the BinarySearch class.
 */
class BinarySearchTest {

    /**
     * Test for basic binary search functionality.
     */
    @Test
    void testBinarySearchFound() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {5, 17, 33, 46, 88, 92, 100, 200, 555, 2000};
        int key = 100;
        int expectedIndex = 6; // Index of the key in the array
        assertEquals(expectedIndex, binarySearch.find(array, key), "The index of the found element should be 6.");
    }

    /**
     * Test for binary search when the element is not present.
     */
    @Test
    void testBinarySearchNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {10, 20, 30, 40, 50};
        int key = 60; // Element not present in the array
        int expectedIndex = -1; // Key not found
        assertEquals(expectedIndex, binarySearch.find(array, key), "The element should not be found in the array.");
    }

    /**
     * Test for binary search with an empty array.
     */
    @Test
    void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {}; // Empty array
        int key = 1; // Key not present
        int expectedIndex = -1; // Key not found
        assertEquals(expectedIndex, binarySearch.find(array, key), "The element should not be found in an empty array.");
    }

}
