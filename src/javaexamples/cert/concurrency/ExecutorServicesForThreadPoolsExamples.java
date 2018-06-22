package javaexamples.cert.concurrency;

// Notes:
// 1. A thread pool is a group of pre-instantiated reusable threads that are available to perform a set of arbitrary tasks.
// 2. The following are Executor methods which work with Thread Pools (note that newSingleThreadExecutor &
//    newSingleThreadScheduledExecutor work on single threads only, but are available in Executors along with the following):
//      - newCachedThreadPool - returns an ExecutorService - Creates a thread pool that creates new threads as they are
//        needed, but will reuse previously constructed threads when they are available.
//        Typically used for short-lived asynchronous tasks and should not be used for long-lived processes (could grow too large).
//      - newFixedThreadPool(int nThreads) - returns an ExecutorService - Creates a thread pool that reuses a fixed number
//        of threads operating off a shared unbounded queue.
//        Calling newFixedThreadPool with a value of 1 is equivalent to calling newSingleThreadExecutor().
//      - newScheduledThreadPool(int nThreads) - returns a ScheduledExecutorService - Creates a thread pool that can schedule
//        commands to run after a given delay or to execute periodically.
//        Same as newFixedThreadPool except it returns a ScheduledExecutorService so is is compatible with scheduling tasks.
// 3. If a pool runs out of available threads, the task will be queued by the thread executor and wait to be completed.
public class ExecutorServicesForThreadPoolsExamples {
}
