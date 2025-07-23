
# 🧪 Unit Testing Exercise – Calculator Multiply

## 📘 Objective

This exercise helps you understand how to write **unit tests using JUnit 5**.  
You will:
- Learn how to structure test cases using `Given / When / Then` style
- Practice testing multiple scenarios
- Compare traditional print-based testing with automated assertions

---

## ✅ Task Overview

You're given a simple `Calculator` class with one method:

```java
public class Calculator {
    public int multiply(int a, int b) {
        return a * b;
    }
}
```

Your job is to **write unit tests** for different multiplication scenarios.

---

## ❌ Old Approach (for reference)

The `main()` method below shows the old way of manual testing (not recommended for real projects):

```java
public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int a = 3, b = 2;
        int result = calculator.multiply(a, b);
        System.out.printf("3 x 2 = %d\n", result);
        // ...more cases
    }
}
```

---

## ✅ Modern Approach Using JUnit 5

We use the JUnit 5 framework to write proper unit tests like this:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test_multiply_positive_numbers() {
        // Given
        int a = 3, b = 2;
        Calculator calculator = new Calculator();

        // When
        int result = calculator.multiply(a, b);

        // Then
        assertEquals(6, result);
    }

    // 🧠 TODO: Add more test cases below
}
```

---

## ✍️ Your Tasks

Please complete the following test cases:

| #           | Scenario Description | Method Name |
|-------------|----------------------|-------------|
| 1           | Positive × Negative → Negative | `test_multiply_positive_and_negative()` |
| 2           | Negative × Negative → Positive | `test_multiply_two_negatives()` |
| 3           | Positive × Zero → 0 | `test_multiply_positive_and_zero()` |

---

## 🛠 How to Run the Tests

Make sure you have JUnit 5 configured in your project (e.g., in your `pom.xml`):

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.12.2</version>
    <scope>test</scope>
</dependency>
```

Then run the tests with your IDE

---

## 📌 Tips

- Use clear method names like `test_multiply_with_zero()`
- Always follow `Given / When / Then` structure
- Think about **edge cases** and **boundary values**

---

Happy Testing! 🎯
