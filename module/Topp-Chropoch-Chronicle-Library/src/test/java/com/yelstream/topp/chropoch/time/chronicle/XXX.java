package com.yelstream.topp.chropoch.time.chronicle;

import com.yelstream.topp.chropoch.time.op.AwaitExOp;
import com.yelstream.topp.chropoch.time.op.BooleanAwaitOp;
import com.yelstream.topp.chropoch.time.op.util.SleepOps;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@AllArgsConstructor
public class XXX {

    private final Chronicle chronicle;

    public void run() throws ExecutionException, InterruptedException, TimeoutException {

        LocalDate localDate=chronicle.temporal().localDate().now();

//        Duration sleepDuration=chronicle.delay().duration(null).localDate().apply();

        
/*
        Await.S.S1 x1=Thread::sleep;
        Await.S.S1 x2=Thread::sleep;
        Await.S.S1 x3=Thread::sleep;
*/

/*
        Thread t1=new Thread();
        Await.J.J1 j1=t1::join;
        Await.J.J1 j2=t1::join;
        Await.J.J1 j3=t1::join;
        Await.J.J1 j4=t1::join;
*/

/*
        Await.U.U1<InterruptedException> u1=Thread::sleep;
        Await.U.U2<InterruptedException> u2=Thread::sleep;
        Await.U.U3<InterruptedException> u3=Thread::sleep;
*/

//        Thread t2=new Thread();
//        AwaitOp j1=t2::join;
//        AwaitOp j2=t2::join;
//        AwaitOp j3=t2::join;

        { //Thread!
            Thread t2=new Thread();
            {
                Duration d = Duration.ZERO;
                BooleanAwaitOp a4 = () -> t2.join(d);
            }

            {
                long millis = 0;
                BooleanAwaitOp a4 = () -> {
                    t2.join(millis);
                    return t2.getState() == Thread.State.TERMINATED;
                };
            }

            {
                long millis = 0;
                int nanos = 0;
                BooleanAwaitOp a4 = () -> {
                    t2.join(millis, nanos);
                    return t2.getState() == Thread.State.TERMINATED;
                };
            }

            {
                BooleanAwaitOp a4 = () -> {
                    t2.join();
                    return t2.getState() == Thread.State.TERMINATED;
                };
            }
        }

        {
            Future<String> cf = null;
            AwaitExOp<String, Exception> a = () -> cf.get(1L, TimeUnit.MINUTES);
        }
        {  //CompletableFuture!
/*
            CompletableFuture<String> cf = null;

            CompletableFuture<T> completeOnTimeout(T value,
            long timeout,
            TimeUnit unit)


            Executor delayedExecutor(long delay,
            TimeUnit unit)


            Executor delayedExecutor(long delay,
            TimeUnit unit,
            Executor executor)


            public T get(long timeout,
            TimeUnit unit)
      throws InterruptedException,
                ExecutionException,
                TimeoutException



            CompletableFuture<T> orTimeout(long timeout,
            TimeUnit unit)
*/
        }
        {//CountdownLatch!
/*
            public void await()
           throws InterruptedException

            public boolean await(long timeout,
            TimeUnit unit)
              throws InterruptedException
 */
        }

        SleepOps.S1 _u1=Thread::sleep;
        Duration d=Duration.ZERO;

        {  //WANTED FORMATS!
            {
//                chronicle.suspend().delay().duration(d).build().op(_u1).delay();

                chronicle.delay().fixed().duration(d).op().delay();
//                chronicle.delay().fixed().duration(d).op(_u1).delay();

                chronicle.suspend().sleep(Duration.ZERO);
                chronicle.suspend().sleep(0L);
                chronicle.suspend().sleep(0L,0);

                chronicle.suspend().delay().sleep(Duration.ZERO);
                chronicle.suspend().delay().sleep(0L);
                chronicle.suspend().delay().sleep(0L,0);

                chronicle.suspend().delay().fixed().duration(Duration.ZERO).op().delay();
                chronicle.suspend().delay().fixed().duration(0L).op().delay();
                chronicle.suspend().delay().fixed().duration(0L,0).op().delay();

                Thread t=new Thread();
                chronicle.suspend().join(t,Duration.ZERO);
                chronicle.suspend().join(t,0L);
                chronicle.suspend().join(t,0L,0);

                chronicle.suspend().await().join(t,Duration.ZERO);
                chronicle.suspend().await().join(t,0L);
                chronicle.suspend().await().join(t,0L,0);

//                chronicle.suspend().delay().varying().duration(Duration.ZERO).apply();
//                chronicle.suspend().delay().varying().duration(0L).apply();
//                chronicle.suspend().delay().varying().duration(0L,0).apply();


//                chronicle.suspend().delay().duration(Duration.ZERO).target().build().apply();
//                chronicle.suspend().delay().duration(0L).target().build().apply();
//                chronicle.suspend().delay().duration(0L,0).target().build().apply();


            }
        }


//        chronicle.suspend().await(d);//.join();
    }
}
