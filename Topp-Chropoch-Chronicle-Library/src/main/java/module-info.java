/**
 * Chropoch core.
 */
module com.yelstream.topp.chropoch.chronicle {
    requires static lombok;
    requires org.slf4j;
    requires com.yelstream.topp.standard.core;
    requires com.yelstream.topp.chropoch.temporal.core;
    requires com.yelstream.topp.chropoch.temporal.spawn;
//    exports com.yelstream.topp.chropoch.time;
//    exports com.yelstream.topp.chropoch.time.use;
    exports com.yelstream.topp.chropoch.time.chronicle;
}
