package com.thealgorithms.ciphers;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CaesarTestFuzzer {

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

    @Test
    public void testRandomFuzzing() {
        // Create an instance of the Caesar class
        Caesar caesar = new Caesar();

        // Perform 1000 tests with random inputs
        for (int i = 0; i < 1000; i++) {
            String randomInput = generateRandomString();
            int randomShift = random.nextInt(26); // Random shift between 0 and 25

            // Encoding
            String encoded = caesar.encode(randomInput, randomShift);
            String decoded = caesar.decode(encoded, randomShift);

            // Brute force decoding (all possible shifts)
            String[] bruteForceResults = caesar.bruteforce(encoded);

            // Verbose Output for encode and decode
            System.out.println("Test #" + (i + 1));
            System.out.println("Input String: " + randomInput);
            System.out.println("Shift: " + randomShift);
            System.out.println("Encoded Output: " + encoded);
            System.out.println("Decoded Output (using shift " + randomShift + "): " + decoded);

            // Check if decoding the encoded string returns the original string
            if (!randomInput.equals(decoded)) {
                System.out.println("Test failed for encode/decode!");
            } else {
                System.out.println("Test passed for encode/decode!");
            }

            // Checking brute force results
            System.out.println("Brute force results: ");
            boolean bruteForceMatch = false;
            for (int j = 0; j < bruteForceResults.length; j++) {
                System.out.println("Shift " + j + ": " + bruteForceResults[j]);
                if (bruteForceResults[j].equals(randomInput)) {
                    bruteForceMatch = true;
                }
            }

            // Assert that brute force found the original message
            if (!bruteForceMatch) {
                System.out.println("Brute force did not find the correct decoded message.");
            } else {
                System.out.println("Brute force succeeded in decoding the message.");
            }

            // Adding a separator line for readability
            System.out.println("-------------------------------------------------");

            // Assertions to validate correctness
            assertEquals(randomInput, decoded);
            assertEquals(randomInput, bruteForceResults[randomShift]);
        }
    }
}
