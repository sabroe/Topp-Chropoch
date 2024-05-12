package com.yelstream.topp.chropoch.time.op.util;


import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class JoinOps {
    @FunctionalInterface
    public interface J1 {
        void join(long millis) throws InterruptedException;
    }

    @FunctionalInterface
    public interface J2 {
        void join(long millis,
                  int nanos) throws InterruptedException;
    }

    @FunctionalInterface
    public interface J3 {
        void join() throws InterruptedException;  //No pause!
    }

    @FunctionalInterface
    public interface J4 {
        boolean join(Duration duration) throws InterruptedException;
    }
}
