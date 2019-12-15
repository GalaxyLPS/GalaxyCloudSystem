package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.master.command.argument.CommandArgument;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

import java.util.ArrayList;

public class SetupGroupCommand implements CommandBase {

    @Override
    public void execute(ArrayList<CommandArgument> arguments) {

    }

    @Override
    public String getCommand() {
        return "group";
    }

    @Override
    public String getHelp() {
        return "group";
    }
}
