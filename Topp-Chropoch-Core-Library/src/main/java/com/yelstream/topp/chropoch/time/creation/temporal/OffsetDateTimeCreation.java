package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link OffsetDateTime} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class OffsetDateTimeCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public OffsetDateTime now() {
        Clock clock=clockSupplier.get();
        return OffsetDateTime.now(clock);
    }

    public OffsetDateTime now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return OffsetDateTime.now(clock.withZone(zone));
    }
}
