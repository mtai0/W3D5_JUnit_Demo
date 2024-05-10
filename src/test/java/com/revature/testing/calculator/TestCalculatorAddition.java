package com.revature.testing.calculator;

import com.revature.testing.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCalculatorAddition {
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
    @DisplayName("Pos + Pos")
    @CsvSource({
            "1, 1, 2",
            "1, 2, 3",
            "10, 50, 60"
    })
    public void testAdditionPosPos(int num1, int num2, int expected) {
        int actualResult = calculator.add(num1, num2);

        Assertions.assertEquals(expected, actualResult);
    }

    @Test
    @Order(2)
    @DisplayName("0 + 0")
    public void testAdditionZeroZero() {
        int firstNum = 0;
        int secondNum = 0;
        int expectedResult = 0;
        int actualResult = calculator.add(firstNum, secondNum);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @Order(3)
    @DisplayName("Num + 0")
    @CsvSource({
            "1", "-1", "5", "-5"
    })
    public void testAdditionZero(int num) {
        int secondNum = 0;
        int actualResult = calculator.add(num, secondNum);

        Assertions.assertEquals(num, actualResult);
    }

    @ParameterizedTest
    @Order(4)
    @DisplayName("Pos + Neg")
    @CsvSource({
            "5, -1, 4", "-2, 5, 3", "1, -1, 0"
    })
    public void testAdditionPosNeg(int num1, int num2, int expected) {

        int actualResult = calculator.add(num1, num2);

        Assertions.assertEquals(expected, actualResult);
    }

    @ParameterizedTest
    @Order(5)
    @DisplayName("Neg + Neg")
    @CsvSource({
            "-1, -1, -2", "-5, -4, -9", "-6, -14, -20"
    })
    public void testAdditionNegNeg(int num1, int num2, int expected) {
        int actualResult = calculator.add(num1, num2);

        Assertions.assertEquals(expected, actualResult);
    }
}
