package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.OffsetTime;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class OffsetTimeCreation {
    private final Clock clock;

    public OffsetTime now() {
        return OffsetTime.now(clock);
    }

    public OffsetTime now(ZoneId zone) {
        return OffsetTime.now(clock.withZone(zone));
    }
}
