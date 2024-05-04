package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link LocalDateTime} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class LocalDateTimeCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public LocalDateTime now() {
        Clock clock=clockSupplier.get();
        return LocalDateTime.now(clock);
    }

    public LocalDateTime now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return LocalDateTime.now(clock.withZone(zone));
    }
}
