package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.logger.Logger;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

public class VersionCommand implements CommandBase {

    Logger logger;

    @Override
    public void execute(String[] arguments) {
        logger.info(CloudLibrary.VERSION);
    }

    @Override
    public String getCommand() {
        return "version";
    }

    @Override
    public String getHelp() {
        return "version";
    }
}
