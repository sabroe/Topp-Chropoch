package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link LocalDate} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class LocalDateCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public LocalDate now() {
        Clock clock=clockSupplier.get();
        return LocalDate.now(clock);
    }

    public LocalDate now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return LocalDate.now(clock.withZone(zone));
    }
}
