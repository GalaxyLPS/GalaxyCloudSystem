package de.galaxymc.cloud.galaxycloud.wrapper.file;

import com.google.gson.JsonObject;
import de.galaxymc.cloud.galaxycloud.library.data.file.CloudFile;
import de.galaxymc.cloud.galaxycloud.library.security.SecurityMethod;
import de.galaxymc.cloud.galaxycloud.wrapper.settings.WrapperSettings;

public class SettingsFile extends CloudFile {

    public SettingsFile() {
        super("./Wrapper/Settings/settings.gcloudconfig");
        JsonObject network = new JsonObject();
        JsonObject minecraftSettings = new JsonObject();
        JsonObject portRange = new JsonObject();
        JsonObject security = new JsonObject();
        security.addProperty("Method", SecurityMethod.defaultMethod.name());
        security.addProperty("Key", "");
        portRange.addProperty("Begin", "25566");
        minecraftSettings.add("Port Range", portRange);
        network.addProperty("MasterIp", "localhost");
        network.addProperty("Port", "23355");
        defaults.add("Network", network);
        defaults.add("Minecraft", minecraftSettings);
        defaults.add("Security", security);
    }

    public WrapperSettings getSettings() {
        load();
        JsonObject minecraft = content.getAsJsonObject("Minecraft");
        JsonObject network = content.getAsJsonObject("Network");
        JsonObject security = content.getAsJsonObject("Security");
        return new WrapperSettings(network.getAsJsonPrimitive("MasterIp").getAsString(), network.getAsJsonPrimitive("Port").getAsInt(), minecraft.getAsJsonObject("Port Range").getAsJsonPrimitive("Begin").getAsInt());
    }

}