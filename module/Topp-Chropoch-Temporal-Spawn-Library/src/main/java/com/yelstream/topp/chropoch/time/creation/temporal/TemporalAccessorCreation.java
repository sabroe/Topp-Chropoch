/*
 * Project: Topp Chropoch
 * GitHub: https://github.com/sabroe/Topp-Chropoch
 *
 * Copyright 2024 Morten Sabroe Mortensen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.AllArgsConstructor;

import java.time.Clock;
import java.util.function.Supplier;

/**
 * Main source of {@link java.time.temporal.TemporalAccessor} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@SuppressWarnings({"java:S6539","unused"})
@AllArgsConstructor(staticName="of")
public class TemporalAccessorCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    private Supplier<Clock> getClockSupplier() {
        return clockSupplier;
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

    public static TemporalAccessorCreation of(Clock clock) {
        return of (()->clock);
    }
}
