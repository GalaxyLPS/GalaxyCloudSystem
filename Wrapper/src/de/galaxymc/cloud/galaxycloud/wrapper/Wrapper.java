package de.galaxymc.cloud.galaxycloud.wrapper;

import de.galaxymc.cloud.galaxycloud.library.network.client.CloudClient;
import de.galaxymc.cloud.galaxycloud.library.network.client.settings.CloudClientSettings;
import de.galaxymc.cloud.galaxycloud.library.network.client.type.CloudClientType;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.general.register.RegisterPacket;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.settings.MinecraftServerSettings;
import de.galaxymc.cloud.galaxycloud.wrapper.file.FileUtils;
import de.galaxymc.cloud.galaxycloud.wrapper.file.SettingsFile;
import de.galaxymc.cloud.galaxycloud.wrapper.file.StaticFileData;
import de.galaxymc.cloud.galaxycloud.wrapper.settings.WrapperSettings;

import java.io.File;

public class Wrapper {

    public static Wrapper instance;
    private CloudClient client;
    private CloudClientSettings clientSettings;
    private WrapperSettings settings;

    public Wrapper() {
        instance = this;
    }

    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper();
        wrapper.init();
    }

    public void init() {
        settings = new SettingsFile().getSettings();
        clientSettings = new CloudClientSettings("localhost", settings.getPort());
        client = new CloudClient(clientSettings);
        client.bindStreams();
        client.listen();
        client.write(new RegisterPacket(CloudClientType.WRAPPER));
        FileUtils.clearTemp();
        System.out.println("temp cleared");
        MinecraftServerSettings serverSettings = new MinecraftServerSettings(settings.getLowestPort(), 12, 1024, "");
        MinecraftServer server = new MinecraftServer(serverSettings, new File(StaticFileData.server + "/" + settings.getModificationType().getFileName() + ".jar"));
        server.start();
        server.listen();
    }

    public CloudClient getClient() {
        return client;
    }

    public CloudClientSettings getClientSettings() {
        return clientSettings;
    }

    public WrapperSettings getSettings() {
        return settings;
    }
}