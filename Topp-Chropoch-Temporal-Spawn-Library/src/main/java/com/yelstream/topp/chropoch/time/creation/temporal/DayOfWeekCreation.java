package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link DayOfWeek} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class DayOfWeekCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public DayOfWeek now() {
        Clock clock=clockSupplier.get();
        return LocalDate.now(clock).getDayOfWeek();
    }

    public DayOfWeek now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return LocalDate.now(clock.withZone(zone)).getDayOfWeek();
    }
}
