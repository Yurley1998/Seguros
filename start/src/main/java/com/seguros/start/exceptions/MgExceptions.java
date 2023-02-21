package com.seguros.start.exceptions;

public class MgExceptions extends Exception{
    public MgExceptions() {
    }

    public MgExceptions(String message) {
        super(message);
    }

    public MgExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public MgExceptions(Throwable cause) {
        super(cause);
    }

    public MgExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
