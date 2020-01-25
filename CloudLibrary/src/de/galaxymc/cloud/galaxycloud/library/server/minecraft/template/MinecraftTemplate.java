package de.galaxymc.cloud.galaxycloud.library.server.minecraft.template;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.data.file.delete.DeleteType;
import de.galaxymc.cloud.galaxycloud.library.delete.Deletable;
import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;

// Minecraft Server Template
public class MinecraftTemplate implements CloudRegistryElement, Deletable {

    private String uuid;
    private int ram;
    private int maxPlayers;
    private String motd;
    private String name;

    public MinecraftTemplate(String uuid, int ram, int maxPlayers, String motd, String name) {
        this.uuid = uuid;
        this.ram = ram;
        this.maxPlayers = maxPlayers;
        this.motd = motd;
        this.name = name;
    }

    @Override
    public boolean delete() {
        return CloudLibrary.deleteAdapter.delete(this, DeleteType.TEMPLATE);
    }

    @Override
    public String getUUID() {
        return uuid;
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