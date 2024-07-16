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
