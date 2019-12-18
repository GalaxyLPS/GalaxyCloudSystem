package de.galaxymc.cloud.galaxycloud.master.command.commands;

import de.galaxymc.cloud.galaxycloud.library.logger.Logger;
import de.galaxymc.cloud.galaxycloud.library.server.operator.Operator;
import de.galaxymc.cloud.galaxycloud.master.Master;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;

import java.util.ArrayList;

public class OperatorCommand implements CommandBase {

    @Override
    public void execute(String[] arguments) {
        if (arguments.length == 1) {
            if (arguments[0].equalsIgnoreCase("list")) {
                ArrayList<Operator> operators = Master.instance.getSettings().getOperators();
                for (Operator operator : operators) {
                    Logger.log(operator.getName() + "[" + operator.getUuid() + "]");
                }
            }
        } else if (arguments.length == 2) {
            if (arguments[0].equalsIgnoreCase("remove")) {
                String identifier = arguments[0];
                Master.instance.getSettings().getOperators().removeIf(operator -> identifier.equalsIgnoreCase(operator.getName()) || identifier.equalsIgnoreCase(operator.getUuid()));
                Logger.log("Operator was removed!");
            }
        } else if (arguments.length == 3) {
            if (arguments[0].equalsIgnoreCase("add")) {
                String name = arguments[1];
                String uuid = arguments[2];
                Operator o = new Operator(name, uuid);
                Master.instance.getSettings().getOperators().add(o);
                Logger.log("Operator added!");
            }
        }
    }

    @Override
    public String getCommand() {
        return "operator";
    }

    @Override
    public String getHelp() {
        return "operator <add|remove|list> [name]";
    }
}