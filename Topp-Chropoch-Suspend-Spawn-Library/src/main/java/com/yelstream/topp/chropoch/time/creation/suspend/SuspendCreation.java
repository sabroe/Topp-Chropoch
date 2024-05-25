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

package com.yelstream.topp.chropoch.time.creation.suspend;

import com.yelstream.topp.chropoch.time.transform.Timer;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * Main source of delay and await operations.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-10
 */
@AllArgsConstructor(staticName="of")
public class SuspendCreation {
    /**
     * Timer source.
     */
    private final Supplier<Timer> timerSupplier;

    private Supplier<Timer> getTimerSupplier() {
        return timerSupplier;
    }

    /**
     * Gets access to creating delay operations.
     * @return Creator of delay operations.
     */
    public DelayCreation delay() {
        return DelayCreation.of(getTimerSupplier());
    }

/*
    */
/**
     * Gets access to creating delay operations.
     * @param duration Delay duration.
     * @return Creator of delay operations.
     *//*

    public DelayCreation.Builder delay(Duration duration) {
        return DelayCreation.Builder.create(getTimerSupplier(),duration);
    }
*/

    /**
     * Gets access to creating await operations.
     * @param duration Maximum await duration.
     * @return Creator of await operations.
     */
    public AwaitCreation await() {
        return AwaitCreation.of(getTimerSupplier());
    }

    public void sleep(long millis) throws InterruptedException {
        delay().sleep(millis);
    }

    public void sleep(long millis,
                      int nanos) throws InterruptedException {
        delay().sleep(millis,nanos);
    }

    public void sleep(Duration duration) throws InterruptedException {
        delay().sleep(duration);
    }




    public void join(Thread thread) throws InterruptedException {
        await().join(thread);
    }

    public boolean join(Thread thread,
                        long millis) throws InterruptedException {
        return await().join(thread,millis);
    }

    public boolean join(Thread thread,
                        long millis,
                        int nanos) throws InterruptedException {
        return await().join(thread,millis,nanos);
    }

    public boolean join(Thread thread,
                        Duration duration) throws InterruptedException {
        return await().join(thread,duration);
    }




}
