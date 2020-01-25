package de.galaxymc.cloud.galaxycloud.library.registry;

import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;


// TODO: maybe implement iterator
public abstract class CloudRegistry<T extends CloudRegistryElement> implements Iterable<T> {

    protected T[] values;

    private int index;
    private boolean autoClear = false;

    public CloudRegistry(int size) {
        values = (T[]) new CloudRegistryElement[size];
    }

    public CloudRegistry() {
        values = (T[]) new CloudRegistryElement[2556];
    }

    public int add(T cloudRegistryElement) {
        if (index < values.length) {
            values[index] = cloudRegistryElement;
            return index++;
        } else if (autoClear) {
            index = 0;
            values[index] = cloudRegistryElement;
            return index;
        }
        return -1;
    }

    public void set(int index, T cloudRegistryElement) {
        if (index < values.length) {
            values[index] = cloudRegistryElement;
        }
    }

    public void remove(T cloudRegistryElement) {
        boolean removed = false;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == cloudRegistryElement) {
                remove(i, false);
                removed = true;
            }
        }
        if (removed) compress();
    }

    @Override
    public Iterator<T> iterator() {
        return new CloudRegistryIterator<T>(values);
    }

    public boolean contains(T cloudRegistryElement) {
        for (T cre : values) {
            if (cre == cloudRegistryElement) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        return values[index];
    }

    public T getByUuid(String uuid) {
        return stream().filter(t -> t.getUUID().equalsIgnoreCase(uuid)).findFirst().orElse(null);
    }

    public void remove(int index) {
        remove(index, true);
    }

    private void remove(int index, boolean compress) {
        values[index] = null;
        if (compress)
            compress();
    }

    public T[] toArray() {
        return values;
    }

    public int length() {
        return values.length;
    }

    public int itemCount() {
        return (int) stream().count();
    }

    private void compress() {
        T[] a = (T[]) new CloudRegistryElement[values.length];
        int last = 0;
        for (int i = 0; i < a.length; i++) {
            if (values[i] != null) {
                a[i] = values[i];
                last++;
            }
        }
        values = a.clone();
        index = last + 1;
    }

    public String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        if (stream().filter(Objects::nonNull).filter(p -> p.getUUID() != null).anyMatch(p -> p.getUUID().equalsIgnoreCase(uuid))) {
            return generateUUID();
        }
        return uuid;
    }

    public boolean isAutoClear() {
        return autoClear;
    }

    public void enableAutoClear() {
        autoClear = true;
    }

    public void disableAutoClear() {
        autoClear = false;
    }

    public void setAutoClear(boolean autoClear) {
        this.autoClear = autoClear;
    }

    public Stream<T> stream() {
        return Stream.of(values);
    }

    public String getContentName() {
        return values[0].getClass().getSimpleName();
    }

    public int getIndex() {
        return index;
    }
}