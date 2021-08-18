package com.bankino.training.exception;


public class NotificationTypeNotSelectedException extends BankinoBaseBusinessException {

    private static final long serialVersionUID=1L;

    public NotificationTypeNotSelectedException() {
        super();
    }

    public NotificationTypeNotSelectedException(String message) {
        super(message);
    }

    public NotificationTypeNotSelectedException(String message, Throwable cause) {
        super(message, cause);
    }
}
