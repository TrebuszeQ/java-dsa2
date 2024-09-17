package dsa.services;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class MetricsRunner {
    public MetricsRunner() {}

    public static <T> T measuredRun(Function<T, T> func, T input) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        T result = func.apply(input);
        Duration delta = Duration.between(now, Instant.now());

        log.info("Function ran for {} ms", delta.toNanos()/1000000.0);
        return result;
    }

    public static <T> T measuredRun(BiFunction<T, T, T> func, T inputA, T inputB) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        T result = func.apply(inputA, inputB);
        Duration delta = Duration.between(now, Instant.now());

        log.info("Function ran for {} ms", delta.toNanos()/1000000.0);
        return result;
    }
}
