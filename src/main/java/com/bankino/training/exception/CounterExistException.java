package com.bankino.training.exception;

public class CounterExistException extends BankinoBaseBusinessException {

    public CounterExistException(String message) {
        super("there is a counter with " + message + "no");
    }
}
