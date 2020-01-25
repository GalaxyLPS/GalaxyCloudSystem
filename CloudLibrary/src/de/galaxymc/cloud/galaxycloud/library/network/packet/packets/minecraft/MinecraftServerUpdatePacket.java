package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;

public class MinecraftServerUpdatePacket extends Packet {

    private final MinecraftServer server;

    public MinecraftServerUpdatePacket(MinecraftServer server) {
        this.server = server;
    }

    public MinecraftServer getServer() {
        return server;
    }

    @Override
    public String getUUID() {
        return super.packetUuid;
    }
}