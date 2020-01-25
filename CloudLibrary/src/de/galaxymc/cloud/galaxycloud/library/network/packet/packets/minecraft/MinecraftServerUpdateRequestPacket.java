package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class MinecraftServerUpdateRequestPacket extends Packet {

    private final int serverId;

    public MinecraftServerUpdateRequestPacket(int serverId) {
        this.serverId = serverId;
    }

    public int getServerId() {
        return serverId;
    }
}
