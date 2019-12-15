package de.galaxymc.cloud.galaxycloud.wrapper.file;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import de.galaxymc.cloud.galaxycloud.library.data.file.CloudSettingsFile;
import de.galaxymc.cloud.galaxycloud.wrapper.settings.WrapperSettings;

import java.io.File;

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

        JsonObject files = new JsonObject();
        JsonObject serverJars = new JsonObject();
        serverJars.addProperty("spigot", "/Wrapper/Default/Files/Server/Spigot/spigot.jar");
        files.add("Server Files", serverJars);
        defaults.add("Network", network);
        defaults.add("Minecraft", minecraftSettings);
        defaults.add("Files", files);
    }

    public WrapperSettings getSettings() {
        load();
        JsonObject minecraft = settings.getAsJsonObject("Minecraft");
        JsonObject network = settings.getAsJsonObject("Network");
        JsonPrimitive serverJar = settings.getAsJsonObject("Files").getAsJsonObject("Server Files").getAsJsonPrimitive("spigot");
        return new WrapperSettings(network.getAsJsonPrimitive("Port").getAsInt(), minecraft.getAsJsonObject("Port Range").getAsJsonPrimitive("Begin").getAsInt(), new File("./" + serverJar.getAsString()));
    }

}