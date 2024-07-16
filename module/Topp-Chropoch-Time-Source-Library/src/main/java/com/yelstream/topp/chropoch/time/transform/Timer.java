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

package com.yelstream.topp.chropoch.time.transform;

import java.time.Duration;
import java.util.function.LongUnaryOperator;
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

    /**
     * Transforms a duration from a source timeline to a target timeline.
     * @param nanos Duration relative to the source timeline.
     *              Unit is nanoseconds.
     *              This can hold up to in the order of 292 years.
     * @return Duration relative to the target timeline.
     *         Unit is nanoseconds.
     *         This can hold up to in the order of 292 years.
     */
    default long adjustNano(long nanos) {
        return adjust(Duration.ofNanos(nanos)).toNanos();
    }

    default UnaryOperator<Duration> toDurationOperator() {
        return this::adjust;
    }

    default LongUnaryOperator toNanoOperator() {
        return this::adjustNano;
    }

    private static Timer of(UnaryOperator<Duration> durationTransformation,
                            LongUnaryOperator nanoDurationTransformation) {
        return new Timer() {
            @Override
            public Duration adjust(Duration duration) {
                return durationTransformation.apply(duration);
            }

            @Override
            public long adjustNano(long nanos) {
                return nanoDurationTransformation.applyAsLong(nanos);
            }
        };
    }

    static Timer of(UnaryOperator<Duration> transformation) {
        return of(transformation,
                nanos->transformation.apply(Duration.ofNanos(nanos)).toNanos());
    }

    static Timer of(LongUnaryOperator transformation) {
        return of(duration->Duration.ofNanos(transformation.applyAsLong(duration.toNanos())),
                  transformation);
    }

    /**
     * Gets the identity timer
     * @return Identity timer.
     */
    static Timer identity() {
        return of(UnaryOperator.identity(),
                  LongUnaryOperator.identity());
    }
}
