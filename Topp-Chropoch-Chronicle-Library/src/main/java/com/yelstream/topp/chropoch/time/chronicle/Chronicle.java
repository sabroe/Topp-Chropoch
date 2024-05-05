package com.yelstream.topp.chropoch.time.chronicle;

import com.yelstream.topp.chropoch.time.control.TemporalController;
import com.yelstream.topp.chropoch.time.creation.temporal.TemporalAccessorCreation;
import com.yelstream.topp.chropoch.time.provider.Timer;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.util.function.Supplier;

public interface Chronicle {

    TemporalController controller();  //Rename to conventional #getController()!?

    default Clock clock() {
        return controller().getClockProvider().getClock();
    }

    default Timer timer() {
        return controller().getTimerProvider().getTimer();
    }

    default TemporalAccessorCreation temporal() {
        return TemporalAccessorCreation.of(controller().getClockProvider().supplier());
    }

    default DelayCreation delay() {
        return DelayCreation.of(controller().getTimerProvider().supplier());
    }

    // Other convenient methods for time-related operations
    //DurationWatch?

    @AllArgsConstructor(staticName="of")
    public static class DelayCreation {
        /**
         * Clock source.
         */
        private final Supplier<Timer> timerSupplier;

        private Supplier<Timer> getTimerSupplier() {
            return timerSupplier;
        }



    }
}
