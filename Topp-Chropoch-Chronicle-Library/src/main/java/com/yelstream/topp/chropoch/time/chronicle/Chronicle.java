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

package com.yelstream.topp.chropoch.time.chronicle;

import com.yelstream.topp.chropoch.time.control.TemporalController;
import com.yelstream.topp.chropoch.time.creation.suspend.AwaitCreation;
import com.yelstream.topp.chropoch.time.creation.suspend.DelayCreation;
import com.yelstream.topp.chropoch.time.creation.suspend.SuspendCreation;
import com.yelstream.topp.chropoch.time.creation.temporal.TemporalAccessorCreation;
import com.yelstream.topp.chropoch.time.transform.Timer;

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
