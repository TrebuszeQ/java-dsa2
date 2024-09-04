package dsa.algorithms;

import dsa.AppTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EuklideeAlgorithmTest extends TestCase implements IEuklideeAlgorithm {
    public EuklideeAlgorithmTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testEuklideeAlgorithm() {
        int p = 10;
        int q = 5;
        assertEquals(euklideeAlgorithmRecursive(p, q), 5);
    }
}
