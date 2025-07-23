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

    // 🧠 TODO: Add more test cases below

}
