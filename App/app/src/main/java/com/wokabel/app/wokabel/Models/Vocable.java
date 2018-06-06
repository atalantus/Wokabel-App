package com.wokabel.app.wokabel.Models;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A vocable
 */
public class Vocable {
    private String key;
    private ArrayList<String> values;
    private String helper;
    private String id;
    private int level;

    /**
     * Constructor for initiating a NEW {@link Vocable}
     * @param key The query
     * @param values The different answer possibilities
     * @param helper The tip if the User doesn't know the answer
     */
    public Vocable(String key, ArrayList<String> values, String helper) {
        this.key = key;
        this.values = values;
        this.helper = helper;
        level = 0;
        id = "V" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Vocable}
     * @param key The query
     * @param values The different answer possibilities
     * @param helper The tip if the User doesn't know the answer
     * @param id The ID
     * @param level The level
     */
    public Vocable(String key, ArrayList<String> values, String helper, String id, int level) {
        this.key = key;
        this.values = values;
        this.helper = helper;
        this.id = id;
        this.level = level;
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

    public String getId() {
        return id;
    }
}
