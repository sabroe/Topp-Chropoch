package com.yelstream.topp.chropoch.time.chronicle.util;

import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class Await {

    @UtilityClass
    public static class S {
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

    @UtilityClass
    public static class J {
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

    @UtilityClass
    public static class U {
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
    }

}
