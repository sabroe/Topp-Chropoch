package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Supplier;

/**
 * Creator of {@link ZonedDateTime} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class ZonedDateTimeCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public ZonedDateTime now() {
        Clock clock=clockSupplier.get();
        return ZonedDateTime.now(clock);
    }

    public ZonedDateTime now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return ZonedDateTime.now(clock.withZone(zone));
    }
}
