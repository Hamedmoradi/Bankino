package com.bankino.training.exception;


public class ReportFromInactiveCounterException extends BankinoBaseBusinessException {


    public ReportFromInactiveCounterException(String message) {
        super("the counter " + message + " is inactive but send data to system....");
    }

}
