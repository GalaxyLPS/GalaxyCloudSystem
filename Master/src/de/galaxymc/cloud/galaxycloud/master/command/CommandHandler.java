package de.galaxymc.cloud.galaxycloud.master.command;

import de.galaxymc.cloud.galaxycloud.library.message.Listenable;
import de.galaxymc.cloud.galaxycloud.master.command.base.CommandBase;
import de.galaxymc.cloud.galaxycloud.master.command.commands.*;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class CommandHandler implements Listenable, Closeable {

    private boolean stop = false;

    private ArrayList<CommandBase> commands = new ArrayList<>();

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
                String[] arguments = new String[Math.abs(args.length - 1)]; // take absolute value, otherwise arguments could be initialized with negative length
                System.arraycopy(args, 1, arguments, 0, arguments.length);
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
    public void close() {
        stop = true;
    }

    public void addCommand(CommandBase command) {
        commands.add(command);
    }

    public ArrayList<CommandBase> getCommands() {
        return commands;
    }
}