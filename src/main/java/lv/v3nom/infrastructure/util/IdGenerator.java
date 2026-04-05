package lv.v3nom.infrastructure.util;

import java.util.Random;

public class IdGenerator {
    private static final Random random = new Random();
    private static final Integer length = 15;
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                        + "abcdefghijklmnopqrstuvwxyz"
                        + "0123456789";

    public static String generateDigitId() {
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

    public static String  generateAsciiId() {
        StringBuilder id = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            id.append(characters.charAt(index));
        }
        return id.toString();
    }
}
