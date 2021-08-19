package com.bankino.training.enums;


public enum EmailTemplateContent {
    INACTIVE_COUNTER("inactiveCounter", 50001, "this counter inactive but send data to system");
    private String alarmType;
    private int alarmTypeCode;
    private String context;

    EmailTemplateContent() {
    }

    EmailTemplateContent(String alarmType , int alarmTypeCode, String context) {
        this.alarmType = alarmType;
        this.alarmTypeCode = alarmTypeCode;
        this.context = context;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public int getAlarmTypeCode() {
        return alarmTypeCode;
    }

    public String getContext() {
        return context;
    }

    public String contextValue(String title) {

        String include="";
        for (EmailTemplateContent emailTemplateContent : EmailTemplateContent.values()) {

            if (title.equals(emailTemplateContent.alarmType)){
                include= emailTemplateContent.context;
                return include;
            }
        }
        return include;
    }

}

