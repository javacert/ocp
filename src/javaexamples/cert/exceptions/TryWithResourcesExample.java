package javaexamples.cert.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Notes:
// 1. This feature is also known as automatic resource management, because Java automatically takes care of the closing.
// 2. There is no finally block in the try-with-resources code. The finally clause exists implicitly. You just don’t have to type it.
// 3. Remember that only a try-with-resources statement is permitted to omit both the catch and finally blocks.
//    A traditional try statement must have either or both.
// 4. A try-with-resources statement is still allowed to have catch and/ or finally blocks. They are run in addition to the implicit one.
// 5. The implicit finally block runs before any programmer-coded ones.
// 6. You cannot have 2 or more manually written finally blocks in a traditional try block, nor in the try-with-resources, but
//    try-with-resources does have the implicit plus 1 defined finally (optional).
// 7. The resources created in the try clause are only in scope within the try block. This is because the implicit finally
//    block runs first to close the resources, so is not available to catch or finally.
// 8. In order for a class to be created in the try clause, Java requires it to implement an interface called AutoCloseable.
//    It has 1 method: public void close() throws Exception;
//    The AutoCloseable interface is saying that implementers may throw any exceptions they choose because an overriding method
//    is allowed to declare more specific exceptions than the parent or even none at all.
//    Java strongly recommends that close() not actually throw Exception. It is better to throw a more specific exception.
// 9.  Java closes resources in the reverse order from which it created them.
public class TryWithResourcesExample {

    public static void main(String[] args) {

    }

    public void oldApproach(Path path1, Path path2) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader(path1);
            out = Files.newBufferedWriter(path2);
            out.write(in.readLine());
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    // Notice that parentheses are used to list those resources and semicolons are used to separate the declarations.
    public void newApproach(Path path1, Path path2) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(path1);
             BufferedWriter out = Files.newBufferedWriter(path2)) {
            out.write(in.readLine());
        } // Resources are closed at this point.
    }
}
