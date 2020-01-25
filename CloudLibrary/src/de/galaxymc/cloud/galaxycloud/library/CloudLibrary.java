package de.galaxymc.cloud.galaxycloud.library;

import de.galaxymc.cloud.galaxycloud.library.console.Console;
import de.galaxymc.cloud.galaxycloud.library.console.linux.LinuxConsole;
import de.galaxymc.cloud.galaxycloud.library.console.windows.WindowsConsole;
import de.galaxymc.cloud.galaxycloud.library.data.file.delete.DeleteAdapter;
import de.galaxymc.cloud.galaxycloud.library.event.EventHandler;
import de.galaxymc.cloud.galaxycloud.library.exception.ExceptionHandleType;
import de.galaxymc.cloud.galaxycloud.library.exception.ExceptionHandler;
import de.galaxymc.cloud.galaxycloud.library.machine.MachineInformation;
import de.galaxymc.cloud.galaxycloud.library.machine.OperatingSystem;
import de.galaxymc.cloud.galaxycloud.library.network.packet.PacketRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.MinecraftGroupRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.registry.MinecraftServerRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.template.MinecraftTemplateRegistry;
import de.galaxymc.cloud.galaxycloud.library.wrapper.CloudWrapperRegistry;

public class CloudLibrary {

    public static ExceptionHandler exceptionHandler = new ExceptionHandler(ExceptionHandleType.AUTO);
    public static PacketRegistry packetRegistry = new PacketRegistry(9999);
    public static MinecraftServerRegistry minecraftServerRegistry = new MinecraftServerRegistry();
    public static MinecraftTemplateRegistry templateRegistry = new MinecraftTemplateRegistry();
    public static MinecraftGroupRegistry groupRegistry = new MinecraftGroupRegistry();
    private static CloudWrapperRegistry wrapperRegistry = new CloudWrapperRegistry();
    public static EventHandler eventHandler = new EventHandler();

    public static DeleteAdapter deleteAdapter;

    public static final String VERSION = "0.0.1:ALPHA/CLOSED";
    public static boolean enableDebugOutput = true;
    public static Console console = MachineInformation.operatingSystem == OperatingSystem.WINDOWS ? new WindowsConsole() : new LinuxConsole();

}