package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.ThaiBuddhistDate;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class ThaiBuddhistDateCreation {
    private final Clock clock;

    public ThaiBuddhistDate now() {
        return ThaiBuddhistDate.now(clock);
    }

    public ThaiBuddhistDate now(ZoneId zone) {
        return ThaiBuddhistDate.now(clock.withZone(zone));
    }
}
