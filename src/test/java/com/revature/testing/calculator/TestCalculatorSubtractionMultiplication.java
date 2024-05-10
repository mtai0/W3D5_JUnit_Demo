package com.revature.testing.calculator;

import com.revature.testing.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCalculatorSubtractionMultiplication {
    Calculator calculator;

    @BeforeEach
    public void initCalculator() {
        calculator = new Calculator();
    }

    @AfterEach
    public void clearCalculator() {
        calculator = null;
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "5"
    })
    @Order(1)
    @DisplayName("x - x")
    public void testSubtractionSelf(int num) {
        int actualResult = calculator.subtract(num, num);
        Assertions.assertEquals(0, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "5"
    })
    @Order(2)
    @DisplayName("x - 0")
    public void testSubtractionZero(int num) {
        int actualResult = calculator.subtract(num, 0);

        Assertions.assertEquals(num, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "5, -4, 9", "3, -1, 4"
    })
    @Order(3)
    @DisplayName("x - -y")
    public void testSubtractionNeg(int num1, int num2, int expected) {
        int actualResult = calculator.subtract(num1, num2);

        Assertions.assertEquals(expected, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 4, 1", "7, 9, -2"
    })
    @Order(4)
    @DisplayName("x - y")
    public void testSubtractionPos(int num1, int num2, int expected) {
        int actualResult = calculator.subtract(num1, num2);

        Assertions.assertEquals(expected, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "-5, -4, -1", "-7, -9, 2"
    })
    @Order(5)
    @DisplayName("-x - -y")
    public void testSubtractionDoubleNeg(int num1, int num2, int expected) {
        int actualResult = calculator.subtract(num1, num2);

        Assertions.assertEquals(expected, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, 100", "5, 2, 10", "4, 6, 24"
    })
    @Order(6)
    @DisplayName("x * y")
    public void testMultiplyPosPos(int num1, int num2, int expected) {
        int actualResult = calculator.multiply(num1, num2);
        Assertions.assertEquals(expected, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "5"
    })
    @Order(7)
    @DisplayName("x * 1")
    public void testMultiplyPosOne(int num) {
        int actualResult = calculator.multiply(num, 1);
        Assertions.assertEquals(num, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "5"
    })
    @Order(8)
    @DisplayName("x * -1")
    public void testMultiplyPosNegOne(int num) {

        int actualResult = calculator.multiply(num, -1);
        Assertions.assertEquals(-num, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "-2", "5", "-5",
    })
    @Order(9)
    @DisplayName("x * 0")
    public void testMultiplyPosZero(int num) {
        int actualResult = calculator.multiply(num, 0);
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    @Order(10)
    @DisplayName("-1 * -1")
    public void testMultiplyNegNeg() {
        int expectedResult = 1;
        int actualResult = calculator.multiply(-1, -1);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Order(11)
    @DisplayName("0 * 0")
    public void testMultiplyZeroZero() {
        int expectedResult = 0;
        int actualResult = calculator.multiply(0, 0);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
