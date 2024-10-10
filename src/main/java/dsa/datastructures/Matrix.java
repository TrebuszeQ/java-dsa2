package dsa.datastructures;

import lombok.extern.slf4j.Slf4j;

/**
 * Mathematical matrix where m stands for rows and n stands for columns.
 * */

@Slf4j
public final class Matrix {

    private Matrix() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static boolean isMatrix(double[][] array) {
        if (isEmpty(array)) {
            log.error("Not a matrix");
            return false;
        }

        for (double[] doubles : array) {
            if (doubles.length != array[0].length) {
                log.error("Not a matrix");
                return false;
            }
        }

        return true;
    }

    public static boolean isEmpty(double[][] array) {
        if (array == null) {
            log.error("Array is null");
            return true;
        }

        if (array.length == 0) {
            log.error("Array has no rows");
            return true;
        }

        if (array[0].length == 0) {
            log.error("Array has no columns");
        }

        return false;
    }

    /** Checks if matrices are not empty and not null matrices, and if those are equal..
     *
     */
    public static boolean areEqual(double[][] a, double[][] b) {

        if (!isMatrix(a) || !isMatrix(b)) return false;
        int m = a.length;
        int mb = b.length;
        if (m != mb) {
            log.error("Rows are not equal");
            return false;
        }

        boolean equal = true;

        try {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i].length != b[i].length) {
                        return false;
                    }
                }
            }
        }
        catch (Exception e) {
            log.error("Columns are not equal");
            return false;
        }

        return equal;
    }

    public static double[][] product(double[][] matrix, double num) {
        if (!isMatrix(matrix)) return null;

        int m = matrix.length;
        int n = matrix[0].length;

        double[][] result = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = num * matrix[i][j];
            }
        }

        return result;
    }

    public static double[][] sum(double[][] a, double[][] b) {
        if (!areEqual(a, b)) return null;

        int m = a.length;
        int n = a[0].length;
        double[][] result = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    public static double[][] difference(double[][] a, double[][] b) {
        if (areEqual(a, b)) return null;
        int m = a.length;
        int n = a[0].length;

        double[][] result = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        return result;
    }

    public static double[][] product(double[][] a, double[][] b) {
        if (!isMatrix(a) || !isMatrix(b)) return null;

        int m = a.length;
        int n = a[0].length;

        int mB = b.length;

        if (mB != n) {
            log.error("Matrix A columns length doesn't equal matrix B rows length");
            return null;
        }

        int nB = b[0].length;

        double[][] result = new double[m][nB];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < nB; j++) {
                double[] bColumn = getColumn(b, j);
                log.debug("bColumn: {}", bColumn);
                double sum = sumOfProducts(a[i], bColumn);
                log.debug("sum: {}", sum);
                result[i][j] = sum;
            }
        }

        return result;
    }

    private static double sumOfProducts(double[] aRow, double[] bCol) {
        double sum = 0;
        for (int i = 0; i < aRow.length; i++) {
            sum += aRow[i] * bCol[i];
        }

        return sum;
    }

    public static double[] getColumn(double[][] arr, int colIndex) {
        int length = arr.length;
        double[] column = new double[length];
        for (int i = 0; i < length; i++) {
            column[i] = arr[i][colIndex];
        }

        return column;
    }

    public static double[][] power(double[][] a, int degree) {
        for (int i = 0; i < degree; i++) {
            a = product(a, a);
        }
        
        return a;
    }
}