package de.galaxymc.cloud.galaxycloud.library.security.stream;

import de.galaxymc.cloud.galaxycloud.library.network.packet.Packet;

import java.io.*;
// TODO: make it work
public class SecurePacketInputStream {

    private ObjectInputStream inputStream;

    public SecurePacketInputStream(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Packet read() throws IOException, ClassNotFoundException {
        Object o = inputStream.readObject();
        byte[] b = toByteArray(o);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] + 1);
        }
        return toPacket(b);
    }

    public void close() throws IOException {
        inputStream.close();
    }

    private byte[] toByteArray(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(object);
        out.flush();
        byte[] b = bos.toByteArray();
        out.close();
        bos.close();
        return b;
    }

    private Packet toPacket(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput in = new ObjectInputStream(bis);
        Object o = in.readObject();
        bis.close();
        in.close();
        return o instanceof Packet ? (Packet) o : null;
    }

}
