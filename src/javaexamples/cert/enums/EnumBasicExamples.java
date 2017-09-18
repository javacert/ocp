package javaexamples.cert.enums;

public class EnumBasicExamples {

    public static void main(String[] args){
   /*     workingWithEnums();
        accessingEnumValues();
        createEnumFromStringValue();*/
        workingWithMoreComplexEnums();
    }

    private static void workingWithEnums() {
        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER); // SUMMER
        System.out.println(s == Season.SUMMER); // true - because enums are like static final constants
    }

    private static void accessingEnumValues() {
        for(Season season : Season.values()){
            System.out.print(season + " "
                    + season.name() + " "
                    + season.ordinal() + " "); // WINTER WINTER 0 SPRING SPRING 1 SUMMER SUMMER 2 AUTUMN AUTUMN 3
        }
        System.out.println();
    }

    private static void createEnumFromStringValue() {
        Season s1 = Season.valueOf("SUMMER");
        Season s2 = Season.valueOf("summer"); // Exception in thread "main" java.lang.IllegalArgumentException: No enum constant javaexamples.cert.enums.Season.summer
    }

    private static void workingWithMoreComplexEnums() {
        // MoreComplexSeason moreComplexSeason = new MoreComplexSeason(); // Constructor is private
        MoreComplexSeason.AUTUMN.printExpectedVisitors(); // Medium
    }
}

enum Season {
    WINTER, SPRING, SUMMER, AUTUMN // Semi-colon not required when only listing values!
}

enum MoreComplexSeason {
    // Note that the below actually call the private constructor to initialize the expectedVisitors variable
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), AUTUMN("Medium"); // Semi-colon required in this example!!!

    private String expectedVisitors;
    private MoreComplexSeason(String expectedVisitors){ // private only for enums, and private is implied.
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors(){
        System.out.println(expectedVisitors);
    }
}

enum EvenMoreComplexSeason {
    WINTER {
        @Override
        public void printHours() {
            System.out.println("Print the hours for WINTER");
        }
    }, SPRING {
        @Override
        public void printHours() {
            System.out.println("Print the hours for SPRING");
        }
    }, SUMMER {
        @Override
        public void printHours() {
            System.out.println("Print the hours for SUMMER");
        }
    }, AUTUMN {
        @Override
        public void printHours() {
            System.out.println("Print the hours for AUTUMN");
        }

        @Override
        public void someDefaultMethodToOverride(){
            System.out.println("I'm overriding the default method with my own implementation");
        }
    }; // We still need the semi-colon

    // When declaring an abstract method in an enum, all enum values must implement this method.
    public abstract void printHours();

    public void someDefaultMethodToOverride(){
        System.out.println("I'm a default enum method - I'll be called unless I'm overridden");
    }
}

// enum TryToExtendSeason extends Season{} // --> Does not compile
