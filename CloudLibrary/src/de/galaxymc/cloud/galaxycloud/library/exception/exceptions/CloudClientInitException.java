package de.galaxymc.cloud.galaxycloud.library.exception.exceptions;

import de.galaxymc.cloud.galaxycloud.library.exception.GalaxyCloudException;
import de.galaxymc.cloud.galaxycloud.library.network.client.settings.CloudClientSettings;

public class CloudClientInitException extends GalaxyCloudException {

    private CloudClientSettings settings;
    private int currentAutoHandleDepth;
    private static final int maxAutoHandleDepth = 3;

    public CloudClientInitException(CloudClientSettings settings) {
        super("Cloud Client cloud not be initialized (" + settings.toString() + ")");
        this.settings = settings;
    }

    public CloudClientSettings getSettings() {
        return settings;
    }
}