package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.log;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;

public class MinecraftConsoleLogPacket extends Packet {

    private String log;
    private MinecraftServer server;

    public MinecraftConsoleLogPacket(String log, MinecraftServer server) {
        this.log = log;
        this.server = server;
    }

    public MinecraftServer getServer() {
        return server;
    }

    public String getLog() {
        return log;
    }
}