package de.galaxymc.cloud.galaxycloud.library.security;

public enum SecurityMethod {

    DISABLED, AES, RSA, VIGENERE, CAESAR;

    public static SecurityMethod fromString(String s) {
        switch (s.toLowerCase()) {
            case "disabled":
            case "disable":
            case "off":
                return DISABLED;
            case "rsa":
                return RSA;
            case "vigenere":
                return VIGENERE;
            case "caesar":
                return CAESAR;
            case "default":
            case "aes":
            default:
                return AES;
        }
    }

}