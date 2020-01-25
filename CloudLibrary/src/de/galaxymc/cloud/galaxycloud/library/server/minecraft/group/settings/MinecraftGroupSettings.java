package de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.settings;

import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.type.MinecraftGroupType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.type.StartupType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.template.MinecraftTemplate;

public class MinecraftGroupSettings {

    String name;
    MinecraftGroupType groupType;
    int maxServers;
    int minServers;
    int serversPer20Players;
    StartupType startupType;
    MinecraftTemplate[] templates;

    public MinecraftGroupSettings(String name, MinecraftGroupType groupType, int maxServers, int minServers, int serversPer20Players, StartupType startupType, MinecraftTemplate[] templates) {
        this.name = name;
        this.groupType = groupType;
        this.maxServers = maxServers;
        this.minServers = minServers;
        this.serversPer20Players = serversPer20Players;
        this.templates = templates;
        this.startupType = startupType;
    }

    public MinecraftGroupType getGroupType() {
        return groupType;
    }

    public String getName() {
        return name;
    }

    public int getMaxServers() {
        return maxServers;
    }

    public int getMinServers() {
        return minServers;
    }

    public int getServersPer20Players() {
        return serversPer20Players;
    }

    public MinecraftTemplate[] getTemplates() {
        return templates;
    }

    public StartupType getStartupType() {
        return startupType;
    }
}