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

    public MatrixTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }


    public void testProductValid() {
        double num = 3.14;
        double[][] matrixArr = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        Function<double[][], double[][]> func = (input) -> Matrix.product(input, num);
        double[][] product = MetricsRunner.measuredRun(func, matrixArr);
        double[][] expectedProduct = {
                {3.14, 3.14, 3.14},
                {3.14, 3.14, 3.14},
                {3.14, 3.14, 3.14}
        };
        assertTrue(Arrays.deepEquals(product, expectedProduct));
    }
}
