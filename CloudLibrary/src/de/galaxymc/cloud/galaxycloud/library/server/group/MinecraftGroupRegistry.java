package de.galaxymc.cloud.galaxycloud.library.server.group;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistry;
import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;

public class MinecraftGroupRegistry extends CloudRegistry<MinecraftGroup> {

    public MinecraftGroup byName(String s) {
        for (CloudRegistryElement cre : values) {
            if (cre instanceof MinecraftGroup) {
                MinecraftGroup mg = (MinecraftGroup) cre;
                if (mg.getName().equalsIgnoreCase(s)) {
                    return mg;
                }
            }
        }
        return null;
    }


}