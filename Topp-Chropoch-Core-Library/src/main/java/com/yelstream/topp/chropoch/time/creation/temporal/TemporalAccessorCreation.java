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
public class TemporalAccessorCreation {  //TO-DO: Consider relationship between TemporalAccessorCreation and TemporalCreation; Temporal inherits TemporalAccessor!
    private final Clock clock;

    //DayOfWeek?

    public InstantCreation instant() {
        return InstantCreation.of(clock);
    }

    //IsoEra?

    public LocalDateCreation localDate() {
        return LocalDateCreation.of(clock);
    }

    public LocalDateTimeCreation localDateTime() {
        return LocalDateTimeCreation.of(clock);
    }

    public LocalTimeCreation localTime() {
        return LocalTimeCreation.of(clock);
    }

    //Month?

    public MonthDayCreation monthDay() {
        return MonthDayCreation.of(clock);
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

    //ZoneOffset?
}
