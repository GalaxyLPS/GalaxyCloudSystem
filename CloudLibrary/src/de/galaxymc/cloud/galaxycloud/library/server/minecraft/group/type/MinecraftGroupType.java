package de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.type;

public enum MinecraftGroupType {

    STATIC, DYNAMIC, LOBBY;

    public static MinecraftGroupType fromString(String s) {
        switch (s) {
            case "static":
            case "stat":
                return STATIC;
            case "dynamic":
            case "dyn":
                return DYNAMIC;
            case "lobby":
            case "lobb":
            case "lob":
                return LOBBY;
            default:
                return null;
        }
    }

}