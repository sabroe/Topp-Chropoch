package com.yelstream.topp.chropoch.time.chronicle.op;

@FunctionalInterface
public interface AwaitExOp<X,E extends Exception> {

    X await() throws InterruptedException, E;

}
