package com.yelstream.topp.chropoch.time.control;

import com.yelstream.topp.chropoch.time.provider.ClockProvider;
import com.yelstream.topp.chropoch.time.provider.Timer;
import com.yelstream.topp.chropoch.time.provider.TimerProvider;

import java.time.Clock;

public interface TemporalController {  //Chronometer?
    ClockProvider getClockProvider();

    TimerProvider getTimerProvider();

    default Clock getClock() {
        return getClockProvider().getClock();
    }

    default Timer getTimer() {
        return getTimerProvider().getTimer();
    }
}
