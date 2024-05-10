package com.yelstream.topp.chropoch.time.creation.suspend;

import com.yelstream.topp.chropoch.time.provider.Timer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Supplier;

/**
 * Source of delay operations.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-10
 */
@AllArgsConstructor(staticName="of",access= AccessLevel.PACKAGE)
public class DelayCreation {
    /**
     * Timer source.
     */
    private final Supplier<Timer> timerSupplier;

    private Supplier<Timer> getTimerSupplier() {
        return timerSupplier;
    }



}
