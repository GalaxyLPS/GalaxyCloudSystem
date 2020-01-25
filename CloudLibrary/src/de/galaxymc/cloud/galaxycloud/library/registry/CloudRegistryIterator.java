package de.galaxymc.cloud.galaxycloud.library.registry;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class CloudRegistryIterator<T extends CloudRegistryElement> implements Iterator<T> {

    private int position = 0;
    private T[] data;

    public CloudRegistryIterator(T[] data) {
        this.data = (T[]) Arrays.stream(data).filter(Objects::nonNull).toArray();
    }

    @Override
    public boolean hasNext() {
        return position < data.length - 1;
    }

    @Override
    public T next() {
        return hasNext() ? data[position++] : null;
    }
}
