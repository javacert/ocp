package javaexamples.cert.internationalizationlocalization.resourcebundle;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

// Notes:
// Property File Format:
// 1. 3 ways to add a property to the file:
//    animal=dolphin
//    animal:dolphin
//    animal dolphin
// 2. Common expressions in a property file:
//    - If a line begins with # or !, it is a comment
//    - Spaces before or after the separator character are ignored
//    - Spaces at the beginning of a line are ignored
//    - Spaces at the end of a line are ignored
//    - End a line with a backslash if you want to break the line for readability
//    - You can use normal Java escape characters like \t and \n
public class ResourceBundleExample {

    public static void main(String[] args){
        Locale gb = new Locale("en", "GB");
        Locale fr = new Locale("fr", "FR");

        printProperties(gb);
        printProperties(fr);

        getAllKeysFromResourceBundle();
        usingProperties();
    }

    private static void printProperties(Locale locale) {
        // Needs to be the fully qualified name to the bundle
        ResourceBundle rb = ResourceBundle.getBundle("javaexamples/cert/internationalizationlocalization/resourcebundle/Bundle", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));

        /*
            Hello
            The zoo is open
            Bonjour
            Le zoo est ouvert
        */
    }

    private static void getAllKeysFromResourceBundle() {
        Locale gb = new Locale("en", "GB");
        ResourceBundle rb = ResourceBundle.getBundle("javaexamples/cert/internationalizationlocalization/resourcebundle/Bundle", gb);

        Set<String> keys = rb.keySet();
        keys.stream()
                .map(k -> k + " " + rb.getString(k))
                .forEach(System.out::println);

        // hello Hello
        // open The zoo is open
    }

    private static void usingProperties() {
        Locale gb = new Locale("en", "GB");
        ResourceBundle rb = ResourceBundle.getBundle("javaexamples/cert/internationalizationlocalization/resourcebundle/Bundle", gb);

        Properties props = new Properties();

        // Here we convert from a ResourceBundle into Properties which has some additional features such as setting default.
        rb.keySet().stream()
                .forEach(k -> props.put(k, rb.getString(k)));

        System.out.println(props.getProperty("notAnExistingProperty")); // null as property does not exist
        System.out.println(props.getProperty("notAnExistingProperty", "ImADefault")); // ImADefault since we set a default if it doesn't exist
        System.out.println(props.getProperty("hello")); // Hello since this property does exist in the ResourceBundle
    }
}
