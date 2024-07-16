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

package com.yelstream.topp.chropoch.time.manage;

import com.yelstream.topp.chropoch.time.adjust.DurationAdjuster;
import com.yelstream.topp.chropoch.time.adjust.TimeAcceleration;
import lombok.Getter;

import java.util.function.Supplier;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@SuppressWarnings("java:S115")
public enum StandardTimeManagement {
    Slower10x(1D/10,10),
    Slower5x(1D/5,5),
    Slower4x(1D/4,4),
    Slower3x(1D/3,3),
    Slower2x(1D/2,2),

    Normal1x(1),
    Factor2x(2),
    Factor3x(3),
    Factor4x(4),
    Factor5x(5),
    Factor7x(7),  //One week in one day
    Factor10x(10),
    Factor12x(12),  //24 hours in two hours
    Factor20x(20),
    Factor24x(24),  //24 hours in one hour
    Factor30x(30),
    Factor40x(40),
    Factor48x(48),  //24 hours in 30 minutes
    Factor50x(50),
    Factor100x(100),
    Factor1000x(1000),
    Factor7x24x(7*24),  //168x, one week in one hour
    Factor30x24x(30*24),  //720x, one month in one hour
    Factor3x30x24x(3*30*24),  //2160x, three months in one hour
    Factor365x(365),  //one year in one day
    Factor52x7x24(52*7*24),  //8736x, 52 weeks in one hour
    Factor365x24x(365*24);  //8760x, one year in one hour

    @Getter
    private final double factor;

    private final Supplier<DurationAdjuster> durationToReferenceAdjustmentSupplier;

    private final Supplier<DurationAdjuster> durationFromReferenceAdjustmentSupplier;


    StandardTimeManagement(double factor,
                           Supplier<DurationAdjuster> durationToReferenceAdjustmentSupplier,
                           Supplier<DurationAdjuster> durationFromReferenceAdjustmentSupplier) {
        this.factor=factor;
        this.durationToReferenceAdjustmentSupplier=durationToReferenceAdjustmentSupplier;
        this.durationFromReferenceAdjustmentSupplier=durationFromReferenceAdjustmentSupplier;
    }

    StandardTimeManagement(int factor) {
        this((double)factor,()->DurationAdjuster.scaleDown(factor),()->DurationAdjuster.scaleUp(factor));
    }

    StandardTimeManagement(double factor, int f) {
        this((double)factor,()->DurationAdjuster.scaleUp(f),()->DurationAdjuster.scaleDown(f));
    }

    public DurationAdjuster createDurationToReferenceAdjustment() {
        return durationToReferenceAdjustmentSupplier.get();
    }

    public DurationAdjuster createDurationFromReferenceAdjustment() {
        return durationFromReferenceAdjustmentSupplier.get();
    }

    public TimeAcceleration createTimeAcceleration() {
        return TimeAcceleration.of(factor,durationToReferenceAdjustmentSupplier.get(),durationFromReferenceAdjustmentSupplier.get());
    }
}
