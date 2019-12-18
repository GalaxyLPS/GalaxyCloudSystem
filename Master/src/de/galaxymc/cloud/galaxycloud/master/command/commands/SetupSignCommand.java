package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

public class SetupSignCommand  implements CommandBase {

    @Override
    public void execute(String[] arguments) {

    }

    @Override
    public String getCommand() {
        return "sign";
    }

    @Override
    public String getHelp() {
        return "sign <Name>";
    }
}
