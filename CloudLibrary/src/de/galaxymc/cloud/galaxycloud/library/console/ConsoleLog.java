package de.galaxymc.cloud.galaxycloud.library.console;

public class ConsoleLog {

    private final String log;

    private ConsoleLog(String log) {
        this.log = log;
    }

    public static ConsoleLog create(String log) {
        if (log == null) return null;
        if (log.isEmpty()) return null;
        if (log.replaceAll(" ", "").isEmpty()) return null;
        return new ConsoleLog(log);
    }

    public String getLog() {
        return log;
    }
}