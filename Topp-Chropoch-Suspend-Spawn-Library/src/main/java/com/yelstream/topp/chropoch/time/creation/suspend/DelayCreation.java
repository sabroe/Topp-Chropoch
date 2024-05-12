package com.yelstream.topp.chropoch.time.creation.suspend;

import com.yelstream.topp.chropoch.time.transform.Timer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * Source of delay operations.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-10
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class DelayCreation {
    /**
     * Timer source.
     */
    private final Supplier<Timer> timerSupplier;

    public FixedDelayCreation.Builder fixed() {
        return FixedDelayCreation.Builder.create(timerSupplier);
    }

    public VaryingDelayCreation.Builder varying() {
        return VaryingDelayCreation.Builder.create(timerSupplier);
    }


    public void sleep(long millis) throws InterruptedException {
        Duration duration=Duration.ofMillis(millis);
        Duration adjustedDuration=timerSupplier.get().adjust(duration);
        long adjustedMillis=adjustedDuration.toMillis();
        Thread.sleep(adjustedMillis);
    }

    public void sleep(long millis,
                      int nanos) throws InterruptedException {
        Duration duration=Duration.ofMillis(millis).plusNanos(nanos);
        Duration adjustedDuration=timerSupplier.get().adjust(duration);
        long adjustedMillisPart=adjustedDuration.toMillisPart();
        int adjustedNanosPart=adjustedDuration.toNanosPart();
        Thread.sleep(adjustedMillisPart,adjustedNanosPart);
    }

    public void sleep(Duration duration) throws InterruptedException {
        Duration adjustedDuration=timerSupplier.get().adjust(duration);
        Thread.sleep(adjustedDuration);
    }

}
