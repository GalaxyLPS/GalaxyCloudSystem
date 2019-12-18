package de.galaxymc.cloud.galaxycloud.library.server.minecraft.template;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;

// Minecraft Server Template
public class MinecraftTemplate implements CloudRegistryElement {

    private int ram;
    private int maxPlayers;
    private String motd;
    private String name;

    public MinecraftTemplate(int ram, int maxPlayers, String motd) {

    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getRam() {
        return ram;
    }

    public String getMotd() {
        return motd;
    }
}