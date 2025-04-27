package com.thealgorithms.strings;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class UpperTest {

    @Test
    public void toUpperCase() {
        String input1 = "hello world";
        String input2 = "hElLo WoRlD";
        String input3 = "HELLO WORLD";
        assertEquals("HELLO WORLD", Upper.toUpperCase(input1));
        assertEquals("HELLO WORLD", Upper.toUpperCase(input2));
        assertEquals("HELLO WORLD", Upper.toUpperCase(input3));
    }

@Test
    public void toUpperCaseWithNullInput() {
        // Testa se o método lança uma exceção para entrada null
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Upper.toUpperCase(null);
        });
        assertEquals("Input string cannot be null", exception.getMessage());
    }

    @Test
    public void toUpperCaseWithEmptyString() {
        // Testa se o método lida com uma string vazia corretamente
        String input = "";
        assertEquals("", Upper.toUpperCase(input));  // Deve retornar a string vazia
    }

    @Test
    public void toUpperCaseWithSpecialCharacters() {
        // Testa se o método lida corretamente com caracteres especiais
        String input = "abc!@#";
        String expected = "ABC!@#";  // Apenas as letras devem ser convertidas para maiúsculas
        assertEquals(expected, Upper.toUpperCase(input));
    }

    @Test
    public void toUpperCaseWithNumbers() {
        // Testa se o método lida corretamente com números
        String input = "abc123";
        String expected = "ABC123";  // Apenas as letras devem ser convertidas para maiúsculas
        assertEquals(expected, Upper.toUpperCase(input));
    }


    //FUZZER
    
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
        // Perform 1000 tests with random inputs
        for (int i = 0; i < 1000; i++) {
            String randomInput = generateRandomString();
            
            // Convert the input manually to the expected value
            String expected = randomInput.toUpperCase();
            
            // Get the actual result from the toUpperCase method
            String actual = Upper.toUpperCase(randomInput);

            // Print verbose output for each test case
            System.out.println("Test #" + (i + 1));
            System.out.println("Input String: " + randomInput);
            System.out.println("Expected Output: " + expected);
            System.out.println("Actual Output: " + actual);

            // Check if the actual output matches the expected
            if (!expected.equals(actual)) {
                System.out.println("Test failed!");
            } else {
                System.out.println("Test passed!");
            }

            // Assert that the result is correct
            assertEquals(expected, actual);

            // Adding a separator line for readability
            System.out.println("-------------------------------------------------");
        }
    }

}
