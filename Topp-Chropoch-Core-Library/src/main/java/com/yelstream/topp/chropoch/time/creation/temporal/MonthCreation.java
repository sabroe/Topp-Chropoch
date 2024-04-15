package com.yelstream.topp.chropoch.time.creation.temporal;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
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
public class MonthCreation {
    private final Clock clock;

    public Month now() {
        return LocalDate.now(clock).getMonth();
    }

    public Month now(ZoneId zone) {
        return LocalDate.now(clock.withZone(zone)).getMonth();
    }
}
