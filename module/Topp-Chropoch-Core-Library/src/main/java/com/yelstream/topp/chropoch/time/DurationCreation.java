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

package com.yelstream.topp.chropoch.time;

import com.yelstream.topp.standard.lang.Comparables;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

/**
 * Utility addressing instances of {@link Duration}.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-03-20
 */
@RequiredArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class DurationCreation {
    private Duration duration=Duration.ZERO;

    public DurationCreation of(TemporalUnit temporalUnit) {
        duration=temporalUnit.getDuration();
        return this;
    }

    public DurationCreation of(Duration duration) {
        this.duration=duration;
        return this;
    }

    public DurationCreation of(TimeUnit timeUnit) {
        duration=timeUnit.toChronoUnit().getDuration();
        return this;
    }

    public DurationCreation plus(Duration duration) {
        this.duration=this.duration.plus(duration);
        return this;
    }

    public DurationCreation minus(Duration duration) {
        this.duration=this.duration.minus(duration);
        return this;
    }

    public DurationCreation hours(long hours) {
        duration=duration.plusHours(hours);
        return this;
    }

    public DurationCreation minutes(long minutes) {
        duration=duration.plusMinutes(minutes);
        return this;
    }

    public DurationCreation seconds(long seconds) {
        duration=duration.plusSeconds(seconds);
        return this;
    }

    public DurationCreation min(Duration duration) {
        this.duration=Comparables.min(this.duration,duration);
        return this;
    }

    public DurationCreation max(Duration duration) {
        this.duration=Comparables.max(this.duration,duration);
        return this;
    }

    public Duration duration() {
        return duration;
    }
}
