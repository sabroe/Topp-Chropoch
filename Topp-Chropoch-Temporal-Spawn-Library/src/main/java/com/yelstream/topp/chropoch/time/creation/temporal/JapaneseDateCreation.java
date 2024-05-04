package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.JapaneseDate;
import java.util.function.Supplier;

/**
 * Creator of {@link JapaneseDate} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class JapaneseDateCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public JapaneseDate now() {
        Clock clock=clockSupplier.get();
        return JapaneseDate.now(clock);
    }

    public JapaneseDate now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return JapaneseDate.now(clock.withZone(zone));
    }
}
