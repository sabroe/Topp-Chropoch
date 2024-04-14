package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.Year;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class YearCreation {
    private final Clock clock;

    public Year now() {
        return Year.now(clock);
    }

    public Year now(ZoneId zone) {
        return Year.now(clock.withZone(zone));
    }
}
