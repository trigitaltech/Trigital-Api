package com.trigital.cm.exception;

/**
 * for HTTP 400 errors
 */
public final class TelnetConnectionException extends RuntimeException {
    public TelnetConnectionException() {
        super();
    }

    public TelnetConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelnetConnectionException(String message) {
        super(message);
    }

    public TelnetConnectionException(Throwable cause) {
        super(cause);
    }
}