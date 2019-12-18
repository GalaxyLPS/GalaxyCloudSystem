package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.master.Master;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

public class StopCommand implements CommandBase {

    @Override
    public void execute(String[] arguments) {
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
