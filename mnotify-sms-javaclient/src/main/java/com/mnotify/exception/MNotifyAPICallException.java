package com.mnotify.exception;

public class MNotifyAPICallException extends RuntimeException{
    public MNotifyAPICallException(String message, Exception exc) {
        super(message, exc);
    }

    public MNotifyAPICallException(String message, int code) {
        super(message + code);
    }
    public MNotifyAPICallException(String message, String value) {
        super(message + value);
    }
}
