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

package com.yelstream.topp.chropoch.time.adjust;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@Getter
@AllArgsConstructor(staticName="of")
@lombok.Builder(builderClassName="Builder",toBuilder=true)
public class TimeAcceleration {
    /**
     * Factor with which time is different as compared to the normal reference time.
     * <p>
     * If this is exactly onee then time moves as normal.
     * </p>
     * <p>
     * If this is larger than one then time moves faster than normal.
     * </p>
     * <p>
     * If this is less than one then time moves slower than normal.
     * </p>
     * <p>
     * If this is negative then time moves backwards relative to normal time.
     * </p>
     */
    private final double factor;

    /**
     * Adjustment of durations to reference time.
     * <p>
     *     Example: If {@link #factor} is {@code 2} then durations are adjusted to half their length.
     * </p>
     */
    private final DurationAdjuster durationToReferenceAdjustment;

    /**
     * Adjustment of durations from reference time.
     * <p>
     *     Example: If {@link #factor} is {@code 2} then durations are adjusted to double their length.
     * </p>
     */
    private final DurationAdjuster durationFromReferenceAdjustment;
}
