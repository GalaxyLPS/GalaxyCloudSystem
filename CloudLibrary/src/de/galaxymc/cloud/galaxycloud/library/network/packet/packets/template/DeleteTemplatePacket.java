package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.template;

import de.galaxymc.cloud.galaxycloud.library.server.template.MinecraftTemplate;

public class DeleteTemplatePacket {

    private MinecraftTemplate template;

    public DeleteTemplatePacket(MinecraftTemplate template) {
        this.template = template;
    }

    public MinecraftTemplate getTemplate() {
        return template;
    }
}