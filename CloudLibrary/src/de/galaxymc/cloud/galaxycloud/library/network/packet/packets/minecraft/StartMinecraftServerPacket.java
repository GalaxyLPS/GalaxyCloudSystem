package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.server.MinecraftServer;

public class StartMinecraftServerPacket {

    private MinecraftServer server;

    public StartMinecraftServerPacket(MinecraftServer server) {
        this.server = server;
    }
}