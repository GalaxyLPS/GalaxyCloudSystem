package de.galaxymc.cloud.galaxycloud.library.logger;

import java.text.DateFormat;
import java.util.Date;

public class Logger {

    private static DateFormat format = DateFormat.getDateInstance();

    public static void log(String log) {
        System.out.println("[" + format.format(new Date()) + "]: " + log);
    }
}