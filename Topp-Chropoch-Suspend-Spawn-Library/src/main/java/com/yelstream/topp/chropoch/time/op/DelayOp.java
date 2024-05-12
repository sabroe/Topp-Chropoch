package com.yelstream.topp.chropoch.time.op;

import java.time.Duration;

@FunctionalInterface
public interface DelayOp {

    void delay() throws InterruptedException;

}
