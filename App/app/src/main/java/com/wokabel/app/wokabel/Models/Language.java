package com.wokabel.app.wokabel.models;

import java.util.Hashtable;
import java.util.UUID;

/**
 * A group of {@link Unit}s
 */
public class Language {
    private String name;
    private String id;
    private Hashtable<String, Unit> units;

    /**
     * Constructor for initiating a NEW {@link Language}
     * @param name The name
     */
    public Language(String name) {
        this.name = name;
        units = new Hashtable<String, Unit>();
        id = "L" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Language}
     * @param name The name
     * @param id The ID
     * @param units The units
     */
    public Language(String name, String id, Hashtable<String, Unit> units) {
        this.name = name;
        this.id = id;
        this.units = units;
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

    public Hashtable<String, Unit> getUnits() {
        return units;
    }

    public void setSubgroups(Hashtable<String, Unit> units) {
        this.units = units;
    }
}
