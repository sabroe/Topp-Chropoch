package com.yelstream.topp.chropoch.time.op;

@FunctionalInterface
public interface AwaitExOp<X,E extends Exception> {

    X await() throws InterruptedException, E;

}
