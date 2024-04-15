package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link OffsetTime} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class OffsetTimeCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public OffsetTime now() {
        Clock clock=clockSupplier.get();
        return OffsetTime.now(clock);
    }

    public OffsetTime now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return OffsetTime.now(clock.withZone(zone));
    }
}
