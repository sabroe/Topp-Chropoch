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

import com.yelstream.topp.chropoch.time.op.DelayOp;
import com.yelstream.topp.chropoch.time.op.util.SleepOps;
import com.yelstream.topp.chropoch.time.transform.Timer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * Source of await operations with a varying delay duration.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-12
 */
@SuppressWarnings("java:S1117")
@lombok.Builder(builderClassName="Builder",toBuilder=true)
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class VaryingAwaitCreation {
    /**
     * Timer source.
     */
    private final Supplier<Timer> timerSupplier;

    /**
     * Delay duration.
     */
    private final Duration duration;


    public DelayOp op() {
        return op((SleepOps.S3)Thread::sleep);
    }

    public void sleep() throws InterruptedException {
        op().delay();
    }

    public DelayOp op(SleepOps.S1 target) {
        return ()->{
            Duration adjustedDuration=timerSupplier.get().adjust(duration);
            long millis=adjustedDuration.toMillis();
            target.sleep(millis);
        };
    }

    public DelayOp op(SleepOps.S2 target) {
        return ()->{
            Duration adjustedDuration=timerSupplier.get().adjust(duration);
            long millis=adjustedDuration.toMillisPart();
            int nanos=adjustedDuration.toNanosPart();
            target.sleep(millis,nanos);
        };
    }

    public DelayOp op(SleepOps.S3 target) {
        return ()->{
            Duration adjustedDuration=timerSupplier.get().adjust(duration);
            target.sleep(adjustedDuration);
        };
    }

    public static class Builder {
        @Setter(AccessLevel.PRIVATE)
        @Getter(AccessLevel.PRIVATE)
        private Supplier<Timer> timerSupplier;

        public static Builder create(Supplier<Timer> timerSupplier) {
            Builder builder=new Builder();
            builder.timerSupplier=timerSupplier;
            return builder;
        }

        public DelayOp op() {
            VaryingAwaitCreation creator=this.build();
            return creator.op();
        }
    }
}
