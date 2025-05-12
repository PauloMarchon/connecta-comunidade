package com.connectacomunidade.domain.validation;

import com.connectacomunidade.domain.notification.Notification;

import java.util.List;

public interface ValidationHandler {
    ValidationHandler addNotification(Notification anNotification);
    ValidationHandler addNotification(ValidationHandler anHandler);

    <T> T validate(Validation<T> aValidation);

    List<Notification> getNotifications();

    default boolean hasNotification() {
        return getNotifications() != null && !getNotifications().isEmpty();
    }

    default Notification firstNotification() {
        if(getNotifications() != null && !getNotifications().isEmpty()) {
            return getNotifications().getFirst();
        } else {
            return null;
        }
    }

    interface Validation<T> {
        T validate();
    }
}
