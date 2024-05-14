package com.yelstream.topp.chropoch.time.duration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Duration in the form of an amount relative to a {@link TemporalUnit} instance.
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
public class TemporalUnitAmount {
    /**
     * Duration relative to unit.
     */
    private final long amount;

    /**
     * Unit of time.
     */
    private final TemporalUnit unit;

    /**
     * Converts this to a duration.
     * @return Duration.
     */
    public Duration toDuration() {
        return Duration.of(amount,unit);
    }

    /**
     * Converts this to an amount with another unit.
     * <p>
     *   Note that this may truncate some of the amount.
     * </p>
     * @param unit Unit to convert amount to.
     * @return Converted amount.
     */
    public TemporalUnitAmount toUnit(TemporalUnit unit) {
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
    public static TemporalUnitAmount of(Duration duration,
                                        TemporalUnit unit) {
        return of(duration.get(unit),unit);
    }

    /**
     * Create a new instance.
     * <p>
     *   Note that this uses nanoseconds and can handle a duration of up to around an absolute value of 292 years.
     * </p>
     * @param duration Duration.
     * @return Created instance.
     */
    public static TemporalUnitAmount of(Duration duration) {
        return of(duration.toNanos(),ChronoUnit.NANOS);
    }
}
