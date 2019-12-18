package de.galaxymc.cloud.galaxycloud.library.server.minecraft.template;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistry;
import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;

public class MinecraftTemplateRegistry extends CloudRegistry<MinecraftTemplate> {

    public MinecraftTemplate byName(String s) {
        for (CloudRegistryElement cre : values) {
            if (cre instanceof MinecraftTemplate) {
                MinecraftTemplate mct = (MinecraftTemplate) cre;
                if (mct.getName().equalsIgnoreCase(s)) {
                    return mct;
                }
            }
        }
        return null;
    }

}