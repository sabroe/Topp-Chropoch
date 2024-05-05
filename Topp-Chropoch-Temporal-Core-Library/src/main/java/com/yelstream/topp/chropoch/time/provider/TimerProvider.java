package com.yelstream.topp.chropoch.time.provider;

import java.util.function.Supplier;

public interface TimerProvider {
    Timer getTimer();

    default Supplier<Timer> supplier() {
        return this::getTimer;
    }
}
