package com.revature.testing.calculator;

import com.revature.testing.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCalculatorDivision {
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
    @Order(1)
    @DisplayName("x / x")
    @CsvSource({
            "1, 5, -1, -5"
    })
    public void testDivSelf(int num) {
        int expectedResult = 1;

        int actualResult = calculator.divide(num, num);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @Order(2)
    @DisplayName("x / 1")
    @CsvSource({
            "1, 5, -1, -5"
    })
    public void testDivOne(int num) {
        int actualResult = calculator.divide(num, 1);
        Assertions.assertEquals(num, actualResult);
    }

    @ParameterizedTest
    @Order(3)
    @DisplayName("x / -1")
    @CsvSource({
            "1, 5, -1, -5"
    })
    public void testDivNegOne(int num) {
        int actualResult = calculator.divide(num, -1);
        Assertions.assertEquals(-num, actualResult);
    }

    @ParameterizedTest
    @Order(4)
    @DisplayName("x / y")
    @CsvSource({
            "10, 2, 5", "100, 25, 4", "28, 4, 7"
    })
    public void testDiv(int num1, int num2, int expected) {

        int actualResult = calculator.divide(num1, num2);
        Assertions.assertEquals(expected, actualResult);
    }

    @ParameterizedTest
    @Order(5)
    @DisplayName("-x / -y")
    @CsvSource({
            "-10, -2, 5", "-100, -25, 4", "-28, -4, 7"
    })
    public void testDivDoubleNegative(int num1, int num2, int expected) {
        int actualResult = calculator.divide(num1, num2);
        Assertions.assertEquals(expected, actualResult);
    }

    @Test
    @Order(6)
    @DisplayName("Divide by Zero")
    public void testDivZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}
