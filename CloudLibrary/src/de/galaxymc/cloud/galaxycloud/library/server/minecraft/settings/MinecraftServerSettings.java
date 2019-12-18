package de.galaxymc.cloud.galaxycloud.library.server.minecraft.settings;

import de.galaxymc.cloud.galaxycloud.library.server.group.MinecraftGroup;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.state.MinecraftServerState;

public class MinecraftServerSettings {

    private final boolean onlineMode;
    private final int port;
    private int maxPlayers;
    private int currentPlayers;
    private final int maxRam;
    private final long startup;
    private String motd;
    private MinecraftServerState serverState;
    private MinecraftGroup group;

    public MinecraftServerSettings(int port, int maxPlayers, int maxRam, String motd) {
        this.port = port;
        this.maxPlayers = maxPlayers;
        this.maxRam = maxRam;
        this.motd = motd;
        this.currentPlayers = 0;
        this.serverState = MinecraftServerState.LOBBY;
        this.startup = System.currentTimeMillis();
        this.onlineMode = false;
    }

    public long uptime() {
        return System.currentTimeMillis() - this.startup;
    }

    public boolean isOnlineMode() {
        return onlineMode;
    }

    public int getPort() {
        return port;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getCurrentPlayers() {
        return currentPlayers;
    }

    public void setCurrentPlayers(int currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    public int getMaxRam() {
        return maxRam;
    }

    public long getStartup() {
        return startup;
    }

    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    public MinecraftGroup getGroup() {
        return group;
    }

    public MinecraftServerState getServerState() {
        return serverState;
    }

    public void setServerState(MinecraftServerState serverState) {
        this.serverState = serverState;
    }
}