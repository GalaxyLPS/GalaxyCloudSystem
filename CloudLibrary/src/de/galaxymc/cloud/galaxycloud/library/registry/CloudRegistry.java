package de.galaxymc.cloud.galaxycloud.library.registry;

public abstract class CloudRegistry<T extends CloudRegistryElement> {

    protected CloudRegistryElement[] values;

    private int index;

    public CloudRegistry(int size) {
        values = new CloudRegistryElement[size];
    }

    public CloudRegistry() {
        values = new CloudRegistryElement[2556];
    }

    public void add(T cloudRegistryElement) {
        if (index < values.length) {
            values[index] = cloudRegistryElement;
            index++;
        }
    }

    public void remove(T cloudRegistryElement) {
        for (int index = 0; index < values.length; index++) {
            if (values[index] == cloudRegistryElement) {
                remove(index);
            }
        }
    }

    public boolean contains(T cloudRegistryElement) {
        for (CloudRegistryElement cre : values) {
            if (cre == cloudRegistryElement) {
                return true;
            }
        }
        return false;
    }

    public CloudRegistryElement get(int index) {
        return values[index];
    }

    public void remove(int index) {
        values[index] = null;
        compress();
    }

    private void compress() {
        CloudRegistryElement[] a = new CloudRegistryElement[values.length];
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

    public String getContentName() {
        return values[0].getClass().getSimpleName();
    }

}