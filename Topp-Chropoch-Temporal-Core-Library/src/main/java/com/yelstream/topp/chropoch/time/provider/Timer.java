package com.yelstream.topp.chropoch.time.provider;

import java.time.Duration;
import java.util.function.UnaryOperator;

/**
 * Relates durations in one timeline to durations in another timeline by transformation.
 * <p>
 *     The transformation often is, but does not need to be, from virtual time to system time.
 * </p>
 * <p>
 *     As an example -- if the clock in virtual time is set to run 48x faster than normal,
 *     then a duration of 48 minutes in virtual time will be only one minute in system time.
 *     If time is sped up then durations are shortened accordingly.
 * </p>
 * <p>
 *     Adjustments go one-way only.
 * </p>
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-05
 */
@FunctionalInterface
public interface Timer {
    /**
     * Transforms a duration from a source timeline to a target timeline.
     * @param duration Duration relative to the source timeline.
     * @return Duration relative to the target timeline.
     */
    Duration adjust(Duration duration);

    static Timer identity() {
        return UnaryOperator.<Duration>identity()::apply;
    }
}
