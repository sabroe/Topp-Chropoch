package com.yelstream.topp.chropoch.time.chronicle.op;

@FunctionalInterface
public interface AwaitOp<X> {

    X await() throws InterruptedException;

}
