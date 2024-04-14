package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.MonthDay;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class MonthDayCreation {
    private final Clock clock;

    public MonthDay now() {
        return MonthDay.now(clock);
    }

    public MonthDay now(ZoneId zone) {
        return MonthDay.now(clock.withZone(zone));
    }
}
