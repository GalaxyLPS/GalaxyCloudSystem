package de.galaxymc.cloud.galaxycloud.library.console.windows;

import de.galaxymc.cloud.galaxycloud.library.console.Console;

public class WindowsConsole extends Console {


    @Override
    public String cursorLeft(int amount) {
        return "\u001b[" + amount + "D";
    }

    @Override
    public String cursorUp(int amount) {
        return "\u001b[" + amount + "A";
    }

    @Override
    public void print(String s) {
        System.out.println(translateColors(s) + colorReset() + backgroundReset());
    }

    public void moveCursorLeft() {
        print("\r");
    }

    @Override
    public String blue() {
        return "\u001b[34m";
    }

    @Override
    public String red() {
        return "\u001b[31m";
    }

    @Override
    public String yellow() {
        return "\u001b[33m";
    }

    @Override
    public String green() {
        return "\u001b[32m";
    }

    @Override
    public String black() {
        return "\u001b[30m";
    }

    @Override
    public String white() {
        return "\u001b[37m";
    }

    @Override
    public String backgroundBlack() {
        return "\u001b[40m";
    }

    @Override
    public String backgroundRed() {
        return "\u001b[41m";
    }

    @Override
    public String backgroundGreen() {
        return "\u001b[42m";
    }

    @Override
    public String backgroundYellow() {
        return "\u001b[43m";
    }

    @Override
    public String backgroundBlue() {
        return "\u001b[44m";
    }

    @Override
    public String backgroundWhite() {
        return "\u001b[47m";
    }

    @Override
    public String backgroundReset() {
        return "\u001b[0m";
    }

    @Override
    public String colorReset() {
        return "\u001b[0m";
    }
}