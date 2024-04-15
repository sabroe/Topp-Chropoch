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
public class TemporalCreation {  //TO-DO: Consider relationship between TemporalAccessorCreation and TemporalCreation; Temporal inherits TemporalAccessor!
    private final Clock clock;

    public HijrahDateCreation hijrahDate() {
        return HijrahDateCreation.of(clock);
    }

    public InstantCreation instant() {
        return InstantCreation.of(clock);
    }

    public JapaneseDateCreation japaneseDate() {
        return JapaneseDateCreation.of(clock);
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

    public OffsetDateTimeCreation offsetDateTime() {
        return OffsetDateTimeCreation.of(clock);
    }

    public OffsetTimeCreation offsetTime() {
        return OffsetTimeCreation.of(clock);
    }

    public ThaiBuddhistDateCreation thaiBuddhistDate() {
        return ThaiBuddhistDateCreation.of(clock);
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
