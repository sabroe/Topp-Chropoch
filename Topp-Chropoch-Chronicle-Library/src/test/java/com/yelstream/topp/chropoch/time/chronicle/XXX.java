package com.yelstream.topp.chropoch.time.chronicle;

import com.yelstream.topp.chropoch.time.chronicle.op.AwaitExOp;
import com.yelstream.topp.chropoch.time.chronicle.op.AwaitOp;
import com.yelstream.topp.chropoch.time.chronicle.op.BooleanAwaitOp;
import com.yelstream.topp.chropoch.time.chronicle.util.Await;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@AllArgsConstructor
public class XXX {

    private final Chronicle chronicle;



    public void run() throws ExecutionException, InterruptedException, TimeoutException {

        LocalDate localDate=chronicle.temporal().localDate().now();

//        Duration sleepDuration=chronicle.delay().duration(null).localDate().apply();

        
        Await.S.S1 x1=Thread::sleep;
        Await.S.S1 x2=Thread::sleep;
        Await.S.S1 x3=Thread::sleep;

        Thread t1=new Thread();
        Await.J.J1 j1=t1::join;
        Await.J.J1 j2=t1::join;
        Await.J.J1 j3=t1::join;
        Await.J.J1 j4=t1::join;

        Await.U.U1<InterruptedException> u1=Thread::sleep;
        Await.U.U2<InterruptedException> u2=Thread::sleep;
        Await.U.U3<InterruptedException> u3=Thread::sleep;

        Thread t2=new Thread();
//        AwaitOp j1=t2::join;
//        AwaitOp j2=t2::join;
//        AwaitOp j3=t2::join;

        {
            Duration d = Duration.ZERO;
            BooleanAwaitOp a4 = () -> t2.join(d);
        }
        {
            long millis=0;
            BooleanAwaitOp a4 = () -> { t2.join(millis); return t2.getState()==Thread.State.TERMINATED; };
        }
        {
            long millis=0;
            int nanos=0;
            BooleanAwaitOp a4 = () -> { t2.join(millis,nanos); return t2.getState()==Thread.State.TERMINATED; };
        }
        {
            BooleanAwaitOp a4 = () -> { t2.join(); return t2.getState()==Thread.State.TERMINATED; };
        }


        CompletableFuture<String> cf=null;
        AwaitExOp<String,Exception> a=()->cf.get(1L, TimeUnit.MINUTES);

        ;

    }
}
