package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.settings.MinecraftServerSettings;

public class MinecraftServerStatusPacket extends Packet {

    private final MinecraftServerSettings serverSettings;

    public MinecraftServerStatusPacket(MinecraftServerSettings serverSettings) {
        this.serverSettings = serverSettings;
    }

    public MinecraftServerSettings getServerSettings() {
        return serverSettings;
    }
}