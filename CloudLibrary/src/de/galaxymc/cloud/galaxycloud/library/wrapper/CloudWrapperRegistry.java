package de.galaxymc.cloud.galaxycloud.library.wrapper;

import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistry;
import de.galaxymc.cloud.galaxycloud.library.registry.CloudRegistryElement;

public class CloudWrapperRegistry extends CloudRegistry<CloudWrapper> {

    public CloudWrapper getByLowestUsage() {
        CloudWrapper lowest = (CloudWrapper) get(0);
        for (CloudRegistryElement cre : values) {
            if (cre instanceof CloudWrapper) {
                CloudWrapper wrapper = (CloudWrapper) cre;
                if (wrapper.usage < lowest.usage) {
                    lowest = wrapper;
                }
            }
        }
        return lowest;
    }

}