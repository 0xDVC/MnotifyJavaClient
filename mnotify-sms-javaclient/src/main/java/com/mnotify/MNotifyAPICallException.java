package com.mnotify;

public class MNotifyAPICallException extends RuntimeException{
    public MNotifyAPICallException(String message, Exception exc) {
        super(message, exc);
    }

    public MNotifyAPICallException(String message, int code) {
        super(message + code);
    }
}
