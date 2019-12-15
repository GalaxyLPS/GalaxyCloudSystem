package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.MinecraftServer;

public class MinecraftServerStatusRequestPacket extends Packet {

    private MinecraftServer server;

    public MinecraftServerStatusRequestPacket(MinecraftServer server) {
        this.server = server;
    }

    public MinecraftServer getServer() {
        return server;
    }
}