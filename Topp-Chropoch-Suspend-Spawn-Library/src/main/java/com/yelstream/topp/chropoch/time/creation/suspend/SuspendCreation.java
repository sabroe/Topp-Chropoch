package com.yelstream.topp.chropoch.time.creation.suspend;

import com.yelstream.topp.chropoch.time.transform.Timer;
import lombok.AllArgsConstructor;

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

    /**
     * Gets access to creating await operations.
     * @return Creator of await operations.
     */
    public AwaitCreation await() {
        return AwaitCreation.of(getTimerSupplier());
    }
}
