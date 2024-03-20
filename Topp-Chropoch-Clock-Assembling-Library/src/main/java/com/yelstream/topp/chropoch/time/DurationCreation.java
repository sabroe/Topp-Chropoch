package com.yelstream.topp.chropoch.time;

import com.yelstream.topp.chropoch.lang.Comparables;
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
