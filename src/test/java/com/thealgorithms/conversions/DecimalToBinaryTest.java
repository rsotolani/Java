package com.thealgorithms.conversions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DecimalToBinaryTest {

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 10", "5, 101", "10, 1010", "15, 1111", "100, 1100100"})
    void testConvertUsingConventionalAlgorithm(int decimal, int expectedBinary) {
        assertEquals(expectedBinary, DecimalToBinary.convertUsingConventionalAlgorithm(decimal));
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 10", "5, 101", "10, 1010", "15, 1111", "100, 1100100"})
    void testConvertUsingBitwiseAlgorithm(int decimal, int expectedBinary) {
        assertEquals(expectedBinary, DecimalToBinary.convertUsingBitwiseAlgorithm(decimal));
    }


    @Test
    void testConvertUsingConventionalAlgorithmWithNegativeInput() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DecimalToBinary.convertUsingConventionalAlgorithm(-10);
        });
        assertEquals("Negative numbers are not supported.", exception.getMessage());
    }

    @Test
    void testConvertUsingBitwiseAlgorithmWithNegativeInput() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DecimalToBinary.convertUsingBitwiseAlgorithm(-10);
        });
        assertEquals("Negative numbers are not supported.", exception.getMessage());
    }

    @Test
    void testConvertUsingConventionalAlgorithmWithZero() {
        // given
        int decimal = 0;

        // when
        int result = DecimalToBinary.convertUsingConventionalAlgorithm(decimal);

        // then
        assertEquals(0, result);
    }

    @Test
    void testConvertUsingBitwiseAlgorithmWithZero() {
        // given
        int decimal = 0;

        // when
        int result = DecimalToBinary.convertUsingBitwiseAlgorithm(decimal);

        // then
        assertEquals(0, result);
    }


}
