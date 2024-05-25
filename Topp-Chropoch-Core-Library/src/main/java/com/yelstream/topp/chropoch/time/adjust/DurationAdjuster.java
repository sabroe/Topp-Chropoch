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

package com.yelstream.topp.chropoch.time.adjust;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of")
@lombok.Builder(builderClassName="Builder",toBuilder=true)
public class DurationAdjuster {
    private final double factor;
    private final LongUnaryOperator longAdjustment;
    private final UnaryOperator<Duration> durationAdjustment;

    public long toLong(long value) {
        return longAdjustment.applyAsLong(value);
    }

    public Duration toDuration(Duration duration) {
        return durationAdjustment.apply(duration);
    }

    public Duration toDuration(long amount,
                               ChronoUnit unit) {
        return toDuration(Duration.of(amount,unit));
    }

    public Duration toDuration(long value,
                               TimeUnit unit) {
        return toDuration(value,unit.toChronoUnit());
    }

    public static DurationAdjuster scaleOneToOne() {
        double factor=1.0;
        LongUnaryOperator longAdjustment=LongUnaryOperator.identity();
        UnaryOperator<Duration> durationAdjustment=UnaryOperator.identity();
        return DurationAdjuster.of(factor,longAdjustment,durationAdjustment);
    }

    @SuppressWarnings("java:S1940")
    public static DurationAdjuster scaleUp(int f) {
        if (!(f>=1)) {
            throw new IllegalArgumentException();
        }

        double factor=f;
        LongUnaryOperator longAdjustment=t->t*f;
        UnaryOperator<Duration> durationAdjustment=d->d.multipliedBy(f);
        return DurationAdjuster.of(factor,longAdjustment,durationAdjustment);
    }

    @SuppressWarnings("java:S1940")
    public static DurationAdjuster scaleUp(double f) {
        if (!(f>=1.0)) {
            throw new IllegalArgumentException();
        }

        double factor=f;
        LongUnaryOperator longAdjustment=t->(long)(t*f+0.5);
        UnaryOperator<Duration> durationAdjustment=d->Duration.ofMillis(longAdjustment.applyAsLong(d.toMillis()));
        return DurationAdjuster.of(factor,longAdjustment,durationAdjustment);
    }

    @SuppressWarnings("java:S1940")
    public static DurationAdjuster scaleDown(int f) {
        if (!(f<=1)) {
            throw new IllegalArgumentException();
        }

        double factor=1.0/f;
        LongUnaryOperator longAdjustment=t->(t+f/2)/f;
        UnaryOperator<Duration> durationAdjustment=d->d.dividedBy(f);
        return DurationAdjuster.of(factor,longAdjustment,durationAdjustment);
    }

    @SuppressWarnings("java:S1940")
    public static DurationAdjuster scaleDown(double f) {
        if (!(f<=1.0)) {
            throw new IllegalArgumentException();
        }

        double factor=1.0/f;
        LongUnaryOperator longAdjustment=t->(long)(t/f+0.5);
        UnaryOperator<Duration> durationAdjustment=d->Duration.ofMillis(longAdjustment.applyAsLong(d.toMillis()));
        return DurationAdjuster.of(factor,longAdjustment,durationAdjustment);
    }
}
