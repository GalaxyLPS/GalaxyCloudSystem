package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;

public class StartMinecraftServerPacket extends Packet {

    private MinecraftServer server;

    public StartMinecraftServerPacket(MinecraftServer server) {
        this.server = server;
    }

    public MinecraftServer getServer() {
        return server;
    }
}