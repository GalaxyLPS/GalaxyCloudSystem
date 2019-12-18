package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.log;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;

import java.util.ArrayList;

public class MinecraftConsoleFullLogPacket extends Packet {

    private String[] logs;
    private MinecraftServer server;

    public MinecraftConsoleFullLogPacket(String[] logs, MinecraftServer server) {
        this.logs = logs;
    }

    public MinecraftConsoleFullLogPacket(ArrayList<String> logs, MinecraftServer server) {
        String[] a = new String[logs.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = logs.get(i);
        }
        this.logs = a;
    }

    public String[] getLogs() {
        return logs;
    }

    public MinecraftServer getServer() {
        return server;
    }
}