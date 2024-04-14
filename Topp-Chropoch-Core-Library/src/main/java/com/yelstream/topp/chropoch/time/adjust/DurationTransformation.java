package com.yelstream.topp.chropoch.time.adjust;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of"/*,access=AccessLevel.PACKAGE*/)
public class DurationTransformation {
    private final Clock clock;

    private TimeAcceleration accelerator;

    public Duration scale(Duration duration) {
//        duration.
        return null;
    }

    public long scale(long value, TimeUnit unit) {
        return 0;
    }

    @FunctionalInterface
    interface LongTimeTarget {
        void apply(long value, TimeUnit unit);
    }

    public void scale(long timeValue, TimeUnit timeUnit, LongTimeTarget target) {

    }
}
