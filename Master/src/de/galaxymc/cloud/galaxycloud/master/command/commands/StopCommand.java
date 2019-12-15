package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.master.Master;
import de.galaxymc.cloud.galaxycloud.master.command.argument.CommandArgument;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

import java.util.ArrayList;

public class StopCommand implements CommandBase {

    @Override
    public void execute(ArrayList<CommandArgument> arguments) {
        Master.instance.stop();
        System.exit(0);
    }

    @Override
    public String getCommand() {
        return "stop";
    }

    @Override
    public String getHelp() {
        return "stop";
    }
}
