package de.galaxymc.cloud.galaxycloud.library.machine;

public class MachineInformation {

    public static OperatingSystem operatingSystem = OperatingSystem.fromPropertyName(System.getProperty("os.name"));

}