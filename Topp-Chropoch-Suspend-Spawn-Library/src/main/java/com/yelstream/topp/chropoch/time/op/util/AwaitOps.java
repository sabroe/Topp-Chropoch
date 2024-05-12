package com.yelstream.topp.chropoch.time.op.util;

import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class AwaitOps {

    @FunctionalInterface
    public interface A1 {
        boolean await(long millis) throws InterruptedException;
    }

    @FunctionalInterface
    public interface A2 {
        boolean await(long millis,
                      int nanos) throws InterruptedException;
    }

    @FunctionalInterface
    public interface A3 {
        boolean await(Duration duration) throws InterruptedException;
    }

/*
    @FunctionalInterface
    public interface U1<E extends Exception> {
        void await(long millis) throws E;
    }

    @FunctionalInterface
    public interface U2<E extends Exception> {
        void await(long millis,
                   int nanos) throws E;
    }

    @FunctionalInterface
    public interface U3<E extends Exception> {
        void await(Duration duration) throws E;
    }

    @FunctionalInterface
    public interface BU1<E extends Exception> {
        boolean await(long millis) throws E;
    }

    @FunctionalInterface
    public interface BU2<E extends Exception> {
        boolean await(long millis,
                      int nanos) throws E;
    }

    @FunctionalInterface
    public interface BU3<E extends Exception> {
        boolean await(Duration duration) throws E;
    }
*/
}
