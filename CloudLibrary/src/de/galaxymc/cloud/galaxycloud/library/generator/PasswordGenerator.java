package de.galaxymc.cloud.galaxycloud.library.generator;

import java.util.Random;

public class PasswordGenerator {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String special = ".,-_#+-*/!§$%&()=?";

    public static String generatePassword(int length, PasswordType type) {
        StringBuilder password = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            switch (type) {
                case NUMBERS_ONLY:
                    password.append(rand.nextInt(10));
                    break;
                case CHARACTERS_ONLY:
                    password.append(alphabet.charAt(rand.nextInt(alphabet.length() + 1)));
                    break;
                case CHARACTERS_NUMBERS:
                    int v = rand.nextInt(10 + alphabet.length());
                    password.append(v < 10 ? v : alphabet.charAt(v - 10));
                    break;
                case CHARACTERS_NUMBERS_SPECIAL:
                    int a = rand.nextInt(10 + alphabet.length() + special.length());
                    password.append(a < 10 ? a : a < 10 + alphabet.length() ? alphabet.charAt(a - 10) : special.charAt(a - 10 - alphabet.length()));
                    break;
            }
        }
        return password.toString();
    }

    public static String generatePassword(int length) {
        return generatePassword(length, PasswordType.CHARACTERS_NUMBERS_SPECIAL);
    }

    public static String generatePassword() {
        return generatePassword(16);
    }

    public enum PasswordType {
        CHARACTERS_ONLY, NUMBERS_ONLY, CHARACTERS_NUMBERS, CHARACTERS_NUMBERS_SPECIAL
    }

}