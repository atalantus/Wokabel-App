package com.wokabel.app.wokabel.models;

public class User {
    private static final User instance = new User();

    public static User getInstance() {
        return instance;
    }

    private User() {
        name = "username";
        xp = 100;
    }

    private String name;
    private int xp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
