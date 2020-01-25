package de.galaxymc.cloud.galaxycloud.library.logger;

public enum LogLevel {

    VERBOSE(0), DEBUG(1), INFO(3), WARNING(5), CRITICAL(10), FATAL(20);

    public final int level;

    private LogLevel(int level) {
        this.level = level;
    }
}