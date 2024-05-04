package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.Year;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link Year} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class YearCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public Year now() {
        Clock clock=clockSupplier.get();
        return Year.now(clock);
    }

    public Year now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return Year.now(clock.withZone(zone));
    }
}
