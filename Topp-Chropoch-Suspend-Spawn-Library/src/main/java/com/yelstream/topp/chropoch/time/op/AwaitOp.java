package com.yelstream.topp.chropoch.time.op;

@FunctionalInterface
public interface AwaitOp<X> {

    X await() throws InterruptedException;

}
