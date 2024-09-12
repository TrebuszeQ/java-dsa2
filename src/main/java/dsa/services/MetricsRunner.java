package dsa.services;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

@Slf4j
public class MetricsRunner {
    public MetricsRunner() {}

    public static <T> T measuredRun(Function<T, T> func, T input) {
        log.info("Measuring running time");
        Instant now = Instant.now();
        T result = func.apply(input);
        Instant later = Instant.now();
        Duration delta = Duration.between(now, later);
        log.info("Function ran for {} ms", delta.toMillis());
        return result;
    }
}
