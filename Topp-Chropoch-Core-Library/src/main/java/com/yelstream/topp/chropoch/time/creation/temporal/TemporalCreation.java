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
@SuppressWarnings({"unused"})
@AllArgsConstructor(staticName="of")
public class TemporalCreation {
    private final Clock clock;

    private Supplier<Clock> getClockSupplier() {
        return ()->clock;  //TO-DO: Consider this; is static to begin with!
    }

    public HijrahDateCreation hijrahDate() {
        return HijrahDateCreation.of(getClockSupplier());
    }

    public InstantCreation instant() {
        return InstantCreation.of(getClockSupplier());
    }

    public JapaneseDateCreation japaneseDate() {
        return JapaneseDateCreation.of(getClockSupplier());
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

    public OffsetDateTimeCreation offsetDateTime() {
        return OffsetDateTimeCreation.of(getClockSupplier());
    }

    public OffsetTimeCreation offsetTime() {
        return OffsetTimeCreation.of(getClockSupplier());
    }

    public ThaiBuddhistDateCreation thaiBuddhistDate() {
        return ThaiBuddhistDateCreation.of(getClockSupplier());
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

    public static TemporalCreation of() {  //TO-DO: Find 'Clock' instance implicitly!?
        throw new IllegalStateException("Not implemented ... Yet!");
    }
}
