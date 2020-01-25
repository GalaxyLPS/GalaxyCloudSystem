package de.galaxymc.cloud.galaxycloud.library.wrapper;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;

public class CloudWrapper implements CloudRegistryElement {

    String uuid;
    int usage;

    @Override
    public String getUUID() {
        return uuid;
    }
}