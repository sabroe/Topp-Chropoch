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
 * Main source of {@link java.time.temporal.Temporal} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@SuppressWarnings({"unused"})
@AllArgsConstructor(staticName="of")
public class TemporalCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    private Supplier<Clock> getClockSupplier() {
        return clockSupplier;
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

    public static TemporalCreation of(Clock clock) {
        return of (()->clock);
    }
}
