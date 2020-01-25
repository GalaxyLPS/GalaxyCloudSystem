package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class StopMinecraftServerPacket extends Packet {

    private int serverId;

    public StopMinecraftServerPacket(int serverId) {
        this.serverId = serverId;
    }

    public int getServerId() {
        return serverId;
    }
}