package de.galaxymc.cloud.galaxycloud.library.exception.exceptions;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.exception.GalaxyCloudException;
import de.galaxymc.cloud.galaxycloud.library.network.server.settings.CloudServerSettings;

import java.io.IOException;
import java.net.ServerSocket;

public class CloudServerInitException extends GalaxyCloudException {

    private CloudServerSettings settings;
    private int currentAutoHandleDepth;
    private static final int maxAutoHandleDepth = 3;

    public CloudServerInitException(CloudServerSettings settings) {
        super("Cloud Server cloud not be initialized (" + settings.toString() + ")");
        this.settings = settings;
        currentAutoHandleDepth = 0;
    }

    public CloudServerInitException(CloudServerSettings settings, int currentAutoHandleDepth) {
        this.settings = settings;
        this.currentAutoHandleDepth = currentAutoHandleDepth;
    }

    public ServerSocket autoHandle() {
        if (currentAutoHandleDepth >= maxAutoHandleDepth) throw this;
        ServerSocket socket;
        try {
            socket = new ServerSocket(settings.port++);
        } catch (IOException e) {
            currentAutoHandleDepth++;
            socket = (ServerSocket) CloudLibrary.exceptionHandler.throwException(this);
        }
        return socket;
    }

}