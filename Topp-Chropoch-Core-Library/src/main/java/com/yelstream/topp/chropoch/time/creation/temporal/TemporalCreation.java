package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AllArgsConstructor;

import java.time.Clock;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of")
public class TemporalCreation {
    private final Clock clock;

    public LocalDateCreation localDate() {
        return LocalDateCreation.of(clock);
    }

    public LocalDateTimeCreation localDateTime() {
        return LocalDateTimeCreation.of(clock);
    }

    public LocalTimeCreation localTime() {
        return LocalTimeCreation.of(clock);
    }

    public OffsetDateTimeCreation offsetDateTime() {
        return OffsetDateTimeCreation.of(clock);
    }

    public OffsetTimeCreation offsetTime() {
        return OffsetTimeCreation.of(clock);
    }

    public YearCreation year() {
        return YearCreation.of(clock);
    }

    public YearMonthCreation yearMonth() {
        return YearMonthCreation.of(clock);
    }

    public ZonedDateTimeCreation zonedDateTime() {
        return ZonedDateTimeCreation.of(clock);
    }
}
