package javaexamples.cert.internationalizationlocalization.resourcebundleloadorder;

import java.util.Locale;
import java.util.ResourceBundle;

// Notes:
// 1. Always look for the property file after the matching Java class.
// 2. Drop one thing at a time if there are no matches. First drop the country and then the language.
// 3. Look at the default locale and the default resource bundle last.
// 4. Run down of the ordering:
//    - Java goes through candidate resource bundles from the most specific to the most general to find a match
//    - If no matches are found for the requested locale, Java switches to the default locale (Bundle_en_GB.properties) and then finally the default resource bundle (Bundle.properties).
//    - Java looks at the equivalent Java class before the property file for each locale (JavaTypeResourceBundle_en_GB over Bundle_en_GB.properties).
//    - Once a matching resource bundle is found, Java only looks in the hierarchy of that resource bundle to find keys.
public class ResourceBundleLoadOrderExample {

    public static void main(String[] args) {
        bundleOrderExample();
    }

    private static void bundleOrderExample() {
        Locale locale = new Locale("en", "CA");
        ResourceBundle rb = ResourceBundle.getBundle("javaexamples/cert/internationalizationlocalization/resourcebundleloadorder/Bundle", locale);

        System.out.print(rb.getString("hello"));
        System.out.print(". ");
        System.out.print(rb.getString("name"));
        System.out.print(" ");
        System.out.print(rb.getString("open"));
        System.out.print(" ");
        System.out.print(rb.getString("visitor"));

        // Hello. Vancouver Zoo is open Canada visitor
    }
}
