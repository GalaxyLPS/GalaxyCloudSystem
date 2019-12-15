package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.master.command.argument.CommandArgument;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

import java.util.ArrayList;

public class SetupSignCommand  implements CommandBase {

    @Override
    public void execute(ArrayList<CommandArgument> arguments) {

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
