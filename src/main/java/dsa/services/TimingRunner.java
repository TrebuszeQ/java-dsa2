package dsa.services;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class TimingRunner {
    public TimingRunner() {}


    private static void logTime(Duration delta) {
        double deltaDN = delta.toNanos()/1000000.0;
        double deltaDM = delta.toMillis()/1000000.0;
        double deltaDH = delta.toMinutes()/60000.0;

        if (deltaDH > 0.1) {
            log.info("Function ran for {} ms", deltaDH);
        }
        else if (deltaDM > 0.1) {
            log.info("Function ran for {} ms", deltaDM);
        }
        else {
            log.info("Function ran for {} ms", deltaDN);
        }
    }

    public static <T> T measuredRun(Function<T, T> func, T input) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        T result = func.apply(input);
        Duration delta = Duration.between(now, Instant.now());
        logTime(delta);

        return result;
    }

    public static Double[][] measuredRun(BiFunction<Double[][], Double[][], Double[][]> biFunc, Double[][] inputA, Double[][] inputB) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        Double[][] result = biFunc.apply(inputB, inputA);
        Duration delta = Duration.between(now, Instant.now());
        logTime(delta);

        return result;
    }

    public static Double[][] measuredRun(BiFunction<Double[][], Integer, Double[][]> biFunc, Integer inputA, Double[][] inputB) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        Double[][] result = biFunc.apply(inputB, inputA);
        Duration delta = Duration.between(now, Instant.now());
        logTime(delta);

        return result;
    }

    public static double[][] measuredRun(BiFunction<double[][], double[][], double[][]> biFunc, double[][] inputA, double[][] inputB) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        double[][] result = biFunc.apply(inputB, inputA);
        Duration delta = Duration.between(now, Instant.now());
        logTime(delta);

        return result;
    }

    public static double[][] measuredRun(BiFunction<double[][], Integer, double[][]> biFunc, int inputA, double[][] inputB) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        double[][] result = biFunc.apply(inputB, inputA);
        Duration delta = Duration.between(now, Instant.now());
        logTime(delta);

        return result;
    }
}
