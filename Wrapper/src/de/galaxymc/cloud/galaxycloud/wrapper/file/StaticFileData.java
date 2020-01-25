package de.galaxymc.cloud.galaxycloud.wrapper.file;

import java.io.File;

public class StaticFileData {

    public static final File wrapper = new File("./Wrapper");

    public static final File files = new File(wrapper + "/files/");
    public static final File modifications = new File(files + "/modifications/");
    public static final File server = new File(files + "/server/");

    public StaticFileData() {
        server.mkdirs();
        modifications.mkdirs();
    }
}