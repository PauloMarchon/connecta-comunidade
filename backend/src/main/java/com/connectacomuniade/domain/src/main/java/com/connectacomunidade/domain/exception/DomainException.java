package com.connectacomunidade.domain.exception;

import com.connectacomunidade.domain.notification.Notification;

import java.util.List;

public class DomainException extends RuntimeException {
    protected final List<Notification> notifications;

    protected DomainException(String message, List<Notification> notifications) {
        super(message);
        this.notifications = notifications;
    }

    public static DomainException with(final Notification notification) {
        return new DomainException(notification.message(), List.of(notification));
    }

    public static DomainException with(final List<Notification> notifications) {
        return new DomainException("", notifications);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
