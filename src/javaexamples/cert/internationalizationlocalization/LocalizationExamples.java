package javaexamples.cert.internationalizationlocalization;

import java.util.Locale;

// Notes:
// 1. Localization actually means supporting multiple locales (geographical, political, or cultural region)
// 2. It includes translating strings to different languages.
// 3. It also includes outputting dates and numbers in the correct format for a locale.
// 4. Localization is often abbreviated to l10n
// 5. Locale String formats - language_COUNTRY, may be language only e.g. en or en_GB. Invalid formats: GB or enGB
public class LocalizationExamples {

    public static void main(String[] args) {
        getCurrentLocale();
        localeConstants();
        instantiatingALocale();
        creatingUsingABuilder();
        settingTheDefaultLocale();
    }

    public static void getCurrentLocale() {
        Locale locale = Locale.getDefault();
        System.out.println(locale); // en_GB
    }

    private static void localeConstants() {
        System.out.println(Locale.GERMAN);      // de
        System.out.println(Locale.GERMANY);     // de_DE
    }

    private static void instantiatingALocale() {
        System.out.println(new Locale("fr"));                   // fr
        System.out.println(new Locale("hi", "IN"));      // hi_IN
    }

    private static void creatingUsingABuilder() {
        Locale l1 = new Locale.Builder()
                .setLanguage("en")      // Builder will convert the case but it is bad practice!
                .setRegion("US")        // These can go in any order!!
                .build();
        System.out.println(l1);         // en_US
    }

    private static void settingTheDefaultLocale() {
        Locale.setDefault(new Locale("fr"));
        System.out.println(Locale.getDefault());    // fr
    }
}
