package com.j2se.drools.bean2;

public class Sprinkler {
    private Room room;
    private boolean on = false;

    public Sprinkler(Room room) {
        this.room = room;
    }

    public Sprinkler() {
    }

    @Override
    public String toString() {
        return "Sprinkler{" +
                "room=" + room +
                ", on=" + on +
                '}';
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}

