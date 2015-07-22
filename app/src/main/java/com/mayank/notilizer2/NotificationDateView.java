package com.mayank.notilizer2;

import java.util.Date;


public class NotificationDateView {
    public Date Date;
    public Integer Notifications;

    public NotificationDateView() {
        this.Date = null;
        this.Notifications = 0;
    }

    public NotificationDateView(Date date, Integer notifications) {
        this.Date = date;
        this.Notifications = notifications;
    }
}
