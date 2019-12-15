package de.galaxymc.cloud.galaxycloud.library.exception;

public class GalaxyCloudException extends RuntimeException {

    public GalaxyCloudException() {
        super();
    }

    public GalaxyCloudException(String message) {
        super(message);
    }

    public GalaxyCloudException(String message, Throwable cause) {
        super(message, cause);
    }

    public GalaxyCloudException(Throwable cause) {
        super(cause);
    }

    public GalaxyCloudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Object autoHandle() {
        throw this;
    }

}