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
