# Account Transfer Demo - Unit Test Practice

## Scenario

We have implemented a simple **Account Transfer Service** that allows money to be transferred between two accounts. The implementation is already complete. Your task as trainees is to **write unit tests** to validate its behavior.

## Learning Goals

* Practice **Test-Driven Thinking** (even though implementation exists).
* Learn how to design **unit tests** based on requirements.
* Improve skills in **JUnit5** and **assertions**.
* Understand **edge cases** in financial transactions.

## Requirements to Test

1. Transfer decreases the balance of the source account.
2. Transfer increases the balance of the destination account.
3. Transfer amount cannot be negative.
4. Transfer cannot happen if the source account has insufficient balance.
5. After successful transfer, the sum of balances remains unchanged.

## What To Do

* Create a test class, e.g., `AccountServiceTest`.
* Use **JUnit 5**.
* Apply **Given/When/Then** style in test cases.
* Cover both **happy path** and **error scenarios**.

---