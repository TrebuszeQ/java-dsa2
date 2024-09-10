package dsa.algorithms;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class FibonacciAlgorithm {
    private FibonacciAlgorithm() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
