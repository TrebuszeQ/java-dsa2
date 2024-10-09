package dsa.services;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class TimingRunner {
    public TimingRunner() {}

    public static <T> T measuredRun(Function<T, T> func, T input) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        T result = func.apply(input);
        Duration delta = Duration.between(now, Instant.now());
        logTime(delta);

        return result;
    }

    public static <T> T measuredRun(BiFunction<T, T, T> func, T inputA, T inputB) {
        log.info("Measuring running time");

        Instant now = Instant.now();
        T result = func.apply(inputA, inputB);
        Duration delta = Duration.between(now, Instant.now());
        logTime(delta);

        return result;
    }

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
}
