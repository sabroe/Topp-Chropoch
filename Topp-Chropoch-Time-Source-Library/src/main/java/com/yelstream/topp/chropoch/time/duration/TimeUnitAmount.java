package com.yelstream.topp.chropoch.time.duration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Duration in the form of an amount relative to a {@link TimeUnit} instance.
 * <p>
 *     This is immutable.
 * </p>
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-14
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(staticName="of")
public class TimeUnitAmount {
    /**
     * Duration relative to unit.
     */
    private final long amount;

    /**
     * Unit of time.
     */
    private final TimeUnit unit;

    /**
     * Converts this to a duration.
     * @return Duration.
     */
    public Duration toDuration() {
        return Duration.of(amount,unit.toChronoUnit());
    }

    /**
     * Converts this to an amount with another unit.
     * <p>
     *   Note that this may truncate some of the amount.
     * </p>
     * @param unit Unit to convert amount to.
     * @return Converted amount.
     */
    public TimeUnitAmount toUnit(TimeUnit unit) {
        return of(toDuration(),unit);
    }

    /**
     * Create a new instance.
     * <p>
     *   Note that this may truncate some of the amount.
     * </p>
     * @param duration Duration.
     * @param unit Unit.
     * @return Created instance.
     */
    public static TimeUnitAmount of(Duration duration,
                                    TimeUnit unit) {
        return of(duration.get(unit.toChronoUnit()),unit);
    }

    /**
     * Create a new instance.
     * <p>
     *   Note that this uses nanoseconds and can handle a duration of up to around an absolute value of 292 years.
     * </p>
     * @param duration Duration.
     * @return Created instance.
     */
    public static TimeUnitAmount of(Duration duration) {
        return of(duration.toNanos(),TimeUnit.NANOSECONDS);
    }
}
