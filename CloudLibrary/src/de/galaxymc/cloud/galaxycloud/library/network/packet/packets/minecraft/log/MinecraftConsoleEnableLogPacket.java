package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.log;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class MinecraftConsoleEnableLogPacket extends Packet {

    private final int serverId;

    public MinecraftConsoleEnableLogPacket(int serverId) {
        this.serverId = serverId;
    }

    public int getServerId() {
        return serverId;
    }
}