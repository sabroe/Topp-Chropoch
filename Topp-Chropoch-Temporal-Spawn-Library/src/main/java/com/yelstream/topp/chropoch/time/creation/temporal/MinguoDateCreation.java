package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.MinguoDate;
import java.util.function.Supplier;

/**
 * Creator of {@link MinguoDate} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class MinguoDateCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public MinguoDate now() {
        Clock clock=clockSupplier.get();
        return MinguoDate.now(clock);
    }

    public MinguoDate now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return MinguoDate.now(clock.withZone(zone));
    }
}
