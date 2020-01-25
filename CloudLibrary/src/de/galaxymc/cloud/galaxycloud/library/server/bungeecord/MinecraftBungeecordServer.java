package de.galaxymc.cloud.galaxycloud.library.server.bungeecord;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;

public class MinecraftBungeecordServer implements CloudRegistryElement {

    String uuid;

    @Override
    public String getUUID() {
        return uuid;
    }
}
