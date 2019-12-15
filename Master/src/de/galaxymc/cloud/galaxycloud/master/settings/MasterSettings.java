package de.galaxymc.cloud.galaxycloud.master.settings;

public class MasterSettings {

    private int port;
    private int webPort;

    public MasterSettings(int port, int webPort) {
        this.port = port;
        this.webPort = webPort;
    }

    public int getPort() {
        return port;
    }

    public int getWebPort() {
        return webPort;
    }
}