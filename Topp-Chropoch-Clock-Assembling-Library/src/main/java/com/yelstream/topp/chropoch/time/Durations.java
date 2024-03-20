package com.yelstream.topp.chropoch.time;

import com.yelstream.topp.chropoch.lang.Comparables;
import lombok.experimental.UtilityClass;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Utility addressing instances of {@link Duration}.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-24
 */
@UtilityClass
public class Durations {
    public static final Duration FOREVER=of(ChronoUnit.FOREVER);

    public static final Duration MIN_VALUE=FOREVER.negated();

    public static final Duration MAX_VALUE=FOREVER;

    public static Duration of(TemporalUnit temporalUnit) {
        return temporalUnit.getDuration();
    }

    public static Duration min(Duration a, Duration b) {
        return Comparables.min(a,b);
    }

    public static Duration max(Duration a, Duration b) {
        return Comparables.max(a,b);
    }

    public static boolean isInfinite(Duration duration) {
        return duration.abs().equals(FOREVER);
    }

    public static boolean isFinite(Duration duration) {
        return !isInfinite(duration);
    }

    public static DurationCreation createFrom() {
        return DurationCreation.of();
    }
}
