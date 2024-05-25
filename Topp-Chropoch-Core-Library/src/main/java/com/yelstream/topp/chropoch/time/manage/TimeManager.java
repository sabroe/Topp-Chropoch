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

package com.yelstream.topp.chropoch.time.manage;

import com.yelstream.topp.chropoch.time.adjust.DurationTransformation;
import com.yelstream.topp.chropoch.time.adjust.TimeAcceleration;
import com.yelstream.topp.chropoch.time.creation.temporal.TemporalAccessorCreation;
import com.yelstream.topp.chropoch.time.creation.temporal.TemporalCreation;
import com.yelstream.topp.chropoch.time.creation.watch.TimeWatchCreation;
import com.yelstream.topp.standard.time.NanoTimeSource;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@lombok.Builder(builderClassName="Builder",toBuilder=true)
public class TimeManager {
    private final Clock clock;

    private final TimeAcceleration accelerator;
    private final NanoTimeSource nanoTimeSource;

    //TimeAccelerator accelerator();

    public TimeSourceAccess source() {
        return TimeSourceAccess.of(clock,nanoTimeSource);
    }

    public TimeWatchCreation watch() {
        return TimeWatchCreation.of(clock,accelerator,nanoTimeSource);
    }

    public TemporalAccessorCreation createTemporalAccessor() {
        return TemporalAccessorCreation.of(clock);
    }

    public TemporalCreation createTemporal() {
        return TemporalCreation.of(clock);
    }

    public DurationTransformation duration() {
        return DurationTransformation.of(clock,accelerator);
    }

    public static class Builder {
        private Clock clock=Clock.systemDefaultZone();
        private TimeAcceleration accelerator;
        private NanoTimeSource nanoTimeSource=NanoTimeSource.system();

        public Builder offset(Duration offsetDuration) {
            clock=Clock.offset(clock,offsetDuration);
            return this;
        }

        public Builder tick(Duration tickDuration) {
            clock=Clock.tick(clock,tickDuration);
            return this;
        }

        public Builder withZone(ZoneId zone) {
            clock=clock.withZone(zone);
            return this;
        }
    }

    public static void main(String[] args) {
        TimeManager time=null;

        Clock clock0=time.source().clock();
        InstantSource instantSource=time.source().instantSource();

        Instant instant=time.createTemporalAccessor().instant().now();
        LocalTime localTime=time.createTemporal().localTime().now();

        Duration d2=time.duration().scale(Duration.ofHours(1));
    }
}
