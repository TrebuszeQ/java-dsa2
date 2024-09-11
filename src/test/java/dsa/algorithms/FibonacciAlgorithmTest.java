package dsa.algorithms;

import dsa.AppTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FibonacciAlgorithmTest extends TestCase {
    public FibonacciAlgorithmTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testFibonacciAlgorithm() {
        for (int n = 0; n < 100; n++) {
            log.info("{} {}", n, FibonacciAlgorithm.fibonacci(n));
        }
    }
}