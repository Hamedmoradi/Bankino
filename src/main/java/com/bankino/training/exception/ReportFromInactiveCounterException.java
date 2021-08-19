package com.bankino.training.exception;


public class ReportFromInactiveCounterException extends BankinoBaseBusinessException {


    public ReportFromInactiveCounterException(String message) {
        super("the counter " + message + " is invalid but sed data to system....");
    }

}
