package dsa.datastructures;

import dsa.AppTest;
import dsa.services.MetricsRunner;
import dsa.utils.Randomizer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Function;

@Slf4j
public class MatrixTest extends TestCase {
    double[][] matrixArr = Randomizer.double2DArray(3, 4);
    Matrix matrix = new Matrix(matrixArr);

    public MatrixTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testMatrixConstructorValid() {
        assertEquals(matrix.matrix, matrixArr);
        assertEquals(matrix.m, 3);
        assertEquals(matrix.n, 4);
    }

    public void testProductValid() {
        double num = 3.14;
        double[][] matrixArr = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        Matrix matrix = new Matrix(matrixArr);
        MetricsRunner.measuredRun(matrix.product, );
        double[][] product = matrix.product(num);
        double[][] expectedProduct = {
                {3,14, 3,14, 3,14},
                {3,14, 3,14, 3,14},
                {3,14, 3,14, 3,14}
        };
        assertEquals(product, expectedProduct);
    }
}
