package de.galaxymc.cloud.galaxycloud.master.event;

import de.galaxymc.cloud.galaxycloud.library.event.CloudListener;
import de.galaxymc.cloud.galaxycloud.library.event.EventMarker;
import de.galaxymc.cloud.galaxycloud.library.event.events.PacketReceiveEvent;
import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.general.register.RegisterPacket;

public class MasterListener implements CloudListener {

    @EventMarker
    public void onPacketReceive(PacketReceiveEvent event) {
        Packet packet = event.getPacket();
        if (packet instanceof RegisterPacket) {
            RegisterPacket p = (RegisterPacket) packet;
            event.getClient().getSettings().clientType = p.getClientType();
        }
    }

}