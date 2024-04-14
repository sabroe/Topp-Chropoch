package com.yelstream.topp.chropoch.time.adjust;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@Getter
@AllArgsConstructor(staticName="of")
@lombok.Builder(builderClassName="Builder",toBuilder=true)
public class TimeAcceleration {
    /**
     * Factor with which time is different as compared to the normal reference time.
     * <p>
     * If this is exactly onee then time moves as normal.
     * </p>
     * <p>
     * If this is larger than one then time moves faster than normal.
     * </p>
     * <p>
     * If this is less than one then time moves slower than normal.
     * </p>
     * <p>
     * If this is negative then time moves backwards relative to normal time.
     * </p>
     */
    private final double factor;

    /**
     * Adjustment of durations to reference time.
     * <p>
     *     Example: If {@link #factor} is {@code 2} then durations are adjusted to half their length.
     * </p>
     */
    private final DurationAdjuster durationToReferenceAdjustment;

    /**
     * Adjustment of durations from reference time.
     * <p>
     *     Example: If {@link #factor} is {@code 2} then durations are adjusted to double their length.
     * </p>
     */
    private final DurationAdjuster durationFromReferenceAdjustment;
}
