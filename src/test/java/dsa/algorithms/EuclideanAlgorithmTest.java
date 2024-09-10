package dsa.algorithms;

import dsa.AppTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EuclideanAlgorithmTest extends TestCase {
    public EuclideanAlgorithmTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testEuclideanAlgorithm() {
        int p = 10;
        int q = 5;
        assertEquals(EuclideanAlgorithm.euclideanAlgorithmRecursive(p, q), 5);
    }
}
