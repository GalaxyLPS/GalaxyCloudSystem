package de.galaxymc.cloud.galaxycloud.library.event;

import de.galaxymc.cloud.galaxycloud.library.event.priority.EventPriority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventMarker {

    EventPriority priority = EventPriority.NORMAL;

}