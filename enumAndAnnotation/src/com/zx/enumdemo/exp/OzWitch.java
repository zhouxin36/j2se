package com.zx.enumdemo.exp;

public enum OzWitch {
    WEST("west west west"),
    NORTH("north north north"),
    EAST("east east east"),
    SOUTH("south south south");
    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch:
             OzWitch.values()) {
            System.out.println(witch.getDescription());
        }
    }
}
