package de.galaxymc.cloud.galaxycloud.library.security;

public interface SecurityAlgorithm {

    String encrypt(String plain, String key);

    String decrypt(String encrypted, String key);


    default int shorten(int length, int maxLength) {
        if (length > maxLength) {
            length = shorten(length - maxLength, maxLength);
        }
        return length;
    }

    default String makeKeyLonger(String key, int length) {
        if (key.length() < length) {
            key = makeKeyLonger(key + key, length);
        }
        return key;
    }

    default int[] asIntArray(String s) {
        int[] a = new int[s.length()];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.charAt(i);
        }
        return a;
    }

    default byte[] asByteArray(String s) {
        byte[] a = new byte[s.length()];
        for (int i = 0; i < a.length; i++) {
            a[i] = (byte) s.charAt(i);
        }
        return a;
    }

}