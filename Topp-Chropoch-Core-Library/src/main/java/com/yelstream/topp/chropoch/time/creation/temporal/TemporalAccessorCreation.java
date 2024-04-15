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

    public DayOfWeekCreation dayOfWeek() {  //TO-DO: Consider the existence of this!
        return DayOfWeekCreation.of(clock);
    }

    public HijrahDateCreation hijrahDate() {
        return HijrahDateCreation.of(clock);
    }

    public HijrahEraCreation hijrahEra() {  //TO-DO: Consider the existence of this!
        return HijrahEraCreation.of(clock);
    }

    public InstantCreation instant() {
        return InstantCreation.of(clock);
    }

    public IsoEraCreation isoEra() {  //TO-DO: Consider the existence of this!
        return IsoEraCreation.of(clock);
    }

    public JapaneseDateCreation japaneseDate() {
        return JapaneseDateCreation.of(clock);
    }

    public JapaneseEraCreation japaneseEra() {  //TO-DO: Consider the existence of this!
        return JapaneseEraCreation.of(clock);
    }

    public LocalDateCreation localDate() {
        return LocalDateCreation.of(clock);
    }

    public LocalDateTimeCreation localDateTime() {
        return LocalDateTimeCreation.of(clock);
    }

    public LocalTimeCreation localTime() {
        return LocalTimeCreation.of(clock);
    }

    public MinguoDateCreation minguoDate() {
        return MinguoDateCreation.of(clock);
    }

    public MinguoEraCreation minguoEra() {  //TO-DO: Consider the existence of this!
        return MinguoEraCreation.of(clock);
    }

    public MonthCreation month() {  //TO-DO: Consider the existence of this!
        return MonthCreation.of(clock);
    }

    public MonthDayCreation monthDay() {
        return MonthDayCreation.of(clock);
    }

    public OffsetDateTimeCreation offsetDateTime() {
        return OffsetDateTimeCreation.of(clock);
    }

    public OffsetTimeCreation offsetTime() {
        return OffsetTimeCreation.of(clock);
    }

    public ThaiBuddhistDateCreation thaiBuddhistDate() {
        return ThaiBuddhistDateCreation.of(clock);
    }

    public ThaiBuddhistEraCreation thaiBuddhistEra() {  //TO-DO: Consider the existence of this!
        return ThaiBuddhistEraCreation.of(clock);
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

    public ZoneOffsetCreation zoneOffset() {  //TO-DO: Consider the existence of this!
        return ZoneOffsetCreation.of(clock);
    }
}
