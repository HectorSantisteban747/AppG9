package com.example.appg9;

import java.util.Date;

public class Event {
    private int img;
    private String event;
    private String type;
    private String date;
    private String time;
    private String contact;
    private int value;

    public Event(){}


    public Event(int img, String event, String type, String date, String time, String contact, int value) {
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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getContact() {
        return contact;
    }

    public int getValue() {
        return value;
    }
}
