package com.wokabel.app.wokabel.models;

import java.util.Hashtable;
import java.util.UUID;

/**
 * A group of {@link Unit}s
 */
public class Language {
    private String name;
    private String id;
    private Hashtable<String, Unit> subgroups;

    /**
     * Constructor for initiating a NEW {@link Language}
     * @param name The name
     */
    public Language(String name) {
        this.name = name;
        subgroups = new Hashtable<>();
        id = "P" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Language}
     * @param name The name
     * @param id The ID
     * @param subgroups The subgroups
     */
    public Language(String name, String id, Hashtable<String, Unit> subgroups) {
        this.name = name;
        this.id = id;
        this.subgroups = subgroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Hashtable<String, Unit> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(Hashtable<String, Unit> subgroups) {
        this.subgroups = subgroups;
    }
}
