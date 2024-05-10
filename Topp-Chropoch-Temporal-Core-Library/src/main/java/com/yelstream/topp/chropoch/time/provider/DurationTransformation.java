package com.yelstream.topp.chropoch.time.provider;

import java.time.Duration;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

@FunctionalInterface
public interface DurationTransformation {

    Duration transform(Duration duration);

    default long transformNano(long nanos) {
        return transform(Duration.ofNanos(nanos)).toNanos();
    }

    static DurationTransformation of(UnaryOperator<Duration> transformation) {
        return transformation::apply;
    }

    static DurationTransformation of(LongUnaryOperator transformation) {
        return duration->Duration.ofNanos(transformation.applyAsLong(duration.toNanos()));
    }

    static DurationTransformation identity() {
        return UnaryOperator.<Duration>identity()::apply;
    }
}
