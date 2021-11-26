package com.example.appg9;

import java.util.Date;

public class Event {
    private int img;
    private String event;
    private String type;
    private Date date;
    private Date time;
    private String contact;
    private double value;

    public Event(int img, String event, String type, Date date, Date time, String contact, double value) {
        this.img = img;
        this.event = event;
        this.type = type;
        this.date = date;
        this.time = time;
        this.contact = contact;
        this.value = value;
    }

    public int getImg() {
        return img;
    }

    public String getEvent() {
        return event;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public Date getTime() {
        return time;
    }

    public String getContact() {
        return contact;
    }

    public double getValue() {
        return value;
    }
}
