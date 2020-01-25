package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.library.logger.Logger;
import de.galaxymc.cloud.galaxycloud.master.Master;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

public class HelpCommand implements CommandBase {

    Logger logger;

    public HelpCommand() {
        logger = new Logger("HelpCommand");
    }

    @Override
    public void execute(String[] arguments) {
        if (arguments.length == 0) {
            logger.info("Help for all commands:");
            for (CommandBase c : Master.instance.getCommandHandler().getCommands()) {
                logger.info("\t" + c.getCommand());
            }
        } else if (arguments.length == 1) {
            String command = arguments[0];
            logger.info("Help for " + command + ":");
            for (CommandBase c : Master.instance.getCommandHandler().getCommands()) {
                if (c.getCommand().equalsIgnoreCase(command)) {
                    logger.info("\t" + c.getCommand());
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
