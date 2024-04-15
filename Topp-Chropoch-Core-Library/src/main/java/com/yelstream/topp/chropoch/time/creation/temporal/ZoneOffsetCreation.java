package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class ZoneOffsetCreation {
    private final Clock clock;

    public ZoneOffset now() {
        return clock.getZone().getRules().getOffset(Instant.now(clock));
    }

    public ZoneOffset now(ZoneId zone) {
        return clock.getZone().getRules().getOffset(Instant.now(clock.withZone(zone)));
    }
}
