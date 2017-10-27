package javaexamples.cert.generics;

import java.util.ArrayList;
import java.util.List;

// Notes:
// 1. An unbounded wildcard represents any data type
public class UnboundedWildcards {

    public static void main(String[] args){
        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        printAnyList(stringList);
        printAnyList(integerList);
    }

    // This method can take a list of anything, there are no boundaries whatsoever!
    public static void printAnyList(List<?> anyTypeOfList){
        for(Object listEntry : anyTypeOfList) {
            System.out.println(listEntry.toString());
        }
    }

    public void unboundedWildcardExample(){
        List<?> l = new ArrayList<String>();
    }
}
