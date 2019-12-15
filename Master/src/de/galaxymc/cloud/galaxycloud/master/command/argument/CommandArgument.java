package de.galaxymc.cloud.galaxycloud.master.command.argument;

public class CommandArgument {

    private static final String SEPARATOR = "=";

    private String key;
    private String value;

    public CommandArgument(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
