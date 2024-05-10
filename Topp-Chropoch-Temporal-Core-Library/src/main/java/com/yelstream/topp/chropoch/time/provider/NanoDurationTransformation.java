package com.yelstream.topp.chropoch.time.provider;

import java.time.Duration;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public interface NanoDurationTransformation {
    long transformNano(long duration);

    default Duration transform(Duration duration) {
        return Duration.ofNanos(transformNano(duration.toNanos()));
    }

    static NanoDurationTransformation of(LongUnaryOperator transformation) {
        return transformation::applyAsLong;
    }

    static NanoDurationTransformation of(UnaryOperator<Duration> transformation) {
        return nanos->transformation.apply(Duration.ofNanos(nanos)).toNanos();
    }

    static NanoDurationTransformation identity() {
        return LongUnaryOperator.identity()::applyAsLong;
    }
}
