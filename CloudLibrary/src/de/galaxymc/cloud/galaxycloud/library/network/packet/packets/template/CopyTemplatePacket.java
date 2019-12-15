package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.template;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.template.MinecraftTemplate;

public class CopyTemplatePacket extends Packet {

    private MinecraftTemplate template;

    public CopyTemplatePacket(MinecraftTemplate template) {
        this.template = template;
    }

    public MinecraftTemplate getTemplate() {
        return template;
    }
}