package javaexamples.cert.classdesign;

// Notes:
// 1. Within the same program, the result of hashCode() must not change. This means that you shouldn't include
//    variables that change in figuring out the hash code.
// 2. If equals() returns true when called with 2 objects, calling hashCode() can use a subset of the variables
//    that equals uses.
// 3. If equals() returns false when called with 2 objects, calling hashCode() on each of those objects does
//    not have to return a different result.
public class HashCode {

    public static void main(String[] args){
        validExamples();
        invalidExamples();
    }

    private static void validExamples() {
    }

    private static void invalidExamples() {
    }

    @Override
    public int hashCode() {
        return 6;
    }

    // public long hashCode(){ return 10; } // --> Not a valid override of hashCode
    // public int hashCode(){ return someVariable * 7 + someVariableNotUsedInEquals; } // --> Uses more variables that in equals override
}
