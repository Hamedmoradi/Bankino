package com.bankino.training.enums;

public enum NotificationType {
    EMAIL("email", 1000),
    SMS("sms", 2000);

    private String serviceName;
    private int serviceCode;

    NotificationType(final String serviceName, final int serviceCode) {
        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public static NotificationType setNotificationService(int code) {
        NotificationType notificationType = null;
        if (code == 1000) {
            notificationType = NotificationType.EMAIL;
        } else if (code == 2000) {
            notificationType = NotificationType.SMS;
        }
        return notificationType;
    }


}
