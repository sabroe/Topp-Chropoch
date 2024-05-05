package com.yelstream.topp.chropoch.time.provider;

import java.util.function.Supplier;

/**
 * Provider of a {@link Timer} instance.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-05
 */
@FunctionalInterface
public interface TimerProvider {
    /**
     * Gets the provided timer instance.
     * @return Timer.
     */
    Timer getTimer();

    default Supplier<Timer> supplier() {
        return this::getTimer;
    }
}
