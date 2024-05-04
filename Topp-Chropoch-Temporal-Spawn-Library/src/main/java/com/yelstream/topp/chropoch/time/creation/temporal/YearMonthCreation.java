package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link YearMonth} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class YearMonthCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public YearMonth now() {
        Clock clock=clockSupplier.get();
        return YearMonth.now(clock);
    }

    public YearMonth now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return YearMonth.now(clock.withZone(zone));
    }
}
