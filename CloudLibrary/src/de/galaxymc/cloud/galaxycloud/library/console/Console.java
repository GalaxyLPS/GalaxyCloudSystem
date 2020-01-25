package de.galaxymc.cloud.galaxycloud.library.console;

import java.util.ArrayList;
import java.util.List;

public abstract class Console {

    public static Console current;

    public List<String> logs;

    public Console() {
        logs = new ArrayList<>();
    }

    public String translateColors(String s) {
        s = s.replaceAll("&4", red());
        s = s.replaceAll("&e", yellow());
        s = s.replaceAll("&f", white());
        s = s.replaceAll("&2", green());
        s = s.replaceAll("&0", black());
        s = s.replaceAll("&1", blue());
        s = s.replaceAll("&r", colorReset());

        s = s.replaceAll("%4", backgroundRed());
        s = s.replaceAll("%e", backgroundYellow());
        s = s.replaceAll("%f", backgroundWhite());
        s = s.replaceAll("%2", backgroundGreen());
        s = s.replaceAll("%0", backgroundBlack());
        s = s.replaceAll("%1", backgroundBlue());
        s = s.replaceAll("%1", backgroundReset());
        return s;
    }


    public abstract void print(String s);

    public abstract String cursorUp(int amount);

    public abstract  String cursorLeft(int amount);

    public abstract String blue();

    public abstract String red();

    public abstract String yellow();

    public abstract String green();

    public abstract String black();

    public abstract String white();

    public abstract String backgroundBlack();

    public abstract String backgroundRed();

    public abstract String backgroundGreen();

    public abstract String backgroundYellow();

    public abstract String backgroundBlue();

    public abstract String backgroundWhite();

    public abstract String backgroundReset();

    public abstract String colorReset();


}