package dsa.datastructures;

import lombok.extern.slf4j.Slf4j;

/**
 * Mathematical matrix where m stands for rows and n stands for columns.
 * */

@Slf4j
public final class Matrix {

    private Matrix() {}


    public static boolean areMatricesEqual(double[][] a, double[][] b) {
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

    public static double[][] matrixProduct(double[][] matrix, double num) {
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

    public static double[][] matricesSum(double[][] a, double[][] b) {
        if (!areMatricesEqual(a, b)) return null;

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

    public static double[][] matricesDifference(double[][] a, double[][] b) {
        if (areMatricesEqual(a, b)) return null;
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

    public static double[][] matricesProduct(double[][] a, double[][] b) {
        int m = a.length;
        
        int n = a[0].length;
        int mB = b.length;
        if (mB != n) {
            log.error("Matrix a columns has to equal matrix b rows");
            return null;
        }

        double[][] result = new double[m][nB];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < nB; j++) {
                result[i][j] = a[i][j] * b[i][j];
            }
        }

        return result;
    }
}