package de.galaxymc.cloud.galaxycloud.master.command;

import de.galaxymc.cloud.galaxycloud.library.message.Listenable;
import de.galaxymc.cloud.galaxycloud.master.command.argument.CommandArgument;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;
import de.galaxymc.cloud.galaxycloud.master.command.commands.*;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class CommandHandler implements Listenable, Closeable {

    private boolean stop = false;

    private ArrayList<CommandBase> commands = new ArrayList<CommandBase>();

    public CommandHandler() {
        addCommand(new HelpCommand());
        addCommand(new SetupGroupCommand());
        addCommand(new SetupSignCommand());
        addCommand(new SetupTemplateCommand());
        addCommand(new SetupWebCommand());
        addCommand(new StopCommand());
    }

    @Override
    public void listen() {
        Thread t = new Thread(() -> {
            Scanner scan = new Scanner(in);
            while (!stop) {
                String in = scan.nextLine();
                String[] args = in.split(" ");
                ArrayList<CommandArgument> arguments = new ArrayList<CommandArgument>();
                for (String s : args) {
                    if (s.contains("=")) {
                        String key = s.split("=")[0];
                        String value = s.replaceFirst(key + "=", "");
                        arguments.add(new CommandArgument(key, value));
                        System.out.println("argument");
                    }
                }
                for (CommandBase c : commands) {
                    if (c.getCommand().equalsIgnoreCase(args[0])) {
                        c.execute(arguments);
                    }
                }
            }
        });
        t.setName("CommandHandlerListen");
        t.start();
    }

    @Override
    public void close() throws IOException {
        stop = true;
    }

    public void addCommand(CommandBase command) {
        commands.add(command);
    }

    public ArrayList<CommandBase> getCommands() {
        return commands;
    }
}