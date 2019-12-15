package de.galaxymc.cloud.galaxycloud.wrapper;

import de.galaxymc.cloud.galaxycloud.library.network.client.CloudClient;
import de.galaxymc.cloud.galaxycloud.library.network.client.settings.CloudClientSettings;
import de.galaxymc.cloud.galaxycloud.library.network.client.type.CloudClientType;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.general.register.RegisterPacket;
import de.galaxymc.cloud.galaxycloud.library.server.MinecraftServer;
import de.galaxymc.cloud.galaxycloud.library.server.MinecraftServerType;
import de.galaxymc.cloud.galaxycloud.library.server.settings.MinecraftServerSettings;
import de.galaxymc.cloud.galaxycloud.wrapper.file.FileUtils;
import de.galaxymc.cloud.galaxycloud.wrapper.file.SettingsFile;
import de.galaxymc.cloud.galaxycloud.wrapper.settings.WrapperSettings;

public class Wrapper {

    CloudClient client;
    CloudClientSettings clientSettings;

    WrapperSettings settings;

    public Wrapper() {
        instance = this;
    }

    public void init() {
        settings = new SettingsFile().getSettings();
        clientSettings = new CloudClientSettings("localhost", settings.getPort());
        client = new CloudClient(clientSettings);
        client.bindStreams();
        client.listen();
        client.write(new RegisterPacket(CloudClientType.WRAPPER));
        FileUtils.clearTemp();
        MinecraftServerSettings serverSettings = new MinecraftServerSettings(settings.getLowestPort(), 512, 1024, "", MinecraftServerType.MINECRAFT);
        MinecraftServer server = new MinecraftServer(serverSettings, settings.getServerJar());
        server.start();
    }

    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper();
        wrapper.init();
    }

    public static Wrapper instance;
}