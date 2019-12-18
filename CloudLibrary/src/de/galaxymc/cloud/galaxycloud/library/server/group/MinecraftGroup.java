package de.galaxymc.cloud.galaxycloud.library.server.group;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.template.MinecraftTemplate;


// List of Templates
public class MinecraftGroup implements CloudRegistryElement {

    private MinecraftTemplate[] templates;
    private String name;
    private int minSevers;
    private int maxServers; // -1 for unlimited
    private int serversPer20PlayersInGroup;


    public MinecraftGroup() {

    }

    public String getName() {
        return name;
    }
}