package com.yelstream.topp.chropoch.time.creation.suspend;


import com.yelstream.topp.chropoch.time.op.DelayOp;
import com.yelstream.topp.chropoch.time.op.util.SleepOps;
import com.yelstream.topp.chropoch.time.transform.Timer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * Source of await operations with a fixes delay duration.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-12
 */
@SuppressWarnings("java:S1117")
@lombok.Builder(builderClassName="Builder",toBuilder=true)
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class FixedAwaitCreation {
    /**
     * Timer source.
     */
    private final Supplier<Timer> timerSupplier;

    /**
     * Delay duration.
     */
    private final Duration duration;

    public DelayOp op() {
        return null;
    }




    public static class Builder {
        @Setter(AccessLevel.PRIVATE)
        @Getter(AccessLevel.PRIVATE)
        private Supplier<Timer> timerSupplier;

        private Duration duration;

        public static Builder create(Supplier<Timer> timerSupplier) {
            Builder builder=new Builder();
            builder.timerSupplier=timerSupplier;
            return builder;
        }

        public DelayOp op() {
            FixedAwaitCreation creator=this.build();
            return creator.op();
        }

        public Builder duration(Duration duration) {
            this.duration=duration;
            return this;
        }

        public Builder duration(long millis) {
            duration=Duration.ofMillis(millis);
            return this;
        }

        public Builder duration(long millis,
                                int nanos) {
            duration=Duration.ofMillis(millis).plusNanos(nanos);
            return this;
        }
    }
}
