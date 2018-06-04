package com.wokabel.app.wokabel.Models;

import java.util.ArrayList;

/**
 * A vocable
 */
public class Vocable {
    private String key;
    private ArrayList<String> values;
    private String helper;
    private int level;
    private int id;

    public Vocable(String key, ArrayList<String> values, String helper) {
        this.key = key;
        this.values = values;
        this.helper = helper;
        level = 0;
        //TODO: Assign ID
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(ArrayList<String> values) {
        this.values = values;
    }

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }
}
