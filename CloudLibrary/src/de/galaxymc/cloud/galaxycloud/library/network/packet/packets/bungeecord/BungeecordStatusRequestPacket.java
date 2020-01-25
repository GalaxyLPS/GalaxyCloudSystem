package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.bungeecord;


import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class BungeecordStatusRequestPacket extends Packet {

    private final int serverId;

    public BungeecordStatusRequestPacket(int serverId) {
        this.serverId = serverId;
    }

    public int getServerId() {
        return serverId;
    }
}
