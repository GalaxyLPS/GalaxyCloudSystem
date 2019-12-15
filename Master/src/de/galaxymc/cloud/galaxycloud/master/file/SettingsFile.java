package de.galaxymc.cloud.galaxycloud.master.file;

import com.google.gson.JsonObject;
import de.galaxymc.cloud.galaxycloud.library.data.file.CloudSettingsFile;
import de.galaxymc.cloud.galaxycloud.master.settings.MasterSettings;

public class SettingsFile extends CloudSettingsFile {

    public SettingsFile() {
        destination = "./Master/Settings/settings.gcloudconfig";
        defaults = new JsonObject();
        JsonObject network = new JsonObject();
        network.addProperty("Port", "23355");
        JsonObject web = new JsonObject();
        web.addProperty("Port", "23380");
        defaults.add("Network", network);
        defaults.add("Web", web);
    }

    public MasterSettings getSettings() {
        load();
        JsonObject network = settings.getAsJsonObject("Network");
        JsonObject web = settings.getAsJsonObject("Web");
        return new MasterSettings(network.getAsJsonPrimitive("Port").getAsInt(), web.getAsJsonPrimitive("Port").getAsInt());
    }

}