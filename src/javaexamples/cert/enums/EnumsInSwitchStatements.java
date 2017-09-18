package javaexamples.cert.enums;

// Notes:
// Java will treat the enum type in a case statement as implied - if you add it you will get a compiler error.
// Why? Java already knows that the only possible matches can be enum values.
public class EnumsInSwitchStatements {

    public static void main(String[] args){
        exampleA();
    }

    private static void exampleA() {
        Season summer = Season.SUMMER;
        switch(summer){
            case WINTER: break;
            //case Season.SPRING: // An enum switch case label must be the unqualified name of an enumeration constant
        }
    }
}
