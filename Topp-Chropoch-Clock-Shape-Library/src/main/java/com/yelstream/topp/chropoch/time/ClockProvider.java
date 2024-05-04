package com.yelstream.topp.chropoch.time;

import java.time.Clock;

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
}
