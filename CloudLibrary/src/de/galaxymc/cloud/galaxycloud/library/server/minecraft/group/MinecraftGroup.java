package de.galaxymc.cloud.galaxycloud.library.server.minecraft.group;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.settings.MinecraftGroupSettings;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.type.MinecraftGroupType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.type.StartupType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.registry.MinecraftServerRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.settings.MinecraftServerSettings;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.template.MinecraftTemplate;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Random;


// List of Templates
public class MinecraftGroup implements CloudRegistryElement {

    String uuid;
    private MinecraftTemplate[] templates;
    private int lastTemplate;
    private MinecraftGroupType groupType;
    private String name;
    private int minSevers;
    private int maxServers; // -1 for unlimited
    private int serversPer20PlayersInGroup;
    private StartupType startupType;

    private MinecraftServerRegistry serverRegistry;
    private static File modificationFile = null;


    public MinecraftGroup(MinecraftGroupSettings groupSettings, int firstPort) {
        this.templates = groupSettings.getTemplates();
        this.groupType = groupSettings.getGroupType();
        this.name = groupSettings.getName();
        this.maxServers = groupSettings.getMaxServers();
        this.minSevers = groupSettings.getMinServers();
        this.startupType = groupSettings.getStartupType();
        if (maxServers < 0) maxServers = 0;
        if (minSevers > maxServers) minSevers = 0;
        this.serversPer20PlayersInGroup = groupSettings.getServersPer20Players();
    }

    public int playersInGroup() {
        return serverRegistry.itemCount();
    }

    public void openServer() {
        MinecraftServerSettings serverSettings = toSettings(nextTemplate());
        MinecraftServer server = new MinecraftServer(serverRegistry.generateUUID(), serverSettings, modificationFile, null);
        serverRegistry.add(server);
    }

    public void closeServer(int serverId) {
        serverRegistry.get(serverId).close();
        serverRegistry.remove(serverId);
    }

    private MinecraftTemplate nextTemplate() {
        switch (startupType) {
            case ROUND_ROBIN:
                if (lastTemplate + 1 >= templates.length) {
                    lastTemplate = 0;
                } else {
                    lastTemplate++;
                }
                return templates[lastTemplate];
            case RANDOM:
            default:
                return templates[new Random().nextInt(templates.length)];
        }
    }

    private MinecraftServerSettings toSettings(MinecraftTemplate template) {
        return new MinecraftServerSettings(this, 0 /* TODO: get port */, template.getMaxPlayers(), template.getRam(), template.getMotd());
    }

    public int lastPort() {
        return 0;
        // TODO: return last port
    }

    public List<MinecraftServer> getRunningServers() {
        return Collections.emptyList();
    }

    public String getName() {
        return name;
    }

    public int getMaxServers() {
        return maxServers;
    }

    public MinecraftGroupType getGroupType() {
        return groupType;
    }

    public MinecraftTemplate[] getTemplates() {
        return templates;
    }

    public int getMinSevers() {
        return minSevers;
    }

    public int getServersPer20PlayersInGroup() {
        return serversPer20PlayersInGroup;
    }

    public MinecraftServerRegistry getServerRegistry() {
        return serverRegistry;
    }


    @Override
    public String getUUID() {
        return null;
    }
}