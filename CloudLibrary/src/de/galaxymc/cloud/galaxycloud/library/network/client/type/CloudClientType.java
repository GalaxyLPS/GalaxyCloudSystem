package de.galaxymc.cloud.galaxycloud.library.network.client.type;

public enum CloudClientType {

    MASTER, WRAPPER, BUNGEECORD, SPIGOT, WEB, MOBILE, DESKTOP;

    public static CloudClientType fromString(String s) {
        switch (s.toLowerCase()) {
            case "master":
                return MASTER;
            case "wrapper":
                return WRAPPER;
            case "bungeecord":
                return BUNGEECORD;
            case "spigot":
                return SPIGOT;
            case "web":
                return WEB;
            case "mobile":
                return MOBILE;
            case "desktop":
                return DESKTOP;
            default:
                return null;
        }
    }
}