package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.library.logger.Logger;
import de.galaxymc.cloud.galaxycloud.master.Master;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

public class HelpCommand implements CommandBase {

    @Override
    public void execute(String[] arguments) {
        if (arguments.length == 0) {
            Logger.log("Help for all commands:");
            for (CommandBase c : Master.instance.getCommandHandler().getCommands()) {
                Logger.log("\t" + c.getCommand());
            }
        } else if (arguments.length == 1) {
            String command = arguments[0];
            Logger.log("Help for " + command + ":");
            for (CommandBase c : Master.instance.getCommandHandler().getCommands()) {
                if (c.getCommand().equalsIgnoreCase(command)) {
                    Logger.log("\t" + c.getCommand());
                }
            }
        }
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "help <Command>";
    }
}
