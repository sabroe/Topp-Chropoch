package com.yelstream.topp.chropoch.time.op;

@FunctionalInterface
public interface BooleanAwaitOp {

    boolean await() throws InterruptedException;

}