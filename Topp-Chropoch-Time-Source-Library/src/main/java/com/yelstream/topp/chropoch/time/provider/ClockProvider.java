package com.yelstream.topp.chropoch.time.provider;

import java.time.Clock;
import java.time.ZoneId;
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

    static ClockProvider of(Clock clock) {
        return ()->clock;
    }

    static ClockProvider of(Supplier<Clock> clockSupplier) {
        return clockSupplier::get;
    }

    static ClockProvider systemDefaultZone() {  //TO-DO: Consider the presence of this!
        return Clock::systemDefaultZone;
    }

    static ClockProvider system(ZoneId zone) {  //TO-DO: Consider the presence of this!
        return ()->Clock.system(zone);
    }

    static ClockProvider systemUTC() {  //TO-DO: Consider the presence of this!
        return Clock::systemUTC;
    }
}
