package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link LocalTime} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class LocalTimeCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public LocalTime now() {
        Clock clock=clockSupplier.get();
        return LocalTime.now(clock);
    }

    public LocalTime now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return LocalTime.now(clock.withZone(zone));
    }
}
