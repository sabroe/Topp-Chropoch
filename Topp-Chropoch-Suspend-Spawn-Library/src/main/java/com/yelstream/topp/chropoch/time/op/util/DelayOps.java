package com.yelstream.topp.chropoch.time.op.util;

import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class DelayOps {
    @FunctionalInterface
    public interface D1 {
        void delay(long millis) throws InterruptedException;
    }

    @FunctionalInterface
    public interface D2 {
        void delay(long millis,
                   int nanos) throws InterruptedException;
    }

    @FunctionalInterface
    public interface D3 {
        void delay(Duration duration) throws InterruptedException;
    }
}
