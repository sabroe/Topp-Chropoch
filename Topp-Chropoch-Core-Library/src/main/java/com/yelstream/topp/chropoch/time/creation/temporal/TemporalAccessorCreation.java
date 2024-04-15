package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AllArgsConstructor;

import java.time.Clock;
import java.util.function.Supplier;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@SuppressWarnings({"java:S6539","unused"})
@AllArgsConstructor(staticName="of")
public class TemporalAccessorCreation {
    private final Clock clock;

    private Supplier<Clock> getClockSupplier() {
        return ()->clock;  //TO-DO: Consider this; is static to begin with!
    }

    public DayOfWeekCreation dayOfWeek() {  //TO-DO: Consider the existence of this!
        return DayOfWeekCreation.of(getClockSupplier());
    }

    public HijrahDateCreation hijrahDate() {
        return HijrahDateCreation.of(getClockSupplier());
    }

    public HijrahEraCreation hijrahEra() {  //TO-DO: Consider the existence of this!
        return HijrahEraCreation.of(getClockSupplier());
    }

    public InstantCreation instant() {
        return InstantCreation.of(getClockSupplier());
    }

    public IsoEraCreation isoEra() {  //TO-DO: Consider the existence of this!
        return IsoEraCreation.of(getClockSupplier());
    }

    public JapaneseDateCreation japaneseDate() {
        return JapaneseDateCreation.of(getClockSupplier());
    }

    public JapaneseEraCreation japaneseEra() {  //TO-DO: Consider the existence of this!
        return JapaneseEraCreation.of(getClockSupplier());
    }

    public LocalDateCreation localDate() {
        return LocalDateCreation.of(getClockSupplier());
    }

    public LocalDateTimeCreation localDateTime() {
        return LocalDateTimeCreation.of(getClockSupplier());
    }

    public LocalTimeCreation localTime() {
        return LocalTimeCreation.of(getClockSupplier());
    }

    public MinguoDateCreation minguoDate() {
        return MinguoDateCreation.of(getClockSupplier());
    }

    public MinguoEraCreation minguoEra() {  //TO-DO: Consider the existence of this!
        return MinguoEraCreation.of(getClockSupplier());
    }

    public MonthCreation month() {  //TO-DO: Consider the existence of this!
        return MonthCreation.of(getClockSupplier());
    }

    public MonthDayCreation monthDay() {
        return MonthDayCreation.of(getClockSupplier());
    }

    public OffsetDateTimeCreation offsetDateTime() {
        return OffsetDateTimeCreation.of(getClockSupplier());
    }

    public OffsetTimeCreation offsetTime() {
        return OffsetTimeCreation.of(getClockSupplier());
    }

    public ThaiBuddhistDateCreation thaiBuddhistDate() {
        return ThaiBuddhistDateCreation.of(getClockSupplier());
    }

    public ThaiBuddhistEraCreation thaiBuddhistEra() {  //TO-DO: Consider the existence of this!
        return ThaiBuddhistEraCreation.of(getClockSupplier());
    }

    public YearCreation year() {
        return YearCreation.of(getClockSupplier());
    }

    public YearMonthCreation yearMonth() {
        return YearMonthCreation.of(getClockSupplier());
    }

    public ZonedDateTimeCreation zonedDateTime() {
        return ZonedDateTimeCreation.of(getClockSupplier());
    }

    public ZoneOffsetCreation zoneOffset() {  //TO-DO: Consider the existence of this!
        return ZoneOffsetCreation.of(getClockSupplier());
    }
}
