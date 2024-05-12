package com.yelstream.topp.chropoch.time.op.util;

import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class SleepOps {
    @FunctionalInterface
    public interface S1 {
        void sleep(long millis) throws InterruptedException;
    }

    @FunctionalInterface
    public interface S2 {
        void sleep(long millis,
                   int nanos) throws InterruptedException;
    }

    @FunctionalInterface
    public interface S3 {
        void sleep(Duration duration) throws InterruptedException;
    }
}
