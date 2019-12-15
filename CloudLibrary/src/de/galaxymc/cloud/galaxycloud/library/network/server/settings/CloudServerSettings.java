package de.galaxymc.cloud.galaxycloud.library.network.server.settings;

public class CloudServerSettings {

    public int port;
    public int clients;
    public int maxClients;
    public long startup;

    public CloudServerSettings(int port, int maxClients) {
        this.port = port;
        this.maxClients = maxClients;
        this.startup = System.currentTimeMillis();
    }

    public long getStartup() {
        return startup;
    }

    public long getUptime() {
        return System.currentTimeMillis() - startup;
    }

    @Override
    public String toString() {
        return "CloudServerSettings{" +
                "port=" + port +
                ", clients=" + clients +
                ", maxClients=" + maxClients +
                ", uptime(" + startup + ")=" + getUptime() +
                '}';
    }
}