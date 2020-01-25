package de.galaxymc.cloud.galaxycloud.library.machine;

public enum OperatingSystem {

    MAC, LINUX, SOLARIS, WINDOWS;

    public static OperatingSystem fromPropertyName(String property) {
        property = property.toLowerCase();
        if (property.contains("windows")) return WINDOWS;
        if (property.contains("mac")) return MAC;
        if (property.contains("linux") || property.contains("freebsd")) return LINUX;
        if (property.contains("sunos")) return SOLARIS;
        return null;
    }

}