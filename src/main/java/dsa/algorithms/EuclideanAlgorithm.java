package dsa.algorithms;

public final class EuclideanAlgorithm {
    /** Calculates the greatest common divisor
     * from two positive integer numbers
     * recursive way
     */

    private EuclideanAlgorithm() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static int euclideanAlgorithmRecursive(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return euclideanAlgorithmRecursive(q, r);
    }
}
