package de.galaxymc.cloud.galaxycloud.wrapper;

import de.galaxymc.cloud.galaxycloud.library.network.client.CloudClient;
import de.galaxymc.cloud.galaxycloud.library.network.client.settings.CloudClientSettings;
import de.galaxymc.cloud.galaxycloud.library.network.client.type.CloudClientType;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.general.register.RegisterPacket;
import de.galaxymc.cloud.galaxycloud.wrapper.file.FileUtils;
import de.galaxymc.cloud.galaxycloud.wrapper.file.SettingsFile;
import de.galaxymc.cloud.galaxycloud.wrapper.settings.WrapperSettings;

public class Wrapper {

    public static Wrapper instance;
    private CloudClient client;
    private CloudClientSettings clientSettings;
    private WrapperSettings settings;
    private SettingsFile settingsFile;

    public Wrapper() {
        instance = this;
    }

    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper();
        wrapper.init();
    }

    public void init() {
        settingsFile = new SettingsFile();
        settings = settingsFile.getSettings();
        clientSettings = new CloudClientSettings(settings.getMasterIp(), settings.getPort());
        client = new CloudClient(clientSettings);
        client.bindStreams();
        client.listen();
        client.write(new RegisterPacket(CloudClientType.WRAPPER));
        FileUtils.clearTemp();
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