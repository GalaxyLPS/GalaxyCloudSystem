package de.galaxymc.cloud.galaxycloud.library.logger;

import java.util.Date;

public class Logger {

    public static void log(String log) {
        System.out.println("[" + new Date().toLocaleString() + "]: " + log);
    }
}