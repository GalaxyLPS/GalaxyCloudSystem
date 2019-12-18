package de.galaxymc.cloud.galaxycloud.wrapper.file;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import de.galaxymc.cloud.galaxycloud.library.data.file.CloudSettingsFile;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.modification.MinecraftModificationType;
import de.galaxymc.cloud.galaxycloud.wrapper.settings.WrapperSettings;

public class SettingsFile extends CloudSettingsFile {

    public SettingsFile() {
        destination = "./Wrapper/Settings/settings.gcloudconfig";
        defaults = new JsonObject();
        JsonObject network = new JsonObject();
        JsonObject minecraftSettings = new JsonObject();
        JsonObject portRange = new JsonObject();
        portRange.addProperty("Begin", "25566");
        portRange.addProperty("End", "-1");
        minecraftSettings.add("Port Range", portRange);
        network.addProperty("Port", "23355");
        defaults.add("Network", network);
        defaults.add("Minecraft", minecraftSettings);
    }

    public WrapperSettings getSettings() {
        load();
        JsonObject minecraft = settings.getAsJsonObject("Minecraft");
        JsonObject network = settings.getAsJsonObject("Network");
        JsonPrimitive modificationType = minecraft.getAsJsonPrimitive("Modification Type");
        return new WrapperSettings(network.getAsJsonPrimitive("Port").getAsInt(), minecraft.getAsJsonObject("Port Range").getAsJsonPrimitive("Begin").getAsInt(), MinecraftModificationType.fromString(modificationType.getAsString()));
    }

}