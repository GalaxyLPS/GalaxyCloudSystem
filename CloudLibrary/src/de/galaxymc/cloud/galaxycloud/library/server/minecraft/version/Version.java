package de.galaxymc.cloud.galaxycloud.library.server.minecraft.version;

public enum Version {

    MC1_7_10,
    MC1_8,
    MC1_8_8,
    MC1_8_9,
    MC1_9,
    MC1_9_4,
    MC1_10,
    MC1_10_2,
    MC1_11,
    MC1_11_2,
    MC1_12,
    MC1_12_2,
    MC1_13,
    MC1_13_2,
    MC1_14,
    MC1_14_4;

    public static Version fromString(String s) {
        switch (s.toLowerCase()) {
            case "1.7.10":
                return MC1_7_10;
            case "1.8":
                return MC1_8;
            case "1.8.8":
                return MC1_8_8;
            case "1.8.9":
                return MC1_8_9;
            case "1.9":
                return MC1_9;
            case "1.9.4":
                return MC1_9_4;
            case "1.10":
                return MC1_10;
            case "1.10.2":
                return MC1_10_2;
            case "1.11":
                return MC1_11;
            case "1.11.2":
                return MC1_11_2;
            case "1.12":
                return MC1_12;
            case "1.12.2":
                return MC1_12_2;
            case "1.13":
                return MC1_13;
            case "1.13.2":
                return MC1_13_2;
            case "1.14":
                return MC1_14;
            case "1.14.4":
                return MC1_14_4;
            default:
                return null;
        }
    }

}