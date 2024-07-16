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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;

/**
 * Test of {@code com.yelstream.topp.chropoch.time.creation.TemporalCreation}.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-04
 */
@Slf4j
class TemporalCreationTest {
    /**
     * Test of {@link TemporalCreation#of(Clock)}.
     */
    @Test
    void ofClock() {
        Instant now=Instant.now();
        ZoneId zoneId=ZoneId.systemDefault();
        Clock clock= Clock.fixed(now,zoneId);
        TemporalCreation tc=TemporalCreation.of(clock);
        Assertions.assertNotNull(tc);
    }

    /**
     * Test of {@link TemporalCreation#year()}.
     */
    @Test
    void year() {
        Instant now=Instant.now();
        ZoneId zoneId=ZoneId.systemDefault();
        Clock clock=Clock.fixed(now,zoneId);
        TemporalCreation tc=TemporalCreation.of(clock);
        Year year=tc.year().now();
        Assertions.assertNotNull(tc);
        System.out.println(year);

        System.out.println(tc.year().now(ZoneId.of("UTC")));
    }

}
