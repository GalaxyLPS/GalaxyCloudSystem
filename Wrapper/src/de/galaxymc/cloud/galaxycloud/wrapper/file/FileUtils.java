package de.galaxymc.cloud.galaxycloud.wrapper.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class FileUtils {

    public static void clearTemp() {
        File file = new File("./Wrapper/Temp");
        if (file.exists()) {
            try {
                Files.walk(Paths.get(file.toURI()))
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.delete();
        }
    }

}