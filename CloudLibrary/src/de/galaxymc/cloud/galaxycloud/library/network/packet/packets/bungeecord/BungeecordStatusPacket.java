package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.bungeecord;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class BungeecordStatusPacket extends Packet {

    private final int bungeecordId;

    // TODO: add bungeecord status

    public BungeecordStatusPacket(int bungeecordId) {
        this.bungeecordId = bungeecordId;
    }

    public int getBungeecordId() {
        return bungeecordId;
    }
}