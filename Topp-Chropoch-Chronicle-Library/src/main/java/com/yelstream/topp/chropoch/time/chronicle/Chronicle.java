package com.yelstream.topp.chropoch.time.chronicle;

import com.yelstream.topp.chropoch.time.control.TemporalController;
import com.yelstream.topp.chropoch.time.creation.suspend.AwaitCreation;
import com.yelstream.topp.chropoch.time.creation.suspend.DelayCreation;
import com.yelstream.topp.chropoch.time.creation.suspend.SuspendCreation;
import com.yelstream.topp.chropoch.time.creation.temporal.TemporalAccessorCreation;
import com.yelstream.topp.chropoch.time.provider.Timer;

import java.time.Clock;

/**
 * Main entry point for clock-related functionalities and operations related to time and timing.
 * <p>
 *     Applications should use this to coordinate all operations related to time.
 * </p>
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-10
 */
public interface Chronicle {

    TemporalController controller();  //Rename to conventional #getController()!?

    default Clock clock() {
        return controller().getClockProvider().getClock();
    }

/* Consider this!
    default NanoTimeSource counter() {
    }
*/

    default Timer timer() {
        return controller().getTimerProvider().getTimer();
    }

    default TemporalAccessorCreation temporal() {
        return TemporalAccessorCreation.of(controller().getClockProvider().supplier());
    }

    default SuspendCreation suspend() {
        return SuspendCreation.of(controller().getTimerProvider().supplier());
    }

    default DelayCreation delay() {
        return suspend().delay();
    }

    default AwaitCreation await() {
        return suspend().await();
    }

/* Consider this!
    default WatchCreation watch() {
        //Creator of e.g. 'DurationWatch'!
    }
*/
}
