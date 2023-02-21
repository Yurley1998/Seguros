package com.seguros.start.exceptions;

public class FdExceptions extends Exception{
    public FdExceptions() {
    }

    public FdExceptions(String message) {
        super(message);
    }

    public FdExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public FdExceptions(Throwable cause) {
        super(cause);
    }

    public FdExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
