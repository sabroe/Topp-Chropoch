/**
 * Chropoch core.
 */
module com.yelstream.topp.chropoch.suspend.spawn {
    requires static lombok;
    requires org.slf4j;
    requires com.yelstream.topp.chropoch.temporal.core;
//    requires com.yelstream.topp.standard.core;
    exports com.yelstream.topp.chropoch.time.creation.suspend;
}
