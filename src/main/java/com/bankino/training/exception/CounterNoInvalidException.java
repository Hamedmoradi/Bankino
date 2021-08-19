package com.bankino.training.exception;

public class CounterNoInvalidException extends BankinoBaseBusinessException{
    public CounterNoInvalidException() {
        super("format No is invalid for counter. ");
    }
}
