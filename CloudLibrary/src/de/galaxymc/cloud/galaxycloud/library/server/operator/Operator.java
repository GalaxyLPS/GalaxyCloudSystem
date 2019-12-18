package de.galaxymc.cloud.galaxycloud.library.server.operator;

public class Operator {

    private String name;
    private String uuid;

    public Operator(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }
}