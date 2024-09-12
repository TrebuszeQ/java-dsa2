package dsa.datastructures;

import lombok.extern.slf4j.Slf4j;

/**
 * Mathematical matrix where m stands for rows and n stands for columns.
 * */

@Slf4j
public final class Matrix {
    public int m;
    public int n;
    public double[][] matrix;

    public Matrix(double[][] array2d) {
        this.matrix = array2d;
        this.m = array2d.length;
        this.setN();
    }

    private void setN() {
        if (matrix.length > 0) n = matrix[0].length;
    }

    public double[][] product(double num) {
        double[][] result = new double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = num * matrix[i][j];
            }
        }
        return result;
    }
}