public class Calculator {

    public int multiply(int a, int b) {
        if (a == b) {
            throw new IllegalArgumentException("2 params must not be equal");
        }
        return a * b;
    }

    public long multiply(long a, long b) {
        return a * b;
    }
}
