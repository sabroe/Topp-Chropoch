package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class DayOfWeekCreation {
    private final Clock clock;

    public DayOfWeek now() {
        return LocalDate.now(clock).getDayOfWeek();
    }

    public DayOfWeek now(ZoneId zone) {
        return LocalDate.now(clock.withZone(zone)).getDayOfWeek();
    }
}
