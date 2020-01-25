package de.galaxymc.cloud.galaxycloud.library.network.packet;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;

import java.io.Serializable;

public abstract class Packet implements CloudRegistryElement, Serializable {

    protected final String packetUuid;

    protected Packet(String packetUuid) {
        this.packetUuid = packetUuid;
    }

    protected Packet(PacketRegistry registry) {
        this.packetUuid = registry.register(this);
    }

    protected Packet() {
        this.packetUuid = CloudLibrary.packetRegistry.register(this);
    }

    @Override
    public String getUUID() {
        return null;
    }
}