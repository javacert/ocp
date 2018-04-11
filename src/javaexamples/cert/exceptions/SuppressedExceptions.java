package javaexamples.cert.exceptions;

// Notes:
// 1. When multiple exceptions are thrown, all but the first are called suppressed exceptions.
// 2. Java treats the first exception as the primary one and tacks on any that come up while automatically closing.
// 3. Suppressed exceptions apply only to exceptions thrown in the try clause.
public class SuppressedExceptions {

    public static void main(String[] args) {
        matchingSuppressedExceptionExample();
        nonMatchingSuppressedExceptionExample();
    }

    private static void matchingSuppressedExceptionExample() {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("turkeys ran off"); // This is the first exception to be thrown
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());    // caught: turkeys ran off
            for (Throwable t: e.getSuppressed()) {
                System.out.println(t.getMessage());             // Cage door does not close
            }
        }
    }

    private static void nonMatchingSuppressedExceptionExample() {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new RuntimeException("turkeys ran off");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage()); // We won't get here since primary exception is RuntimeException - only the suppressed exception is IllegalStateException
        }
    }
}

class JammedTurkeyCage implements AutoCloseable {

    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close"); // This is the second exception to be thrown, so is suppressed.
    }

    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            System.out.println("put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
        }
    }
}