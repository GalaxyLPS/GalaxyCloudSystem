package de.galaxymc.cloud.galaxycloud.library.security;

import de.galaxymc.cloud.galaxycloud.library.generator.PasswordGenerator;

public enum SecurityMethod {

    DISABLED(new SecurityAlgorithm() {
        @Override
        public String encrypt(String plain, String key) {
            return plain;
        }

        @Override
        public String decrypt(String encrypted, String key) {
            return encrypted;
        }
    }),
    AES(new SecurityAlgorithm() {
        @Override
        public String encrypt(String plain, String key) {

            return null;
        }

        @Override
        public String decrypt(String encrypted, String key) {

            return null;
        }
    }),
    RSA(new SecurityAlgorithm() {
        @Override
        public String encrypt(String plain, String key) {
            return null;
        }

        @Override
        public String decrypt(String encrypted, String key) {
            return null;
        }
    }),
    VIGENERE(new SecurityAlgorithm() {
        @Override
        public String encrypt(String plain, String key) {
            return vigenere(plain, key, true);
        }

        @Override
        public String decrypt(String encrypted, String key) {
            return vigenere(encrypted, key, false);
        }

        private String vigenere(String s, String key, boolean direction) {
            StringBuilder plain = new StringBuilder();
            key = makeKeyLonger(key, s.length());
            for (int i = 0; i < s.length(); i++) {
                if (direction)
                    plain.append((char) (((int) s.charAt(i)) + ((int) key.charAt(i))));
                else
                    plain.append((char) (((int) s.charAt(i)) - ((int) key.charAt(i))));
            }
            return plain.toString();
        }
    }),
    CAESAR(new SecurityAlgorithm() {
        @Override
        public String encrypt(String plain, String key) {
            return caesar(plain, Integer.parseInt(key));
        }

        @Override
        public String decrypt(String encrypted, String key) {
            return caesar(encrypted, Integer.parseInt(key) * (-1));
        }

        private String caesar(String s, int key) {
            StringBuilder plain = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                plain.append((char) (((int) s.charAt(i)) + key));
            }
            return plain.toString();
        }

    }),
    OTP(new SecurityAlgorithm() {
        @Override
        public String encrypt(String plain, String key) {
            return otp(plain, key);
        }

        @Override
        public String decrypt(String encrypted, String key) {
            return otp(encrypted, key);
        }

        private String otp(String s, String key) {
            StringBuilder plain = new StringBuilder();
            key = makeKeyLonger(key, s.length());
            for (int i = 0; i < s.length(); i++) {
                plain.append((char) (s.charAt(i) ^ key.charAt(i)));
            }
            return plain.toString();
        }
    });

    private SecurityAlgorithm securityAlgorithm;

    SecurityMethod(SecurityAlgorithm securityAlgorithm) {
        this.securityAlgorithm = securityAlgorithm;
    }

    public String decrypt(String encrypted, String key) {
        return securityAlgorithm.decrypt(encrypted, key);
    }

    public String encrypt(String plain, String key) {
        return securityAlgorithm.encrypt(plain, key);
    }


    public static String generateKey(SecurityMethod sm) {
        switch (sm) {
            case OTP:
            case VIGENERE:
                return PasswordGenerator.generatePassword(32);
            case CAESAR:
                return PasswordGenerator.generatePassword(2, PasswordGenerator.PasswordType.NUMBERS_ONLY);
            case DISABLED:
                return "";
            case AES:
            case RSA:
                break;
        }
        return null;
    }

    public static SecurityMethod fromString(String s) {
        switch (s.toLowerCase()) {
            case "disabled":
            case "disable":
            case "off":
            case "none":
                return DISABLED;
            case "rsa":
                return RSA;
            case "vigenere":
                return VIGENERE;
            case "caesar":
                return CAESAR;
            case "otp":
            case "onetimepad":
                return OTP;
            case "default":
            case "aes":
            default:
                return AES;
        }
    }

    public static final SecurityMethod defaultMethod = DISABLED;

}