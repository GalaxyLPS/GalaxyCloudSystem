package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.template;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class DeleteTemplatePacket extends Packet {

    private String templateUuid;

    public DeleteTemplatePacket(String templateId) {
        this.templateUuid = templateUuid;
    }

    public String getTemplateUuid() {
        return templateUuid;
    }
}