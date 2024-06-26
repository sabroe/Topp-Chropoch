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

/**
 * Topp Chropoch Core contains, as of now, incubating functionalities.
 */
module com.yelstream.topp.chropoch.core {
    requires static lombok;
    requires org.slf4j;
    requires com.yelstream.topp.standard.core;
    requires com.yelstream.topp.chropoch.temporal.spawn;
    exports com.yelstream.topp.chropoch.time;
    //exports com.yelstream.topp.chropoch.time.creation.temporal;
    exports com.yelstream.topp.chropoch.time.creation.watch;
    exports com.yelstream.topp.chropoch.time.adjust;
    exports com.yelstream.topp.chropoch.time.manage;
}
