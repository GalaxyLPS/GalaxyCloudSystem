package de.galaxymc.cloud.galaxycloud.library;

import de.galaxymc.cloud.galaxycloud.library.event.EventHandler;
import de.galaxymc.cloud.galaxycloud.library.exception.ExceptionHandleType;
import de.galaxymc.cloud.galaxycloud.library.exception.ExceptionHandler;
import de.galaxymc.cloud.galaxycloud.library.network.packet.PacketRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.group.MinecraftGroupRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.registry.MinecraftServerRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.template.MinecraftTemplateRegistry;
import de.galaxymc.cloud.galaxycloud.library.wrapper.CloudWrapperRegistry;

public class CloudLibrary {

    public static ExceptionHandler exceptionHandler = new ExceptionHandler(ExceptionHandleType.AUTO);
    public static PacketRegistry packetRegistry = new PacketRegistry();
    public static MinecraftServerRegistry minecraftServerRegistry = new MinecraftServerRegistry();
    public static MinecraftTemplateRegistry templateRegistry = new MinecraftTemplateRegistry();
    public static MinecraftGroupRegistry groupRegistry = new MinecraftGroupRegistry();
    private static CloudWrapperRegistry wrapperRegistry = new CloudWrapperRegistry();
    public static EventHandler eventHandler = new EventHandler();

}