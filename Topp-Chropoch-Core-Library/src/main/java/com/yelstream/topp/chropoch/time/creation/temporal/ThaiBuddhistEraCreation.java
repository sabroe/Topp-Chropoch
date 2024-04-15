package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.ThaiBuddhistDate;
import java.time.chrono.ThaiBuddhistEra;
import java.util.function.Supplier;

/**
 * Creator of {@link ThaiBuddhistEra} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class ThaiBuddhistEraCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public ThaiBuddhistEra now() {
        Clock clock=clockSupplier.get();
        return ThaiBuddhistDate.now(clock).getEra();
    }

    public ThaiBuddhistEra now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return ThaiBuddhistDate.now(clock.withZone(zone)).getEra();
    }
}
