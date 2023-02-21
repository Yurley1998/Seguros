package com.seguros.start.exceptions;

public class DaoExceptions extends Exception{
    public DaoExceptions() {
    }

    public DaoExceptions(String message) {
        super(message);
    }

    public DaoExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoExceptions(Throwable cause) {
        super(cause);
    }

    public DaoExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
