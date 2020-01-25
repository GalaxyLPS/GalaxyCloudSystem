package de.galaxymc.cloud.galaxycloud.master.file;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.data.file.CloudFile;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.settings.MinecraftGroupSettings;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.type.MinecraftGroupType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.type.StartupType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.template.MinecraftTemplate;

import java.util.ArrayList;

public class GroupsFile extends CloudFile {

    public GroupsFile() {
        super("./Master/Settings/Group/groups.gcloudconfig"); // TODO: get path from variable and check file ending and check other files for same problems
    }

    public void init() {
        defaults.add("global", new JsonObject());
        JsonArray groups = new JsonArray();
        defaults.add("groups", groups);
    }

    public MinecraftGroupSettings[] getSettings() {
        ArrayList<MinecraftGroupSettings> groupSettings = new ArrayList<>();
        JsonArray groups = content.getAsJsonArray("groups");
        groups.forEach(g -> {
            JsonObject group = g.getAsJsonObject();
            String name = group.get("name").getAsString();
            MinecraftGroupType groupType = MinecraftGroupType.fromString(group.get("Type").getAsString());
            int maxServers = group.get("maxServers").getAsInt();
            int minServers = group.get("minServers").getAsInt();
            int serversPer20Players = group.get("serversPer20Players").getAsInt();
            StartupType startupType = StartupType.fromString(group.get("").getAsString());
            JsonArray ids = group.getAsJsonArray("templateNames");
            MinecraftTemplate[] templates = new MinecraftTemplate[ids.size()]; // randomly selected, round robin
            for (int i = 0; i < ids.size(); i++) {
                MinecraftTemplate template = CloudLibrary.templateRegistry.byName(ids.get(i).getAsString());
                templates[i] = template;
            }
            groupSettings.add(new MinecraftGroupSettings(name, groupType, maxServers, minServers, serversPer20Players, startupType, templates));
        });
        MinecraftGroupSettings[] r = new MinecraftGroupSettings[groupSettings.size()];
        groupSettings.forEach(group -> {
            int index = groupSettings.indexOf(group);
            r[index] = group;
        });
        return r;
    }

}