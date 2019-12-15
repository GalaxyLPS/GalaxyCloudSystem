package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.general.register;

import de.galaxymc.cloud.galaxycloud.library.network.client.type.CloudClientType;
import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class RegisterPacket extends Packet {

    private CloudClientType clientType;

    public RegisterPacket(CloudClientType clientType) {
        this.clientType = clientType;
    }

    public CloudClientType getClientType() {
        return clientType;
    }
}