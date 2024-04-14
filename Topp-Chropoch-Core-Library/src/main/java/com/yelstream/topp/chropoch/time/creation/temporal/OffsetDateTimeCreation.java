package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class OffsetDateTimeCreation {
    private final Clock clock;

    public OffsetDateTime now() {
        return OffsetDateTime.now(clock);
    }

    public OffsetDateTime now(ZoneId zone) {
        return OffsetDateTime.now(clock.withZone(zone));
    }
}