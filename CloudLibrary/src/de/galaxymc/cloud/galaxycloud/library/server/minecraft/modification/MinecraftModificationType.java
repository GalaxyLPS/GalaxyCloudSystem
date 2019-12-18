package de.galaxymc.cloud.galaxycloud.library.server.minecraft.modification;

public enum MinecraftModificationType {

    VANILLA("vanilla"), SPIGOT("spigot"), SPONGE("sponge"), CANARY_MOD("canary");

    private final String fileName;

    MinecraftModificationType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public static MinecraftModificationType fromString(String s) {
        switch (s.toLowerCase()) {
            case "vanilla":
                return VANILLA;
            case "spigot":
                return SPIGOT;
            case "sponge":
                return SPONGE;
            case "canary":
            case "canary mod":
            case "canarymod":
                return CANARY_MOD;
            default:
                return null;
        }
    }

}