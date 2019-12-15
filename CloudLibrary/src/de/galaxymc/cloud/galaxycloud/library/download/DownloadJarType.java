package de.galaxymc.cloud.galaxycloud.library.download;

public enum DownloadJarType {

    SPIGOT_1_8("https://cdn.getbukkit.org/spigot/spigot-1.8.8-R0.1-SNAPSHOT-latest.jar");

    private String url;

    DownloadJarType(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}