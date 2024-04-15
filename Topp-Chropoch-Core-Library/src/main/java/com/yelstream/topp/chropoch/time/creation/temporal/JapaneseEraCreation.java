package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class JapaneseEraCreation {
    private final Clock clock;

    public JapaneseEra now() {
        return JapaneseDate.now(clock).getEra();
    }

    public JapaneseEra now(ZoneId zone) {
        return JapaneseDate.now(clock.withZone(zone)).getEra();
    }
}
