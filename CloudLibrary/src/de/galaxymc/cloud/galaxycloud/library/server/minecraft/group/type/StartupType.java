package de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.type;

public enum StartupType {

    RANDOM, ROUND_ROBIN;

    public static StartupType fromString(String s) {
        switch (s) {
            case "rand":
            case "random":
                return RANDOM;
            default:
                return ROUND_ROBIN;
        }
    }

}