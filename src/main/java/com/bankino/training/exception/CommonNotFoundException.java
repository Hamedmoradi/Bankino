package com.Bankino.training.exception;


import com.bankino.training.exception.BankinoBaseBusinessException;

public class CommonNotFoundException extends BankinoBaseBusinessException {

    public CommonNotFoundException() {
        super("Resource not found");
    }

    public CommonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
