package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.IsoEra;
import java.util.function.Supplier;

/**
 * Creator of {@link IsoEra} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class IsoEraCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public IsoEra now() {
        Clock clock=clockSupplier.get();
        return LocalDate.now(clock).getEra();
    }

    public IsoEra now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return LocalDate.now(clock.withZone(zone)).getEra();
    }
}
