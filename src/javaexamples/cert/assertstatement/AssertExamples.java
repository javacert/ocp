package javaexamples.cert.assertstatement;

// Notes
// 1. An assertion throws an AssertionError if it is false.
// 2. Assertion failures are fatal and end the program.
// 3. The three possible outcomes of an assert statement are as follows:
//      - If assertions are disabled, Java skips the assertion and goes on in the code.
//      - If assertions are enabled and the boolean expression is true , then our assertion has been validated and nothing happens.
//      - If assertions are enabled and the boolean expression is false , then our assertion is invalid and a java.lang.AssertionError is thrown.
// 4. By default, assert statements are ignored by the JVM at runtime.
// 5. To enable assertions, use the -enableassertions flag on the command line:
//      - java -enableassertions Rectangle
//      - java -ea Rectangle
//      - java -ea:com.wiley.demos... my.programs.Main --> For a specific package
//      - java -ea:com.wiley.demos.TestColors my.programs.Main --> For a specific class
// 6. Assertions are used for debugging purposes, they should not be used in production.
public class AssertExamples {
    
    public static void main(String[] args) {
        assertExample1();
        assertExample2();
    }

    private static void assertExample1() {
        int numGuests = -5;
        assert numGuests > 0; // Java throws the error for you if it evaluates to false, but you must enable Assertions.
        System.out.println(numGuests);
    }

    private static void assertExample2() {
        assert true : "Will never print me";
        assert false : "Will always throw an AssertionError";
    }
}
