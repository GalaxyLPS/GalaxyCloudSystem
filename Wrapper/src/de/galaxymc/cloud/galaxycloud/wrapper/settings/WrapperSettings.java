package de.galaxymc.cloud.galaxycloud.wrapper.settings;

import de.galaxymc.cloud.galaxycloud.library.server.minecraft.modification.MinecraftModificationType;

public class WrapperSettings {

    private int port;
    private int lowestPort;
    private MinecraftModificationType modificationType;

    public WrapperSettings(int port, int lowestPort, MinecraftModificationType modificationType) {
        this.port = port;
        this.modificationType = modificationType;
        this.lowestPort = lowestPort;
    }

    public int getPort() {
        return port;
    }

    public MinecraftModificationType getModificationType() {
        return modificationType;
    }

    public int getLowestPort() {
        return lowestPort;
    }
}