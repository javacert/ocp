package javaexamples.cert.concurrency;

import java.util.concurrent.*;

// Notes:
// 1. Introduced with the Concurrency API.
// 2. The ExecutorService creates and manages threads for you (e.g. thread pooling and scheduling).
// 3. Use the Executors factory class to create instances.
// 4. A thread executor creates a non-daemon thread on the first task that is executed, so failing to call shutdown()
//    will result in your application never terminating.
// 5. The shutdown process for a thread executor involves first rejecting any new tasks submitted to
//    the thread executor while continuing to execute any previously submitted tasks. During this time:
//      - Calling isShutdown() will return true,
//      - Calling isTerminated() will return false
// 6. If a new task is submitted to the thread executor while it is shutting down, a RejectedExecutionException will be thrown.
// 7. To ATTEMPT to cancel all running and upcoming tasks, use shutdownNow() - it is not guaranteed. R
// 8. shutdownNow() returns a List<Runnable> of tasks that were submitted to the thread executor but that were never started.
// 9. You cannot use a try-with-resources statement with ExecutorService as it does not implement AutoCloseable.
// 10. You can submit tasks to an ExecutorService instance multiple ways:
//      1. void execute(Runnable command) --> is inherited from the Executor interface - takes a Runnable lambda expression or instance
//         and completes the task asynchronously. Since return is void it does not tell us anything about the result
//         of the task. It is fire-and-forget.
//      2. Future<?> submit(Runnable task) --> returns a Future object that can be used to determine if the task is complete.
//      3. <T> Future<T> submit(Callable<T> task) --> returns a Future object that can be used to determine if the task is complete.
//      4. <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) --> Executes the given tasks, synchronously
//         returning the results of all tasks as a Collection of Future objects, in the same order they were in the original collection
//      5. <T> T invokeAny(Collection<? extends Callable<T>> tasks) --> Executes the given tasks, synchronously
//         returning the result of one of finished tasks, cancelling any unfinished tasks.
// 11. Methods available in Future:
//      1. boolean isDone() - Returns true if the task was completed, threw an exception, or was cancelled
//      2. boolean isCancelled() - Returns true if the task was cancelled before it completely normally.
//      3. boolean cancel() - Attempts to cancel execution of the task.
//      4. V get() - Retrieves the result of a task, waiting endlessly if it is not yet available.
//      5. V get(long timeout, TimeUnit unit) - Retrieves the result of a task, waiting the specified amount of time.
//         If the result is not ready by the time the timeout is reached, a checked TimeoutException will be thrown.
// 12. The awaitTermination(long timeout, TimeUnit unit) method waits the specified time to complete all tasks,
//     returning sooner if all tasks finish or an InterruptedException is detected.
public class ExecutorServiceExamples {

    private static int counter = 0;

    public static void main(String[] args) {
        singleThreadExecutorExample();

        try {
            usingFutureExample();
        } catch(InterruptedException | ExecutionException e){
            System.out.println(e.getMessage());
        }
    }

    private static void singleThreadExecutorExample() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // Uses only 1 thread meaning threads will order the results.
            System.out.println("begin"); // Remember that the main method is on an independent thread.
            service.execute(() -> System.out.println("Printing"));
            service.execute(() ->
                {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Printing record: " + i);
                    }
                }
            );
            service.execute(() -> System.out.println("Printing"));
            System.out.println("end");
        } finally {
            if(service != null) service.shutdown();
        }
    }

    private static void usingFutureExample() throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for(int i=0; i<500; i++) ExecutorServiceExamples.counter++;
            });
            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached!");
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
