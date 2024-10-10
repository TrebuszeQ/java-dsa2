package dsa.datastructures;

import dsa.AppTest;
import dsa.services.TimingRunner;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class MatrixTest extends TestCase {

    public MatrixTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testIsMatrixInvalid() {
        double[][] matrixArr = {
                {1},
                {1, 2},
                {1, 2, 3}
        };
        assertFalse(Matrix.isMatrix(matrixArr));
    }

    public void testProductValid() {
        double num = 3.14;
        double[][] matrixArr = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        Function<double[][], double[][]> func = (input) -> Matrix.product(input, num);
        double[][] product = TimingRunner.measuredRun(func, matrixArr);
        double[][] expectedProduct = {
                {3.14, 3.14, 3.14},
                {3.14, 3.14, 3.14},
                {3.14, 3.14, 3.14}
        };
        assertTrue(Arrays.deepEquals(product, expectedProduct));
    }

    public void testSumValid() {
        double[][] matrixArrA = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };
        double[][] matrixArrB = {
                {1, 2, 3},
                {1, 1, 1},
                {3, 2, 1},
        };

        BiFunction<double[][], double[][], double[][]> biFunc = Matrix::sum;
        double[][] sum = TimingRunner.measuredRun(biFunc, matrixArrA, matrixArrB);
        double[][] expectedProduct = {
                {2, 3, 4},
                {2, 2, 2},
                {4, 3, 2},
        };
        assertTrue(Arrays.deepEquals(sum, expectedProduct));
    }

    public void testDifferenceValid() {
        double[][] matrixArrA = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };
        double[][] matrixArrB = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };

        BiFunction<double[][], double[][], double[][]> biFunc = Matrix::difference;
        double[][] diff = TimingRunner.measuredRun(biFunc, matrixArrA, matrixArrB);
        double[][] expectedProduct = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertTrue(Arrays.deepEquals(diff, expectedProduct));
    }

    public void testProductValid2() {
        double[][] matrixArrA = {
                {1, 2},
                {3, 4},
        };
        double[][] matrixArrB = {
                {1, 0},
                {-1, 5}
        };

        BiFunction<double[][], double[][], double[][]> biFunc = Matrix::product;
        double[][] result = TimingRunner.measuredRun(biFunc, matrixArrA, matrixArrB);
        double[][] expectedProduct = {
                {-1, 10},
                {-1, 20}
        };
        assertTrue(Arrays.deepEquals(result, expectedProduct));
    }

    public void testProductValid3() {
        double[][] matrixArrA = {
                {2, 1, 0},
                {4, 0, 2}
        };
        double[][] matrixArrB = {
                {1, 0, 2, 1},
                {0, 1, 0, 3},
                {2, 0, 1, 5}
        };

        BiFunction<double[][], double[][], double[][]> biFunc = Matrix::product;
        double[][] result = TimingRunner.measuredRun(biFunc, matrixArrA, matrixArrB);
        double[][] expectedProduct = {
                {2, 1, 4, 5},
                {8, 0, 10, 14}
        };
        assertTrue(Arrays.deepEquals(result, expectedProduct));
    }
    
    public void testPowerValid() {
        double[][] matrixArrA = {
                {2, -1},
                {3, 0}
        };

        BiFunction<double[][], Integer, double[][]> biFunc = Matrix::power;
        double[][] result = TimingRunner.measuredRun(biFunc, new Integer(2), matrixArrA);
        double[][] expectedResult = {
                {1, -2},
                {6, -3}
        };
    }
}
