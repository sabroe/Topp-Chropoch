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

package com.yelstream.topp.chropoch.time.creation.suspend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureAwaitCreation {

    @Getter
    @AllArgsConstructor
    static class RemapValue {
        private final long timeout;
        private final TimeUnit unit;
    }

    interface Remap {
        RemapValue remap(long timeout, TimeUnit unit);
    }

    interface Target<X> {
        X hit(long timeout, TimeUnit unit);
    }

    interface Remap2 {
        <X> X remap(long timeout, TimeUnit unit, Target<X> target);
    }


    public <X> X remap(long timeout, TimeUnit unit, Target<X> target) {
        long newTimeout=timeout;
        TimeUnit newUnit=unit;
        return target.hit(newTimeout,newUnit);
    }


    void xxx() {

        CompletableFuture<String> cf = null;

        Remap r=null;
        RemapValue v=r.remap(1000L,TimeUnit.MINUTES);
        CompletableFuture<String> x=cf.completeOnTimeout("XXX",v.getTimeout(),v.getUnit());

        Remap2 r2=null;
        CompletableFuture<String> x2=r2.remap(1000L,TimeUnit.MINUTES,(timeout,unit)->cf.completeOnTimeout("XXX",timeout,unit));


    }

    /*

            CompletableFuture<String> cf = null;

            CompletableFuture<T> completeOnTimeout(T value,
            long timeout,
            TimeUnit unit)


            Executor delayedExecutor(long delay,
            TimeUnit unit)


            Executor delayedExecutor(long delay,
            TimeUnit unit,
            Executor executor)


            public T get(long timeout,
            TimeUnit unit)
      throws InterruptedException,
                ExecutionException,
                TimeoutException



            CompletableFuture<T> orTimeout(long timeout,
            TimeUnit unit)

     */

}
