package de.galaxymc.cloud.galaxycloud.library.download;

public enum DownloadJarType {

    SPIGOT_1_8("https://cdn.getbukkit.org/spigot/spigot-1.8.8-R0.1-SNAPSHOT-latest.jar"),
    SPIGOT_1_9("https://cdn.getbukkit.org/spigot/spigot-1.9.4-R0.1-SNAPSHOT-latest.jar"),
    SPIGOT_1_10("https://cdn.getbukkit.org/spigot/spigot-1.10.2-R0.1-SNAPSHOT-latest.jar"),
    SPIGOT_1_11("https://cdn.getbukkit.org/spigot/spigot-1.11.2.jar"),
    SPIGOT_1_12("https://cdn.getbukkit.org/spigot/spigot-1.12.2.jar"),
    SPIGOT_1_13("https://cdn.getbukkit.org/spigot/spigot-1.13.2.jar"),
    SPIGOT_1_14("https://cdn.getbukkit.org/spigot/spigot-1.14.4.jar"),
    SPIGOT_1_15("https://cdn.getbukkit.org/spigot/spigot-1.15.1.jar");

    private String url;

    DownloadJarType(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}