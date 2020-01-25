package de.galaxymc.cloud.galaxycloud.library.server.minecraft.registry;

import de.galaxymc.cloud.galaxycloud.library.network.client.CloudClient;
import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.settings.MinecraftServerSettings;

import java.io.File;

public final class MinecraftServerRegistry extends CloudRegistry<MinecraftServer> {

    public MinecraftServerRegistry(int size) {
        super(size);
    }

    public MinecraftServerRegistry() {
        super(2556);
    }

    public MinecraftServer create(MinecraftServerSettings serverSettings, File modificationFile, CloudClient client) {
        MinecraftServer server = new MinecraftServer(generateUUID(), serverSettings, modificationFile, client);
        add(server);
        return server;
    }

}