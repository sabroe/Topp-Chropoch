package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.IsoEra;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class IsoEraCreation {
    private final Clock clock;

    public IsoEra now() {
        return LocalDate.now(clock).getEra();
    }

    public IsoEra now(ZoneId zone) {
        return LocalDate.now(clock.withZone(zone)).getEra();
    }
}