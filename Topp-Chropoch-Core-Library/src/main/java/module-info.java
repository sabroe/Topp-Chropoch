/**
 * Chropoch core.
 */
module com.yelstream.topp.chropoch.core {
    requires static lombok;
    requires org.slf4j;
    requires com.yelstream.topp.standard.core;
    exports com.yelstream.topp.chropoch.time;
    exports com.yelstream.topp.chropoch.time.creation.temporal;
    exports com.yelstream.topp.chropoch.time.creation.watch;
    exports com.yelstream.topp.chropoch.time.adjust;
    exports com.yelstream.topp.chropoch.time.manage;
}
