package de.galaxymc.cloud.galaxycloud.master.command.commands;

import com.sun.jdi.connect.Connector;
import de.galaxymc.cloud.galaxycloud.library.logger.Logger;
import de.galaxymc.cloud.galaxycloud.master.Master;
import de.galaxymc.cloud.galaxycloud.master.command.argument.CommandArgument;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

import java.util.ArrayList;

public class HelpCommand implements CommandBase {

    @Override
    public void execute(ArrayList<CommandArgument> arguments) {
        if (arguments.size() == 0) {
            Logger.log("Help:");
            for (CommandBase c : Master.instance.getCommandHandler().getCommands()) {
                Logger.log("\t" + c.getCommand());
            }
        } else {
            CommandArgument arg = null;
            for (CommandArgument argument : arguments) {
                if (argument.getKey().equalsIgnoreCase("command")) {
                    arg = argument;
                }
            }
            for (CommandBase c : Master.instance.getCommandHandler().getCommands()) {
                if (arg.getValue().equalsIgnoreCase(c.getCommand())) {
                    Logger.log("Help:");
                    Logger.log("\t" + c.getHelp());
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
