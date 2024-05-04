package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Creator of {@link MonthDay} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class MonthDayCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public MonthDay now() {
        Clock clock=clockSupplier.get();
        return MonthDay.now(clock);
    }

    public MonthDay now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return MonthDay.now(clock.withZone(zone));
    }
}
