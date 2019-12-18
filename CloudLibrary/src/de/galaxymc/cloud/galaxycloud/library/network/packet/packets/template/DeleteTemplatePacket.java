package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.template;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.template.MinecraftTemplate;

public class DeleteTemplatePacket extends Packet {

    private MinecraftTemplate template;

    public DeleteTemplatePacket(MinecraftTemplate template) {
        this.template = template;
    }

    public MinecraftTemplate getTemplate() {
        return template;
    }
}