package com.j2se.drools.bean2;

public class Fire {
    private Room room;

    public Fire(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Fire{" +
                "room=" + room +
                '}';
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
