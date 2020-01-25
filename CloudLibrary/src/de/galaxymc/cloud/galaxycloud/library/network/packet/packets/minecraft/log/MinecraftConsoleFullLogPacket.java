package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.log;

import de.galaxymc.cloud.galaxycloud.library.console.ConsoleLog;
import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;

import java.util.ArrayList;
import java.util.Arrays;

public class MinecraftConsoleFullLogPacket extends Packet {

    private ConsoleLog[] logs;
    private MinecraftServer server;

    public MinecraftConsoleFullLogPacket(ConsoleLog[] logs, MinecraftServer server) {
        this.logs = logs;
    }

    public MinecraftConsoleFullLogPacket(ArrayList<ConsoleLog> logs, MinecraftServer server) {
        ConsoleLog[] a = new ConsoleLog[logs.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = logs.get(i);
        }
        this.logs = a;
    }

    public String[] getLogs() {
        return (String[]) Arrays.stream(logs).map(ConsoleLog::getLog).toArray();
    }

    public MinecraftServer getServer() {
        return server;
    }
}