package de.galaxymc.cloud.galaxycloud.library.message;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

public interface Writable {

    void write(Packet p);

}