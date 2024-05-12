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
 * Source of delay operations with a fixes delay duration.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-12
 */
@SuppressWarnings("java:S1117")
@lombok.Builder(builderClassName="Builder",toBuilder=true)
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class FixedDelayCreation {
    /**
     * Timer source.
     */
    private final Supplier<Timer> timerSupplier;

    /**
     * Delay duration.
     */
    private final Duration duration;

    private final Adjustment adjustment;

    @SuppressWarnings("java:S115")
    public enum Adjustment {
        OnDemand,
        InAdvance;
    }
    public DelayOp op() {
        return op((SleepOps.S3)Thread::sleep);
    }

    public void sleep() throws InterruptedException {
        op().delay();
    }

    @SuppressWarnings({"java:S1301","java:S6205"})
    public DelayOp op(SleepOps.S1 target) {
        LongSupplier adjustedMillisSupplier=()->{
            Duration adjustedDuration=timerSupplier.get().adjust(duration);
            return adjustedDuration.toMillis();
        };
        DelayOp op=null;
        switch (adjustment) {
            case OnDemand -> {
                op=() -> {
                    long adjustedMillis=adjustedMillisSupplier.getAsLong();
                    target.sleep(adjustedMillis);
                };
            }
            case InAdvance -> {
                long adjustedMillis=adjustedMillisSupplier.getAsLong();
                op=()->target.sleep(adjustedMillis);
            }
        }
        return op;
    }

    public DelayOp op(SleepOps.S2 target) {
        return ()->{
            Duration adjustedDuration=timerSupplier.get().adjust(duration);
            long millis=adjustedDuration.toMillisPart();
            int nanos=adjustedDuration.toNanosPart();
            target.sleep(millis,nanos);
        };
    }

    @SuppressWarnings({"java:S1301","java:S6205","java:S1602"})
    public DelayOp op(SleepOps.S3 target) {
        Supplier<Duration> adjustedDurationSupplier=()->{
            return timerSupplier.get().adjust(duration);
        };
        DelayOp op=null;
        switch (adjustment) {
            case OnDemand -> {
                op=() -> {
                    Duration adjustedDuration=adjustedDurationSupplier.get();
                    target.sleep(adjustedDuration);
                };
            }
            case InAdvance -> {
                Duration adjustedDuration=adjustedDurationSupplier.get();
                op=()->target.sleep(adjustedDuration);
            }
        }
        return op;

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
            FixedDelayCreation creator=this.build();
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
