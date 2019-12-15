package de.galaxymc.cloud.galaxycloud.library.network.server.type;

public enum CloudServerType {

    MASTER, WRAPPER;

    public static CloudServerType fromString(String s) {
        switch (s.toLowerCase()) {
            case "master":
                return MASTER;
            case "wrapper":
                return WRAPPER;
            default:
                return null;
        }
    }
}