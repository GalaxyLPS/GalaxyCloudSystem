package de.galaxymc.cloud.galaxycloud.library.network.packet.packets.response;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.network.packet.response.PacketResponse;

public class ResponsePacket extends Packet {

    private final PacketResponse response;
    private final String responseUuid;

    public ResponsePacket(PacketResponse response, String responseUuid) {
        super(CloudLibrary.packetRegistry);
        this.response = response;
        this.responseUuid = responseUuid;
    }

    public String responseUuid() {
        return responseUuid;
    }

    public PacketResponse getResponse() {
        return response;
    }
}