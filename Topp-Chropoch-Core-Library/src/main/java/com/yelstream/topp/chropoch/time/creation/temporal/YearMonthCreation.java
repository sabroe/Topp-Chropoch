package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.YearMonth;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class YearMonthCreation {
    private final Clock clock;

    public YearMonth now() {
        return YearMonth.now(clock);
    }

    public YearMonth now(ZoneId zone) {
        return YearMonth.now(clock.withZone(zone));
    }
}
