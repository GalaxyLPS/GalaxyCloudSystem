package de.galaxymc.cloud.galaxycloud.wrapper.event;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.event.CloudListener;
import de.galaxymc.cloud.galaxycloud.library.event.EventMarker;
import de.galaxymc.cloud.galaxycloud.library.event.events.PacketReceiveEvent;
import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.bungeecord.BungeecordStatusRequestPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.bungeecord.StartBungeecordPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.bungeecord.StopBungeecordPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.MinecraftServerUpdatePacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.MinecraftServerUpdateRequestPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.StartMinecraftServerPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.StopMinecraftServerPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.log.MinecraftConsoleDisableLogPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.log.MinecraftConsoleEnableLogPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.minecraft.log.MinecraftConsoleFullLogRequestPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.response.ResponsePacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.template.CopyServerWorldPacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.packets.template.DeleteTemplatePacket;
import de.galaxymc.cloud.galaxycloud.library.network.packet.response.PacketResponse;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.MinecraftServer;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.template.MinecraftTemplate;
import de.galaxymc.cloud.galaxycloud.wrapper.Wrapper;

public class WrapperListener implements CloudListener {
    @EventMarker
    public void onPacketReceive(PacketReceiveEvent event) {
        Packet packet = event.getPacket();
        if (packet instanceof MinecraftServerUpdateRequestPacket) {
            MinecraftServerUpdateRequestPacket request = (MinecraftServerUpdateRequestPacket) packet;
            MinecraftServerUpdatePacket ret = new MinecraftServerUpdatePacket(CloudLibrary.minecraftServerRegistry.get(request.getServerId()));
            event.getClient().write(ret);
        } else if (packet instanceof BungeecordStatusRequestPacket) {

        } else if (packet instanceof StartBungeecordPacket) {

        } else if (packet instanceof StopBungeecordPacket) {

        } else if (packet instanceof MinecraftConsoleDisableLogPacket) {

        } else if (packet instanceof MinecraftConsoleEnableLogPacket) {

        } else if (packet instanceof MinecraftConsoleFullLogRequestPacket) {

        } else if (packet instanceof StartMinecraftServerPacket) {
            StartMinecraftServerPacket p = (StartMinecraftServerPacket) packet;
            MinecraftServer server = CloudLibrary.minecraftServerRegistry.create(p.getSettings(), Wrapper.instance.getSettings().getModificationFile(), event.getClient());
            CloudLibrary.minecraftServerRegistry.add(server);
            server.start();
            ResponsePacket response = new ResponsePacket(PacketResponse.SUCCESS, p.getUUID());
            event.getClient().write(response);
        } else if (packet instanceof StopMinecraftServerPacket) {
            StopMinecraftServerPacket p = (StopMinecraftServerPacket) packet;
            MinecraftServer server = CloudLibrary.minecraftServerRegistry.get(p.getServerId());
            server.close();
            ResponsePacket response;
            if (server.isAlive()) {
                response = new ResponsePacket(PacketResponse.SUCCESS, packet.getUUID());
            } else {
                response = new ResponsePacket(PacketResponse.TARGET_NOT_FOUND, packet.getUUID());
            }
            event.getClient().write(response);
        } else if (packet instanceof CopyServerWorldPacket) {

        } else if (packet instanceof DeleteTemplatePacket) {
            DeleteTemplatePacket p = (DeleteTemplatePacket) packet;
            MinecraftTemplate template = CloudLibrary.templateRegistry.getByUuid(p.getTemplateUuid());

        }
    }

}
