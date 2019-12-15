package de.galaxymc.cloud.galaxycloud.library.network.client.settings;

import de.galaxymc.cloud.galaxycloud.library.network.client.type.CloudClientType;

public class CloudClientSettings {

    public String ip;
    public int port;
    public CloudClientType clientType;

    public CloudClientSettings(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}