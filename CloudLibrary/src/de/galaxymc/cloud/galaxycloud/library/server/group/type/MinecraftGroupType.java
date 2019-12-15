package de.galaxymc.cloud.galaxycloud.library.server.group.type;

public enum MinecraftGroupType {

    STATIC, DYNAMIC, LOBBY;

    public MinecraftGroupType fromString(String s) {
        switch (s) {
            case "static":
                return STATIC;
            case "dynamic":
                return DYNAMIC;
            case "lobby":
                return LOBBY;
            default:
                return null;
        }
    }

}