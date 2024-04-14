package com.yelstream.topp.chropoch.time.creation.watch;

import com.yelstream.topp.chropoch.time.adjust.TimeAcceleration;
import com.yelstream.topp.standard.time.NanoTimeSource;
import lombok.AllArgsConstructor;

import java.time.Clock;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of")
public class TimeWatchCreation {
    private final Clock clock;
    private final TimeAcceleration accelerator;
    private final NanoTimeSource nanoTimeSource;

/*
    public DefaultDurationWatch time() {
        return DefaultDurationWatch.of(clock::millis,ChronoUnit.MILLIS,LongUnaryOperator.identity());  //TO-DO: Address identity!
    }
*/

/*
    public DefaultDurationWatch nanoTime() {
        return DefaultDurationWatch.of(nanoTimeSource::nanoTime,ChronoUnit.NANOS,LongUnaryOperator.identity());  //TO-DO: Address identity!
    }
*/
}
