package de.galaxymc.cloud.galaxycloud.wrapper.settings;

import de.galaxymc.cloud.galaxycloud.library.server.minecraft.modification.MinecraftModificationType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.version.Version;
import de.galaxymc.cloud.galaxycloud.wrapper.file.StaticFileData;

import java.io.File;

public class WrapperSettings {

    private int port;
    private int lowestPort;
    private final String masterIp;
    private final MinecraftModificationType modificationType = MinecraftModificationType.SPIGOT;
    private final Version version = Version.MC1_8_9;

    public WrapperSettings(String masterIp, int port, int lowestPort) {
        this.masterIp = masterIp;
        this.port = port;
        this.lowestPort = lowestPort;
    }

    public int getPort() {
        return port;
    }

    public int getLowestPort() {
        return lowestPort;
    }

    public MinecraftModificationType getModificationType() {
        return modificationType;
    }

    public Version getVersion() {
        return version;
    }

    public String getMasterIp() {
        return masterIp;
    }

    public File getModificationFile() {
        return new File(StaticFileData.modifications + "/" + modificationType.getFileName());
    }
}