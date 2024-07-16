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
