package ro.ddavid.springproject.unit_tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ro.ddavid.springproject.utils.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAddition_WithValidInput_ShouldPass() {
        //given
        int a = 5;
        int b = 24;
        int expectedResult = a + b;

        //when
        int actualResult = calculator.add(a, b);

        //then
        assertEquals(expectedResult, actualResult, "The addition result should be equal to the expected result.");
    }

    @Test
    void testAddition_WithResultExceedsMaximumIntegerValue_ShouldFail() {
        //given
        int a = Integer.MAX_VALUE;
        int b = 1;
        long expectedResult = (long) a + b;

        //when
        int actualResult = calculator.add(a, b);

        //then
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    void testSubtract_WithValidInput_ShouldPass() {
        //given
        int a = 1;
        int b = 1;
        int expectedResult = a + b;

        //when
        int actualResult = calculator.add(a, b);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSubtract_WithInvalidInput_ShouldFail() {
        //given
        int a = -100;
        int b = Integer.MAX_VALUE;
        long expectedResult = (long) a - b;

        //when
        int actualResult = calculator.subtract(a, b);

        //then
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    void testMultiply_WithValidInput_ShouldPass() {
        //given
        int a = 2;
        int b = 3;
        int expectedResult = a * b;

        //when
        int actualResult = calculator.multiply(a, b);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMultiply_WithValidInput_ShouldFail() {
        //given
        int a = 3;
        int b = 2;
        int expectedResult = a * b * 2;

        //when
        int actualResult = calculator.multiply(a, b);

        //then
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    void testDivide_WithValidInput_ShouldPass() {
        //given
        int a = 33;
        int b = 3;
        int expectedResult = a / b;

        //when
        int actualResult = calculator.divide(a, b);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDivide_WithValidInput_ShouldFail() {
        //given
        int a = 33;
        int b = 10;
        float expectedResult = (float) a / b;

        //when
        int actualResult = calculator.divide(a, b);

        //then
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    void testDivide_DivideByZero_ShouldThrowException() {
        int a = 3;
        int b = 0;
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }
}

