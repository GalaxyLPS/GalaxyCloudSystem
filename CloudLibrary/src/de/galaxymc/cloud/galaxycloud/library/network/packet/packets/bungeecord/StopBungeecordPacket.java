package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.bungeecord;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class StopBungeecordPacket extends Packet {

    private final int bungeecordId;

    public StopBungeecordPacket(int bungeecordId) {
        this.bungeecordId = bungeecordId;
    }

    public int getBungeecordId() {
        return bungeecordId;
    }
}
