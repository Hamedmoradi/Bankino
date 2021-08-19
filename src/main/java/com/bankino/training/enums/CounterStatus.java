package com.bankino.training.enums;

public enum CounterStatus {
        ACTIVE("success",100),
        INACTIVE("fail",200),
        WAITING("waiting",300);

        private String result;
        private Integer resultCode;

    CounterStatus(final String result, final Integer resultCode) {
        this.result = result;
        this.resultCode = resultCode;
    }

    public String getResult() {
        return result;
    }

    public Integer getResultCode() {
        return resultCode;
    }
}
