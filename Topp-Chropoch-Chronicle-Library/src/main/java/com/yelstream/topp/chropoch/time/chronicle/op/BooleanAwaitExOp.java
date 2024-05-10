package com.yelstream.topp.chropoch.time.chronicle.op;

@FunctionalInterface
public interface BooleanAwaitExOp<E extends Exception> {

    boolean await() throws InterruptedException, E;

}