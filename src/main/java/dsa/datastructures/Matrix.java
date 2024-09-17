package dsa.datastructures;

import lombok.extern.slf4j.Slf4j;

/**
 * Mathematical matrix where m stands for rows and n stands for columns.
 * */

@Slf4j
public final class Matrix {

    private Matrix() {}


    public static int get_n(double[][] matrix) {
        int n;
        if (matrix.length > 0) {
            n = matrix[0].length;
            return n;
        }
        else {
            log.error("Matrix is empty");
            return 0;
        }
    }

    public static boolean areMatricesEqual(double[][] a, double[][] b) {
        int m = a.length;
        int mb = b.length;
        if (m != mb) {
            log.error("Matrices have different sizes");
            return true;
        }

        int n = get_n(a);
        int nb = get_n(b);
        if (n != nb) {
            log.error("Matrices have different sizes");
            return true;
        }

        return false;
    }

    public static double[][] matrixProduct(double[][] matrix, double num) {
        int m = matrix.length;
        int n = get_n(matrix);

        double[][] result = new double[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = num * matrix[i][j];
            }
        }

        return result;
    }

    public static double[][] matricesSum(double[][] a, double[][] b) {
        if (areMatricesEqual(a, b)) return null;
        int m = a.length;
        int n = get_n(a);
        
        double[][] result = new double[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    public static double[][] matricesDifference(double[][] a, double[][] b) {
        if (areMatricesEqual(a, b)) return null;
        int m = a.length;
        int n = get_n(a);

        double[][] result = new double[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        return result;
    }

    public static double[][] matricesProduct(double[][] a, double[][] b) {

    }
}