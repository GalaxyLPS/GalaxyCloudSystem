package de.galaxymc.cloud.galaxycloud.master.file;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.galaxymc.cloud.galaxycloud.library.data.file.CloudSettingsFile;
import de.galaxymc.cloud.galaxycloud.library.security.SecurityMethod;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.modification.MinecraftModificationType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.version.Version;
import de.galaxymc.cloud.galaxycloud.library.server.operator.Operator;
import de.galaxymc.cloud.galaxycloud.master.settings.MasterSettings;

import java.util.ArrayList;

public class SettingsFile extends CloudSettingsFile {

    public SettingsFile() {
        destination = "./Master/Settings/settings.gcloudconfig";
        defaults = new JsonObject();
        JsonObject network = new JsonObject();
        network.addProperty("Port", "23355");

        JsonObject web = new JsonObject();
        web.addProperty("Port", "23380");

        JsonArray operators = new JsonArray();
        operators.add("GalaxyLPS:???");

        JsonObject security = new JsonObject();
        security.addProperty("Security Method", SecurityMethod.AES.name());
        security.addProperty("Enable Operators", "true");

        JsonObject minecraft = new JsonObject();
        minecraft.addProperty("Modification", MinecraftModificationType.SPIGOT.name());
        minecraft.addProperty("Version", Version.MC1_8_9.name());
        minecraft.add("Operators", operators);

        defaults.add("Network", network);
        defaults.add("Minecraft", minecraft);
        defaults.add("Web", web);
        defaults.add("Security", security);
    }

    public MasterSettings getSettings() {
        load();
        JsonObject network = settings.getAsJsonObject("Network");
        JsonObject web = settings.getAsJsonObject("Web");
        JsonObject minecraft = settings.getAsJsonObject("Minecraft");
        JsonObject security = settings.getAsJsonObject("Security");

        int port = network.getAsJsonPrimitive("Port").getAsInt();

        int webPort = web.getAsJsonPrimitive("Port").getAsInt();

        SecurityMethod securityMethod = SecurityMethod.fromString(security.getAsJsonPrimitive("Security Method").getAsString());
        boolean useOperators = security.getAsJsonPrimitive("Enable Operators").getAsBoolean();


        JsonArray jsonOperators = minecraft.getAsJsonArray("Operators");
        ArrayList<Operator> operators = new ArrayList<>();
        for (JsonElement e : jsonOperators) {
            String s = e.getAsString();
            operators.add(new Operator(s.split(":")[0], s.split(":")[1]));
        }
        MinecraftModificationType modificationType = MinecraftModificationType.fromString(minecraft.getAsJsonPrimitive("Modification").getAsString());
        Version version = Version.fromString(minecraft.getAsJsonPrimitive("Version").getAsString());

        return new MasterSettings(port, webPort, useOperators, operators, securityMethod, modificationType, version);
    }

}