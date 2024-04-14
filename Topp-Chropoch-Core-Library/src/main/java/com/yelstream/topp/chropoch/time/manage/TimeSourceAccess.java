package com.yelstream.topp.chropoch.time.manage;

import com.yelstream.topp.standard.time.NanoTimeSource;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.InstantSource;
import java.time.ZoneId;

/**
 *
 *
 * @author Morten Sabroe Mortensen
 * @version 1.0
 * @since 2024-02-18
 */
@AllArgsConstructor(staticName="of",access=AccessLevel.PACKAGE)
public class TimeSourceAccess {
    private final Clock clock;
    private final NanoTimeSource nanoTimeSource;

    public Clock clock() {
        return clock;
    }

    public InstantSource instantSource() {
        return clock;
    }

    public ZoneId zone() {
        return clock.getZone();
    }

    public NanoTimeSource nanoTimeSource() {
        return nanoTimeSource;
    }
}
