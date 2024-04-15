package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.MinguoDate;
import java.time.chrono.MinguoEra;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class MinguoEraCreation {
    private final Clock clock;

    public MinguoEra now() {
        return MinguoDate.now(clock).getEra();
    }

    public MinguoEra now(ZoneId zone) {
        return MinguoDate.now(clock.withZone(zone)).getEra();
    }
}
