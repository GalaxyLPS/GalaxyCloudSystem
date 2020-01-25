package de.galaxymc.cloud.galaxycloud.library.event;

import de.galaxymc.cloud.galaxycloud.library.event.priority.EventPriority;

public interface CloudListener {

    default EventPriority defaultEventPriority() {
        return EventPriority.NORMAL;
    }

}