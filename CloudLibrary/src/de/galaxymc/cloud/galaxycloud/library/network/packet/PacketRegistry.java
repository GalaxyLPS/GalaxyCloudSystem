package de.galaxymc.cloud.galaxycloud.library.network.packet;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistry;

import java.util.UUID;

public class PacketRegistry extends CloudRegistry<Packet> {

    public PacketRegistry(int size) {
        super(size);
    }

    public String register(Packet packet) {
        add(packet);
        return generateUUID();
    }


}