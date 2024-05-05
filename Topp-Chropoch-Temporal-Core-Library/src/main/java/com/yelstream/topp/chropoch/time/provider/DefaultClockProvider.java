package com.yelstream.topp.chropoch.time.provider;

import java.time.Clock;

/**
 * Provider of a {@link Clock} instance.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-24
 */
public class DefaultClockProvider implements ClockProvider {
    @Override
    public Clock getClock() {
        return Clock.systemDefaultZone();
    }
}
