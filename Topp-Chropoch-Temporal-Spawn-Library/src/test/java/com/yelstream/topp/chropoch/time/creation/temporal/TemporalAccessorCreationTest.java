package com.yelstream.topp.chropoch.time.creation.temporal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

/**
 * Test of {@code com.yelstream.topp.chropoch.time.creation.TemporalAccessorCreation}.
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-05-04
 */
@Slf4j
class TemporalAccessorCreationTest {


    /**
     * XXX
     */
    @Test
    void xxx() {
        Instant now= Instant.now();
        ZoneId zoneId=ZoneId.systemDefault();
        Clock clock= Clock.fixed(now,zoneId);
        TemporalAccessorCreation tc=TemporalAccessorCreation.of(clock);
        Assertions.assertNotNull(tc);
    }

}
