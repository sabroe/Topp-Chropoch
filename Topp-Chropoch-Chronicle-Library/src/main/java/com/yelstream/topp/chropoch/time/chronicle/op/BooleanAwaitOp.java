package com.yelstream.topp.chropoch.time.chronicle.op;

@FunctionalInterface
public interface BooleanAwaitOp {

    boolean await() throws InterruptedException;

}