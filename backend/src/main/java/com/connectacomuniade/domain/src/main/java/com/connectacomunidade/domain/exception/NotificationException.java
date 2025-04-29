package com.connectacomunidade.domain.exception;

import com.connectacomunidade.domain.notification.NotificationContext;

public class NotificationException extends DomainException {
    public NotificationException(String message, NotificationContext notificationContext) {
        super(message, notificationContext.getNotifications());
    }
}
