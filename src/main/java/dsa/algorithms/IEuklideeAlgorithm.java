package dsa.algorithms;

public interface IEuklideeAlgorithm {
    /** Calculates the greatest common divisor
     * from two positive integer numbers
     * recursive way
     */
    default int euklideeAlgorithmRecursive(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return euklideeAlgorithmRecursive(q, r);
    }
}
