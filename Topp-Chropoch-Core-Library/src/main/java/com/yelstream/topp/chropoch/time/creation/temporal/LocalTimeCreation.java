package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class LocalTimeCreation {
    public final Clock clock;

    public LocalTime now() {
        return LocalTime.now(clock);
    }

    public LocalTime now(ZoneId zone) {
        return LocalTime.now(clock.withZone(zone));
    }
}
