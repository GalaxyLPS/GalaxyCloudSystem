package de.galaxymc.cloud.galaxycloud.library.event;

import jdk.jfr.Event;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.EventListener;

public class EventHandler {

    private ArrayList<CloudListener> cloudListener;

    public EventHandler() {
        cloudListener = new ArrayList<>();
    }

    public void fire(ICloudEvent event) {
        for (CloudListener listener : cloudListener) {
            Method[] methods = listener.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(EventMarker.class)) {
                    Parameter[] parameters = method.getParameters();
                    if (parameters.length != 1) continue;
                    Parameter parameter = parameters[0];
                    if (parameter.getType().getSimpleName().equalsIgnoreCase(event.getClass().getSimpleName())) {
                        try {
                            method.invoke(listener, event);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void addEventListener(CloudListener cloudListener) {
        this.cloudListener.add(cloudListener);
    }

}