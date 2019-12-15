package de.galaxymc.cloud.galaxycloud.wrapper.settings;

import java.io.File;

public class WrapperSettings {

    private int port;
    private int lowestPort;
    private File serverJar;

    public WrapperSettings(int port, int lowestPort, File serverJar) {
        this.port = port;
        this.serverJar = serverJar;
        this.lowestPort = lowestPort;
    }

    public int getPort() {
        return port;
    }

    public File getServerJar() {
        return serverJar;
    }

    public int getLowestPort() {
        return lowestPort;
    }
}