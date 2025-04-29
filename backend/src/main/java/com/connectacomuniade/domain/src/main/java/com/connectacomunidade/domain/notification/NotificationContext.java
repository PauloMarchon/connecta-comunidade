package com.connectacomunidade.domain.notification;

import com.connectacomunidade.domain.exception.DomainException;
import com.connectacomunidade.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class NotificationContext implements ValidationHandler {
    private final List<Notification> notifications;

    private NotificationContext(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public static NotificationContext create() {
        return new NotificationContext(new ArrayList<>());
    }

    public static NotificationContext create(final Notification anNotification) {
        return new NotificationContext(new ArrayList<>()).append(anNotification);
    }

    public static NotificationContext create(final Throwable t) {
        return create(new Notification(t.getMessage()));
    }

    @Override
    public NotificationContext append(final Notification anNotification) {
        this.notifications.add(anNotification);
        return this;
    }

    @Override
    public NotificationContext append(final ValidationHandler anHandler) {
        this.notifications.addAll(anHandler.getNotifications());
        return this;
    }

    @Override
    public <T> T validate(Validation<T> aValidation) {
        try {
            return aValidation.validate();
        } catch (final DomainException ex) {
            this.notifications.addAll(ex.getNotifications());
        } catch (final Throwable t) {
            this.notifications.add(new Notification(t.getMessage()));
        }
        return null;
    }

    @Override
    public List<Notification> getNotifications() {
        return this.notifications;
    }
}
