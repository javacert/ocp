package javaexamples.cert.internationalizationlocalization.javatyperesourcebundle;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

// Notes:
// Rather than use the Property file which can hold Strings only, use the Java Class Resource Bundle and you can use
// any of the Java types.
// There are 2 advantages to doing it this way:
//  1. You can use a value type that is not String
//  2. You can create the values of the properties at runtime
public class JavaTypeResourceBundle_en_GB extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                { "hello", "hello there!!" },
                { "open", "The Zoo is Open"}
        };
    }

    public static void main(String[] args){
        ResourceBundle rb = ResourceBundle.getBundle("javaexamples.cert.internationalizationlocalization.javatyperesourcebundle.JavaTypeResourceBundle", Locale.ENGLISH);
        System.out.println(rb.getObject("hello there!!"));
    }
}
