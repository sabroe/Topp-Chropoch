package com.yelstream.topp.chropoch.time.op;

@FunctionalInterface
public interface BooleanAwaitExOp<E extends Exception> {

    boolean await() throws InterruptedException, E;

}