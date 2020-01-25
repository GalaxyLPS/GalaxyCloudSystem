package de.galaxymc.cloud.galaxycloud.library.math;

public class Mathf {

    public static int clamp(int value, int min, int max) {
        return value < min ? min : Math.min(value, max);
    }

}