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

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
    }

    public double product(double[] x, double[] y) {
        return 2.5;
    }
}
