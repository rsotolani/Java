package com.thealgorithms.searches;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BinarySearchFuzzer {

    private static final int MAX_ARRAY_SIZE = 100; // Maximum size of the generated arrays
    private static final int NUM_ITERATIONS = 100000; // Number of iterations to run the fuzzer

    private Random random = new Random();

    /**
     * This test generates random sorted arrays and random keys for 100,000 iterations and tests the find method.
     */
    @Test
    void testBinarySearchRandomized() {
        BinarySearch binarySearch = new BinarySearch();

        System.out.println("Starting the fuzzer with " + NUM_ITERATIONS + " iterations...");

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            // Generate a random array size between 1 and MAX_ARRAY_SIZE
            int arraySize = random.nextInt(MAX_ARRAY_SIZE) + 1;

            // Generate a random sorted array of integers
            Integer[] array = generateSortedArray(arraySize);

            // Generate a random key from the range of integers in the array
            int key = array[random.nextInt(arraySize)];

            // Print the array and the key being searched for
            System.out.println("Iteration " + (i + 1) + " of " + NUM_ITERATIONS);
            System.out.println("Array: " + Arrays.toString(array));
            System.out.println("Key to search: " + key);

            // Perform the search using the find method
            int result = binarySearch.find(array, key);

            // Check if the result is correct
            int expectedIndex = findExpectedIndex(array, key);

            // Print the expected and actual result for each iteration
            System.out.println("Expected index: " + expectedIndex + ", Found index: " + result);
            assertEquals(expectedIndex, result, "The index of the found element is incorrect.");
        }

        System.out.println("Fuzzer completed successfully!");
    }

    /**
     * Generates a random sorted array of integers.
     *
     * @param size The size of the array to generate.
     * @return A sorted array of integers.
     */
    private Integer[] generateSortedArray(int size) {
        Integer[] array = new Integer[size];

        // Fill the array with random integers
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(2000); // Random integer between 0 and 1999
        }

        // Sort the array
        Arrays.sort(array);

        return array;
    }

    /**
     * Finds the expected index of the key in the array using linear search.
     * This is used for validation against the result of BinarySearch.
     *
     * @param array The sorted array.
     * @param key The key to search for.
     * @return The expected index of the key, or -1 if not found.
     */
    private int findExpectedIndex(Integer[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i;
            }
        }
        return -1; // Key not found
    }
}
