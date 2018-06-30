package com.wokabel.app.wokabel.models;

import java.util.Hashtable;
import java.util.UUID;

/**
 * A group of {@link Subgroup}s
 */
public class Supergroup {
    private String name;
    private String id;
    private Hashtable<String, Subgroup> subgroups;

    /**
     * Constructor for initiating a NEW {@link Supergroup}
     * @param name The name
     */
    public Supergroup(String name) {
        this.name = name;
        subgroups = new Hashtable<>();
        id = "P" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Supergroup}
     * @param name The name
     * @param id The ID
     * @param subgroups The subgroups
     */
    public Supergroup(String name, String id, Hashtable<String, Subgroup> subgroups) {
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

    public Hashtable<String, Subgroup> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(Hashtable<String, Subgroup> subgroups) {
        this.subgroups = subgroups;
    }
}
