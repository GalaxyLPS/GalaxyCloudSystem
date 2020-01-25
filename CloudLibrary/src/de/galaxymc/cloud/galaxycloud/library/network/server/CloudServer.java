package de.galaxymc.cloud.galaxycloud.library.network.server;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.exception.exceptions.CloudServerInitException;
import de.galaxymc.cloud.galaxycloud.library.network.client.CloudClient;
import de.galaxymc.cloud.galaxycloud.library.network.server.settings.CloudServerSettings;
import de.galaxymc.cloud.galaxycloud.library.network.server.type.CloudServerType;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;

public class CloudServer implements Closeable {

    private ServerSocket socket;
    private CloudServerType serverType;
    private CloudServerSettings serverSettings;
    private CloudClient[] clients;
    private boolean stop = false;


    public CloudServer(CloudServerSettings serverSettings) {
        this.serverSettings = serverSettings;
        try {
            this.socket = new ServerSocket(serverSettings.port);
        } catch (IOException e) {
            this.socket = (ServerSocket) CloudLibrary.exceptionHandler.throwException(new CloudServerInitException(serverSettings));
        }
        this.clients = new CloudClient[this.serverSettings.maxClients];
        serverType = CloudServerType.MASTER;
    }

    public void open() {
        Thread t = new Thread(() -> {
            while (!stop) {
                for (int index = 0; index < clients.length; index++) {
                    if (clients[index] == null) {
                        try {
                            clients[index] = new CloudClient(socket.accept());
                            clients[index].bindStreams();
                            clients[index].listen();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (!clients[index].isActive()) clients[index] = null;
                    }
                }
            }
        });
        t.setName("CloudServer");
        t.start();
    }

    public void close() {
        try {
            for (CloudClient cloudClient : clients) {
                if (cloudClient == null) continue;
                cloudClient.close();
            }
            if (!socket.isClosed())
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CloudServerType getServerType() {
        return serverType;
    }

    public CloudServerSettings getServerSettings() {
        return serverSettings;
    }
}