package de.galaxymc.cloud.galaxycloud.library.event.events;

import de.galaxymc.cloud.galaxycloud.library.event.ICloudEvent;
import de.galaxymc.cloud.galaxycloud.library.network.client.CloudClient;
import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public class PacketReceiveEvent implements ICloudEvent {

    private CloudClient client;
    private Packet packet;

    public PacketReceiveEvent(CloudClient client, Packet packet) {
        this.client = client;
        this.packet = packet;
    }

    public CloudClient getClient() {
        return client;
    }

    public Packet getPacket() {
        return packet;
    }
}