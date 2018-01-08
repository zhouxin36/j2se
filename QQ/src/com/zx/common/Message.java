package com.zx.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Message {
    String from;
    String to;
    String data;
    Date date;

    public Message() {
    }

    public Message(String from, String to, String data, Date date) {
        this.from = from;
        this.to = to;
        this.data = data;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", data='" + data + '\'' +
                ", date=" + date +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
