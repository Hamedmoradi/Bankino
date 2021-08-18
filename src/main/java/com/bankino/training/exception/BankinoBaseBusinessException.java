package com.bankino.training.exception;

public class BankinoBaseBusinessException extends RuntimeException {

    public BankinoBaseBusinessException() {
        super();
    }

    public BankinoBaseBusinessException(String message) {
        super(message);
    }

    public BankinoBaseBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
