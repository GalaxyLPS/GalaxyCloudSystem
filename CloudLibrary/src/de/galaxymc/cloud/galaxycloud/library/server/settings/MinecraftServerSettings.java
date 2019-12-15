package de.galaxymc.cloud.galaxycloud.library.server.settings;

import de.galaxymc.cloud.galaxycloud.library.server.MinecraftServerState;
import de.galaxymc.cloud.galaxycloud.library.server.MinecraftServerType;

public class MinecraftServerSettings {

    private final boolean onlineMode;
    private final int port;
    private int maxPlayers;
    private int currentPlayers;
    private final int maxRam;
    private final long startup;
    private String motd;
    private final MinecraftServerType serverType;
    private MinecraftServerState serverState;

    public MinecraftServerSettings(int port, int maxPlayers, int maxRam, String motd, MinecraftServerType type) {
        this.port = port;
        this.maxPlayers = maxPlayers;
        this.maxRam = maxRam;
        this.motd = motd;
        this.serverType = type;
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

    public MinecraftServerType getServerType() {
        return serverType;
    }

    public MinecraftServerState getServerState() {
        return serverState;
    }

    public void setServerState(MinecraftServerState serverState) {
        this.serverState = serverState;
    }
}