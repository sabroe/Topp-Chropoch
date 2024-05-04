package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link Month} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class MonthCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public Month now() {
        Clock clock=clockSupplier.get();
        return LocalDate.now(clock).getMonth();
    }

    public Month now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return LocalDate.now(clock.withZone(zone)).getMonth();
    }
}
