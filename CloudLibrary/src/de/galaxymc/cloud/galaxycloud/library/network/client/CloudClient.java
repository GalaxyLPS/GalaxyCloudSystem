package de.galaxymc.cloud.galaxycloud.library.network.client;


import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.event.events.PacketReceiveEvent;
import de.galaxymc.cloud.galaxycloud.library.logger.Logger;
import de.galaxymc.cloud.galaxycloud.library.message.Listenable;
import de.galaxymc.cloud.galaxycloud.library.message.Writable;
import de.galaxymc.cloud.galaxycloud.library.network.client.settings.CloudClientSettings;
import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public final class CloudClient implements Closeable, Listenable, Writable {

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private boolean stop = false;
    private boolean connected = false;
    private CloudClientSettings settings;
    Logger logger;

    public CloudClient(Socket socket) {
        this.logger = new Logger("SocketClient");
        this.socket = socket;
        this.connected = true;
        this.settings = new CloudClientSettings(socket.getInetAddress().getHostAddress(), socket.getPort());
    }

    public CloudClient(CloudClientSettings settings) {
        this.logger = new Logger("SocketClient");
        try {
            this.socket = new Socket(settings.ip, settings.port);
            this.connected = true;
            this.stop = false;
            this.settings = settings;
            logger.debug("Connecting via " + settings.ip + ":" + settings.port + " to master");
        } catch (IOException e) {
            this.logger.critical("Could not reach server! Client shutting down. Restart to try again!");
            stop = true;
            connected = false;
        }
    }

    public void bindStreams() {
        try {
            if (!this.connected) return;
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
            stop = true;
            connected = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Packet packet) {
        if (!connected) return;
        if (outputStream == null) return;
        if (stop) return;
        try {
            outputStream.writeObject(packet);
            outputStream.flush();
            CloudLibrary.packetRegistry.add(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listen() {
        Thread t = new Thread(() -> {
            while (!stop) {
                try {
                    if (inputStream == null) continue;
                    if (!connected) continue;
                    try {
                        Object object = inputStream.readObject();
                        if (!(object instanceof Packet)) return;
                        Packet packet = (Packet) object;
                        CloudLibrary.packetRegistry.add(packet);
                        CloudLibrary.eventHandler.fire(new PacketReceiveEvent(this, packet));
                    } catch (SocketException | EOFException e) {
                        connected = false;
                        stop = true;
                        logger.fatal("Connection lost...");
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setName("CloudClientInputListening");
        t.start();
    }

    public boolean isConnected() {
        return connected;
    }

    public boolean isActive() {
        return stop;
    }

    public CloudClientSettings getSettings() {
        return settings;
    }
}