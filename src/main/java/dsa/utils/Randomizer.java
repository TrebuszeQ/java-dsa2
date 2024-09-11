package dsa.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Randomizer {
    private static Randomizer instance = null;

    private Randomizer() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static double[][] double2DArray(int rows, int columns) {
        double[][] double2DArray = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double num = Math.random();
                double2DArray[i][j] = num;
            }
        }

        return double2DArray;
    }

}
