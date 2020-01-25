package de.galaxymc.cloud.galaxycloud.library.security.stream;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

import java.io.*;

// TODO: make it work
public class SecurePacketOutputStream {

    private ObjectOutputStream outputStream;

    public SecurePacketOutputStream(ObjectOutputStream objectOutputStream) {
        this.outputStream = objectOutputStream;
    }

    public void write(Packet packet) throws IOException, ClassNotFoundException {
        byte[] b = toByteArray(packet);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] + 1);
        }
        outputStream.writeObject(toPacket(b));
    }

    public void close() throws IOException {
        outputStream.close();
    }

    public void flush() throws IOException {
        outputStream.flush();
    }

    private byte[] toByteArray(Packet packet) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(packet);
            return bos.toByteArray();
        }
    }

    private Packet toPacket(byte[] data) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInput in = new ObjectInputStream(bis)) {
            return (Packet) in.readObject();
        }
    }

}