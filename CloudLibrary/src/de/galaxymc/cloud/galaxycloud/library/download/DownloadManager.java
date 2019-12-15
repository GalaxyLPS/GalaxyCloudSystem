package de.galaxymc.cloud.galaxycloud.library.download;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadManager {

    public static File downloadJar(DownloadJarType type) {
        File file = new File("Cloud/temp/download/" + type.name() + ".tempcloud");
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            URL url = new URL(type.getUrl());
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(file);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            rbc.close();
            fos.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}