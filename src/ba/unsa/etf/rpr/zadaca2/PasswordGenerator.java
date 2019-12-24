package ba.unsa.etf.rpr.zadaca2;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PasswordGenerator {
    private static final String MALA_SLOVA = "abcdefghijklmnopqrstuvwxyz";
    private static final String VELIKA_SLOVA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String BROJEVI = "0123456789";
    private static final String SPEC_ZNAK = "!@#$%&*()_+-=[]|,./?><";
    private static boolean sadrziSpecZnak;

    public static void setSadrziSpecZnak(boolean sadrziSpecZnak) {
        PasswordGenerator.sadrziSpecZnak = sadrziSpecZnak;
    }

    public static String generisi() {
        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(2);
        String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        String totalChars = RandomStringUtils.randomAlphanumeric(2);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                .concat(totalChars);
        if (sadrziSpecZnak)
            combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                    .concat(numbers)
                    .concat(specialChar);
        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        return pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}