package com.yelstream.topp.chropoch.time.creation.suspend;

import com.yelstream.topp.chropoch.time.transform.Timer;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * Main source of delay and await operations.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-10
 */
@AllArgsConstructor(staticName="of")
public class SuspendCreation {
    /**
     * Timer source.
     */
    private final Supplier<Timer> timerSupplier;

    private Supplier<Timer> getTimerSupplier() {
        return timerSupplier;
    }

    /**
     * Gets access to creating delay operations.
     * @return Creator of delay operations.
     */
    public DelayCreation delay() {
        return DelayCreation.of(getTimerSupplier());
    }

/*
    */
/**
     * Gets access to creating delay operations.
     * @param duration Delay duration.
     * @return Creator of delay operations.
     *//*

    public DelayCreation.Builder delay(Duration duration) {
        return DelayCreation.Builder.create(getTimerSupplier(),duration);
    }
*/

    /**
     * Gets access to creating await operations.
     * @param duration Maximum await duration.
     * @return Creator of await operations.
     */
    public AwaitCreation await() {
        return AwaitCreation.of(getTimerSupplier());
    }

    public void sleep(long millis) throws InterruptedException {
        delay().sleep(millis);
    }

    public void sleep(long millis,
                      int nanos) throws InterruptedException {
        delay().sleep(millis,nanos);
    }

    public void sleep(Duration duration) throws InterruptedException {
        delay().sleep(duration);
    }



}
