package com.thealgorithms.strings;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PalindromeTestFuzzer {

    private static final Random random = new Random();

    // Helper function to generate random strings
    private String generateRandomString() {
        int length = random.nextInt(100);  // Generate a string of random length (up to 100 characters)
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(95) + 32);  // ASCII characters between 32 and 126 (including special characters)
            sb.append(randomChar);
        }
        return sb.toString();
    }

    // Helper function to generate palindrome strings
    private String generatePalindromeString() {
        String randomString = generateRandomString();
        StringBuilder sb = new StringBuilder(randomString);
        return randomString + sb.reverse().toString();
    }

    @Test
    public void testRandomFuzzing() {
        // Perform 10000 tests with random inputs
        for (int i = 0; i < 10000; i++) {
            String randomInput = generateRandomString();
            boolean expected = isPalindrome(randomInput); // Use the isPalindrome method to determine the expected result

            // Test if the conversion is correct for isPalindrome method
            boolean actual = Palindrome.isPalindrome(randomInput);

            // Verbose Output
            System.out.println("Test #" + (i + 1));
            System.out.println("Input String: " + randomInput);
            System.out.println("Expected Output (isPalindrome): " + expected);
            System.out.println("Actual Output (isPalindrome): " + actual);

            // Check if the actual output matches the expected for isPalindrome method
            if (expected != actual) {
                System.out.println("Test failed for isPalindrome!");
            } else {
                System.out.println("Test passed for isPalindrome!");
            }
            assertEquals(expected, actual);

            // Testing isPalindromeRecursion
            expected = isPalindrome(randomInput);
            actual = Palindrome.isPalindromeRecursion(randomInput);
            System.out.println("Expected Output (isPalindromeRecursion): " + expected);
            System.out.println("Actual Output (isPalindromeRecursion): " + actual);
            if (expected != actual) {
                System.out.println("Test failed for isPalindromeRecursion!");
            } else {
                System.out.println("Test passed for isPalindromeRecursion!");
            }
            assertEquals(expected, actual);

            // Testing isPalindromeTwoPointer
            expected = isPalindrome(randomInput);
            actual = Palindrome.isPalindromeTwoPointer(randomInput);
            System.out.println("Expected Output (isPalindromeTwoPointer): " + expected);
            System.out.println("Actual Output (isPalindromeTwoPointer): " + actual);
            if (expected != actual) {
                System.out.println("Test failed for isPalindromeTwoPointer!");
            } else {
                System.out.println("Test passed for isPalindromeTwoPointer!");
            }
            assertEquals(expected, actual);

            // Adding a separator line for readability
            System.out.println("-------------------------------------------------");
        }
    }

    private boolean isPalindrome(String s) {
        return ((s == null || s.length() <= 1) || s.equals(new StringBuilder(s).reverse().toString()));
    }
}
