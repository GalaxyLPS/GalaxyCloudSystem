package de.galaxymc.cloud.galaxycloud.library.logger;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;

import java.text.DateFormat;
import java.util.Date;

public class Logger {

    private static DateFormat format = DateFormat.getDateTimeInstance();
    private String name;
    public static final Logger logger = new Logger("System");

    public Logger(String name) {
        this.name = name;
    }

    public void verbose(String log) {
        this.log(log, LogLevel.VERBOSE);
    }

    public void debug(String log) {
        this.log(log, LogLevel.DEBUG);
    }

    public void info(String log) {
        this.log(log, LogLevel.INFO);
    }

    public void warning(String log) {
        this.log("&e" + log, LogLevel.WARNING);
    }

    public void critical(String log) {
        this.log("&4" + log, LogLevel.CRITICAL);
    }

    public void fatal(String log) {
        this.log("&4" + log, LogLevel.FATAL);
    }


    public void log(String log, LogLevel level) {
        switch (level) {
            case VERBOSE:
                this.log(log, level, LogDestination.FILE);
                break;
            case DEBUG:
                this.log(log, level, CloudLibrary.enableDebugOutput ? LogDestination.FILE_CONSOLE : LogDestination.FILE);
                break;
            case INFO:
            case WARNING:
            case CRITICAL:
            case FATAL:
                this.log(log, level, LogDestination.FILE_CONSOLE);
                break;
            default:
                System.out.println(log);
        }
    }

    public void log(String log, LogLevel level, LogDestination logDestination) {
        if (logDestination == LogDestination.FILE || logDestination == LogDestination.FILE_CONSOLE) {

        }
        if (logDestination == LogDestination.CONSOLE || logDestination == LogDestination.FILE_CONSOLE) {
            CloudLibrary.console.print("[" + format.format(new Date()) + " | " + name + "/" + level.name() + "]: " + log);
        }
    }
}