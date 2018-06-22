package javaexamples.cert.concurrency;

import java.util.concurrent.*;

// Notes:
// 1. The ScheduledExecutorService is a sub-interface of ExecutorService.
// 2. Allows you to schedule a task to happen at some future time.
// 3. Available methods:
//    a) schedule(Callable<V> callable, long delay, TimeUnit unit)
//       --> Creates and executes a Callable task after the given delay and returns a ScheduledFuture<V> instance.
//    b) schedule(Runnable command, long delay, TimeUnit unit)
//       --> Creates and executes a Runnable task after the given delay and returns a ScheduledFuture<V> instance.
//    c) scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
//       --> Creates and executes a Runnable task after the given initial delay, creating a new task every period value that passes.
//    d) scheduleAtFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
//       --> Creates and executes a Runnable task after the given initial delay and subsequently with the given delay
//           between the termination of one execution and the commencement of the next.
// 4. ScheduledFuture<V> is identical to the Future<V> class, except that it includes a getDelay() method that returns
//    the delay set when the process was created.
public class ScheduledExecutorServiceExample {
    
    public static void main(String[] args) {
        obtainAnInstanceFromTheFactory();
        scheduleUsingRunnableAndCallable();
    }

    private static void obtainAnInstanceFromTheFactory() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    }

    private static void scheduleUsingRunnableAndCallable() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";

        Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        ScheduledFuture<?> result2 = service.schedule(task2, 8, TimeUnit.MINUTES);
    }
}
