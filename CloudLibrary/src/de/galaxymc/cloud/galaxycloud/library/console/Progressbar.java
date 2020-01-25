package de.galaxymc.cloud.galaxycloud.library.console;

import de.galaxymc.cloud.galaxycloud.library.math.Mathf;

public class Progressbar {

    protected int index; // 0-10

    private int maxIndex = 100;

    protected String openedBy = "[";
    protected String closedBy = "]";


    Console console;

    public Progressbar(Console console) {
        this.console = console;
    }

    public void stepTo(int index) {
        this.index = index;
        this.index = Mathf.clamp(this.index, 0, maxIndex);
    }

    public void stepBy(int amount) {
        this.index += amount;
        this.index = Mathf.clamp(this.index, 0, maxIndex);
    }

    public void update() {
        console.print(console.cursorUp(1) + console.cursorLeft(1000) + openedBy + "#".repeat(this.index) + " ".repeat(maxIndex - this.index) + closedBy);
    }

    public void begin() {
        console.print("\n");
    }
}