package de.galaxymc.cloud.galaxycloud.master.command.base;

import de.galaxymc.cloud.galaxycloud.master.command.argument.CommandArgument;

import java.util.ArrayList;

public interface CommandBase {

    public void execute(ArrayList<CommandArgument> arguments);

    public String getCommand();

    public String getHelp();

}