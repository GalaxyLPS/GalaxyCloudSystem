package de.galaxymc.cloud.galaxycloud.library.data.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;

public abstract class CloudSettingsFile {

    private static final char SEPARATOR = '=';

    protected JsonObject settings;
    protected JsonObject defaults;

    protected String destination;

    public void
    load() {
        try {
            File file = new File(destination);
            if (!file.exists()) {
                create();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String in;
            StringBuilder json = new StringBuilder();
            while ((in = reader.readLine()) != null) {
                json.append(in);
            }
            Gson gson = new Gson();
            settings = gson.fromJson(json.toString(), JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create() {
        try {
            File file = new File(destination);
            file.getParentFile().mkdirs();
            file.createNewFile();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String s = gson.toJson(defaults);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(s);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            File file = new File(destination);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String s = gson.toJson(settings);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(s);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}