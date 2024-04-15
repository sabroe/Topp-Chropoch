package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.function.Supplier;

/**
 * Creator of {@link ZoneOffset} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class ZoneOffsetCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public ZoneOffset now() {
        Clock clock=clockSupplier.get();
        return clock.getZone().getRules().getOffset(Instant.now(clock));
    }

    public ZoneOffset now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return clock.getZone().getRules().getOffset(Instant.now(clock.withZone(zone)));
    }
}
