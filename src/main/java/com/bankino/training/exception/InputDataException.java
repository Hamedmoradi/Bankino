package com.bankino.training.exception;

public class InputDataException extends BankinoBaseBusinessException {

    public InputDataException() {
        super("There was an error entering the data....");
    }

    public InputDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
