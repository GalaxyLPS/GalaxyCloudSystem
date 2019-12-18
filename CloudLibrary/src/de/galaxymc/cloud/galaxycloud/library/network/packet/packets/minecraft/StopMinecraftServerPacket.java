package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;

public class StopMinecraftServerPacket extends Packet {

    private MinecraftServer server;

    public StopMinecraftServerPacket(MinecraftServer server) {
        this.server = server;
    }

    public MinecraftServer getServer() {
        return server;
    }
}