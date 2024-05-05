/**
 * Chropoch core.
 */
module com.yelstream.topp.chropoch.temporal.config {
    requires static lombok;
    requires org.slf4j;
    requires com.yelstream.topp.standard.core;
//    requires com.yelstream.topp.chropoch.temporal.core;
    exports com.yelstream.topp.chropoch.time.config;
}
