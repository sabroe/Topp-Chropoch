/*
 * Project: Topp Chropoch
 * GitHub: https://github.com/sabroe/Topp-Chropoch
 *
 * Copyright 2024 Morten Sabroe Mortensen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
