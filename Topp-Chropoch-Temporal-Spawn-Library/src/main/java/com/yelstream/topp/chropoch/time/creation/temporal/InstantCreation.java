package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.Instant;
import java.util.function.Supplier;

/**
 * Creator of {@link Instant} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class InstantCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public Instant now() {
        Clock clock=clockSupplier.get();
        return Instant.now(clock);
    }
}
