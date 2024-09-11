package dsa.datastructures;

import dsa.AppTest;
import dsa.utils.Randomizer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MatrixTest extends TestCase {
    public MatrixTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testMatrixConstructor() {
        double[][] matrixArr = Randomizer.double2DArray(3, 4);
        Matrix matrix = new Matrix(matrixArr);
        assertEquals(matrix.m, 3);
    }
}
