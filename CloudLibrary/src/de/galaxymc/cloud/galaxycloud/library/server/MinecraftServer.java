package de.galaxymc.cloud.galaxycloud.library.server;

import de.galaxymc.cloud.galaxycloud.library.download.DownloadJarType;
import de.galaxymc.cloud.galaxycloud.library.download.DownloadManager;
import de.galaxymc.cloud.galaxycloud.library.log.Loggable;
import de.galaxymc.cloud.galaxycloud.library.message.Listenable;
import de.galaxymc.cloud.galaxycloud.library.message.StringWriteable;
import de.galaxymc.cloud.galaxycloud.library.message.Writable;
import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;
import de.galaxymc.cloud.galaxycloud.library.server.settings.MinecraftServerSettings;
import de.galaxymc.cloud.galaxycloud.library.server.template.MinecraftTemplate;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public final class MinecraftServer implements CloudRegistryElement, Closeable, StringWriteable, Listenable, Loggable {

    private transient boolean stop = false;
    File folder;
    BufferedWriter writer;
    BufferedReader reader;
    BufferedReader errorReader;

    transient ArrayList<String> logs;

    MinecraftServerSettings serverSettings;

    public MinecraftServer(MinecraftServerSettings serverSettings, File serverJar) {
        try {
            this.serverSettings = serverSettings;
            folder = new File("./Wrapper/Temp/Servers/" + serverSettings.getServerType().name() + "/" + serverSettings.getPort());
            folder.mkdirs();
            if (serverJar == null) serverJar = DownloadManager.downloadJar(DownloadJarType.SPIGOT_1_8);
            if (!serverJar.exists()) serverJar = DownloadManager.downloadJar(DownloadJarType.SPIGOT_1_8);
            Files.copy(Paths.get(serverJar.toURI()), Paths.get(new File(folder + "/spigot.jar").toURI()));
            logs = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            folder.mkdirs();
            createResources();
            Runtime r = Runtime.getRuntime();
            Process process = r.exec("java -jar spigot", null, folder);
            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        write("stop");
    }

    @Override
    public void write(String s) {
        try {
            if (writer == null || stop) return;
            writer.write(s + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    private void createResources() {
        File plugins = new File(folder + "/plugins");
        File eula = new File(folder + "/eula.txt");
        File properties = new File(folder + "/server.properties");

        folder.mkdirs();
        plugins.mkdirs();
        try {
            eula.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(eula));
            writer.write("eula=true");
            writer.flush();
            writer.close();
            properties.createNewFile();
            writer = new BufferedWriter(new FileWriter(properties));
            writer.write("view-distance=10\n" +
                    "max-build-height=256\n" +
                    "server-ip=\n" +
                    "level-seed=\n" +
                    "gamemode=0\n" +
                    "server-port=" + serverSettings.getPort() + "\n" +
                    "enable-command-block=false\n" +
                    "allow-nether=true\n" +
                    "enable-rcon=false\n" +
                    "op-permission-level=4\n" +
                    "enable-query=false\n" +
                    "generator-settings=\n" +
                    "resource-pack=\n" +
                    "player-idle-timeout=0\n" +
                    "level-name=world\n" +
                    "motd=" + serverSettings.getMotd() + "\n" +
                    "announce-player-achievements=true\n" +
                    "force-gamemode=false\n" +
                    "hardcore=false\n" +
                    "white-list=false\n" +
                    "broadcast-console-to-ops=true\n" +
                    "pvp=true\n" +
                    "spawn-npcs=true\n" +
                    "generate-structures=true\n" +
                    "spawn-animals=true\n" +
                    "snooper-enabled=true\n" +
                    "difficulty=1\n" +
                    "network-compression-threshold=256\n" +
                    "level-type=DEFAULT\n" +
                    "spawn-monsters=true\n" +
                    "max-players=" + serverSettings.getMaxPlayers() + "\n" +
                    "spawn-protection=0\n" +
                    "online-mode=" + serverSettings.isOnlineMode() + "\n" +
                    "allow-flight=false\n" +
                    "resource-pack-hash=\n" +
                    "max-world-size=29999984\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyResources(File[] plugins) {
        for (File p : plugins) {
            File f = new File(folder + "/plugins/" + p.getName() + ".jar");
            try {
                Files.copy(Paths.get(f.toURI()), Paths.get(p.toURI()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void listen() {
        Thread t = new Thread(() -> {
            try {
                while (!stop) {
                    String s = reader.readLine();
                    log(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread e = new Thread(() -> {
            try {
                while (!stop) {
                    String s = errorReader.readLine();
                    log(s);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        t.setName("MinecraftServerListen-" + serverSettings.getPort());
        t.start();
        e.setName("MinecraftServerListenError-" + serverSettings.getPort());
        e.start();
    }

    @Override
    public void log(String log) {
        logs.add(log);
    }
}