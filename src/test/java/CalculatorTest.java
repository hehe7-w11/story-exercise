import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    @Test
    void test_multiply_positive_numbers() {
        // Given
        int a = 3, b = 2;
        // When
        Calculator calculator = new Calculator();
        int result = calculator.multiply(a, b);
        // Then
        assertEquals(6, result);
    }

    @Test
    void test_multiply_positive_and_negative_number() {
        // Given
        int a = 3;
        int b = -1;

        // When
        Calculator calculator = new Calculator();
        int result = calculator.multiply(a, b);

        // Then
        assertEquals(-3, result);
    }

    @Test
    void test_multiply_negative_numbers() {
        // Given
        int a = -3;
        int b = -2;

        // When
        Calculator calculator = new Calculator();
        int result = calculator.multiply(a, b);

        // Then
        assertEquals(6, result);
    }

    @Test
    void test_multiply_with_zero() {
        // Given
        int a = 3;
        int b = 0;

        // When
        Calculator calculator = new Calculator();
        int result = calculator.multiply(a, b);

        // Then
        assertEquals(0, result);
    }

    @Test
    void test_multiply_with_large_number() {
        // Given
        long a = Integer.MAX_VALUE;
        long b = 3;

        // When
        Calculator calculator = new Calculator();
        long result = calculator.multiply(a, b);

        // Then
        assertEquals(6442450941L, result);
    }
}
