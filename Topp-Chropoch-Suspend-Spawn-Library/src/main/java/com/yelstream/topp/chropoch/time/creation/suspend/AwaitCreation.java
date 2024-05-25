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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * Source of await operations.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-10
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class AwaitCreation {
    /**
     * Timer source.
     */
    private final Supplier<Timer> timerSupplier;

    public FixedAwaitCreation.Builder fixed() {
        return FixedAwaitCreation.Builder.create(timerSupplier);
    }

    public VaryingAwaitCreation.Builder varying() {
        return VaryingAwaitCreation.Builder.create(timerSupplier);
    }

    /**
     * Maximum await duration.
     */
//    private final Duration duration;

    public void join(Thread thread) throws InterruptedException {
        thread.join();
    }

    public boolean join(Thread thread,
                        long millis) throws InterruptedException {
        Duration duration=Duration.ofMillis(millis);
        Duration adjustedDuration=timerSupplier.get().adjust(duration);
        long adjustedMillis=adjustedDuration.toMillis();
        thread.join(adjustedMillis);
        return thread.getState()==Thread.State.TERMINATED;
    }

    public boolean join(Thread thread,
                        long millis,
                        int nanos) throws InterruptedException {
        Duration duration=Duration.ofMillis(millis).plusNanos(nanos);
        Duration adjustedDuration=timerSupplier.get().adjust(duration);
        long adjustedMillisPart=adjustedDuration.toMillisPart();
        int adjustedNanosPart=adjustedDuration.toNanosPart();
        thread.join(adjustedMillisPart,adjustedNanosPart);
        return thread.getState()==Thread.State.TERMINATED;
    }

    public boolean join(Thread thread,
                        Duration duration) throws InterruptedException {
        Duration adjustedDuration=timerSupplier.get().adjust(duration);
        return thread.join(adjustedDuration);
    }
}
