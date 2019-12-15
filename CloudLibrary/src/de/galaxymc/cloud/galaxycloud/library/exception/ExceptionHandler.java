package de.galaxymc.cloud.galaxycloud.library.exception;

import de.galaxymc.cloud.galaxycloud.library.exception.exceptions.CloudServerInitException;

public class ExceptionHandler {

    ExceptionHandleType exceptionHandleType;

    public ExceptionHandler(ExceptionHandleType exceptionHandleType) {
        this.exceptionHandleType = exceptionHandleType;
    }

    public Object throwException(RuntimeException exception) {
        switch (exceptionHandleType) {
            case AUTO:
                return autoHandle(exception);
            case THROW:
            default:
                throw exception;
        }
    }

    private Object autoHandle(RuntimeException exception) {
        if (exception instanceof CloudServerInitException) {
            CloudServerInitException e = (CloudServerInitException) exception;
            return e.autoHandle();
        }
        throw exception;
    }

}