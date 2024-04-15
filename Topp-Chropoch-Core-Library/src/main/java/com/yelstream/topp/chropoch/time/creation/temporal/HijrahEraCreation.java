package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.HijrahDate;
import java.time.chrono.HijrahEra;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class HijrahEraCreation {
    private final Clock clock;

    public HijrahEra now() {
        return HijrahDate.now(clock).getEra();
    }

    public HijrahEra now(ZoneId zone) {
        return HijrahDate.now(clock.withZone(zone)).getEra();
    }
}
