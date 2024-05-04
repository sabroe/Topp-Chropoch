package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.util.function.Supplier;

/**
 * Creator of {@link JapaneseEra} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class JapaneseEraCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public JapaneseEra now() {
        Clock clock=clockSupplier.get();
        return JapaneseDate.now(clock).getEra();
    }

    public JapaneseEra now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return JapaneseDate.now(clock.withZone(zone)).getEra();
    }
}
