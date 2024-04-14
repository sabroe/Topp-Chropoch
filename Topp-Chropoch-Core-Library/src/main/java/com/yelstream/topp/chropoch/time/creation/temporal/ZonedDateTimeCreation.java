package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class ZonedDateTimeCreation {
    private final Clock clock;

    public ZonedDateTime now() {
        return ZonedDateTime.now(clock);
    }

    public ZonedDateTime now(ZoneId zone) {
        return ZonedDateTime.now(clock.withZone(zone));
    }
}
