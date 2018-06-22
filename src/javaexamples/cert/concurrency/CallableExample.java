package javaexamples.cert.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Notes:
// 1. java.util.concurrent.Callable is a functional interface released with Java 5 (similar to Supplier functional
//    interface except it can throw checked exceptions).
// 2. Similar to Runnable except that its call() method returns a value and can throw a checked exception.
// 3. The ExecutorService includes an overloaded version of the submit() method that takes a Callable object and returns
//    a generic Future<T> object.
public class CallableExample {

    public static void main(String[] args)  {
        try {
            getTheResultFromCallable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        callableVsRunnableCheckedExceptions();
    }

    public static void getTheResultFromCallable() throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> 30 + 11);
            System.out.println(result.get()); // 41
        } finally {
            if (service != null) service.shutdown();
        }
    }

    private static void callableVsRunnableCheckedExceptions() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            service.submit(() -> {Thread.sleep(1000); return null;}); // Treated as Callable
            // Since it doesn't return a value, treats it as Runnable which do not support checked exceptions
            // service.submit(() -> {Thread.sleep(1000);});
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
