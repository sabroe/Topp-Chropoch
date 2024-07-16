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

package com.yelstream.topp.chropoch.time.provider;

import java.time.Clock;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Provider of a {@link Clock} instance.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-24
 */
@FunctionalInterface
public interface ClockProvider {
    /**
     * Gets the provided clock instance.
     * @return Clock.
     */
    Clock getClock();

    default Supplier<Clock> supplier() {
        return this::getClock;
    }

    static ClockProvider of(Clock clock) {
        return ()->clock;
    }

    static ClockProvider of(Supplier<Clock> clockSupplier) {
        return clockSupplier::get;
    }

    static ClockProvider systemDefaultZone() {  //TO-DO: Consider the presence of this!
        return Clock::systemDefaultZone;
    }

    static ClockProvider system(ZoneId zone) {  //TO-DO: Consider the presence of this!
        return ()->Clock.system(zone);
    }

    static ClockProvider systemUTC() {  //TO-DO: Consider the presence of this!
        return Clock::systemUTC;
    }
}
