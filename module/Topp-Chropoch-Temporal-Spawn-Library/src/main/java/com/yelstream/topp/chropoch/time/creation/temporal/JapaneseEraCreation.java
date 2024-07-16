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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.ZoneId;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.util.function.Supplier;

/**
 * Creator of {@link JapaneseEra} instances.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-04-15
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class JapaneseEraCreation {
    /**
     * Clock source.
     */
    private final Supplier<Clock> clockSupplier;

    public JapaneseEra now() {
        Clock clock=clockSupplier.get();
        return JapaneseDate.now(clock).getEra();
    }

    public JapaneseEra now(ZoneId zone) {
        Clock clock=clockSupplier.get();
        return JapaneseDate.now(clock.withZone(zone)).getEra();
    }
}
