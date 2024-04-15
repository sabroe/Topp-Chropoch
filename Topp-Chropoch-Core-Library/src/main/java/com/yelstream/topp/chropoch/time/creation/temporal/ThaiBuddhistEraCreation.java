package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.ThaiBuddhistDate;
import java.time.chrono.ThaiBuddhistEra;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class ThaiBuddhistEraCreation {
    private final Clock clock;

    public ThaiBuddhistEra now() {
        return ThaiBuddhistDate.now(clock).getEra();
    }

    public ThaiBuddhistEra now(ZoneId zone) {
        return ThaiBuddhistDate.now(clock.withZone(zone)).getEra();
    }
}
