/**
 * Chropoch core.
 */
module com.yelstream.topp.chropoch.temporal.core {
    requires static lombok;
    requires org.slf4j;
    requires com.yelstream.topp.standard.core;
    exports com.yelstream.topp.chropoch.time.control;
    exports com.yelstream.topp.chropoch.time.duration;
    exports com.yelstream.topp.chropoch.time.provider;
    exports com.yelstream.topp.chropoch.time.source;
    exports com.yelstream.topp.chropoch.time.transform;
}
