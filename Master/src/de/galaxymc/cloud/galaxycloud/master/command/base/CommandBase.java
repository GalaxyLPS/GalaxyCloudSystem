package de.galaxymc.cloud.galaxycloud.master.command.base;

public interface CommandBase {

    void execute(String[] arguments);

    String getCommand();

    String getHelp();

}