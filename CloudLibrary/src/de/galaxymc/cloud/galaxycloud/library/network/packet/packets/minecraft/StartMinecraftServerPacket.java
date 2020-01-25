package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.settings.MinecraftServerSettings;

public class StartMinecraftServerPacket extends Packet {

    private final MinecraftServerSettings settings;

    public StartMinecraftServerPacket(MinecraftServerSettings settings) {
        this.settings = settings;
    }

    public MinecraftServerSettings getSettings() {
        return settings;
    }
}