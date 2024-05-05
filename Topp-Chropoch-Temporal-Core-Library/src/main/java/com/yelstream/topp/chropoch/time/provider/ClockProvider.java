package com.yelstream.topp.chropoch.time.provider;

import java.time.Clock;
import java.util.function.Supplier;

/**
 * Provider of a {@link Clock} instance.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-24
 */
@FunctionalInterface
public interface ClockProvider {
    /**
     * Gets the provided clock instance.
     * @return Clock.
     */
    Clock getClock();

    default Supplier<Clock> supplier() {
        return this::getClock;
    }
}
