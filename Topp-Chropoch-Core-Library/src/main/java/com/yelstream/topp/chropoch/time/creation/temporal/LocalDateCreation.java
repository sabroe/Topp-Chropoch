package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class LocalDateCreation {
    private final Clock clock;

    public LocalDate now() {
        return LocalDate.now(clock);
    }

    public LocalDate now(ZoneId zone) {
        return LocalDate.now(clock.withZone(zone));
    }
}
