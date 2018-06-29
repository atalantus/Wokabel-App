package com.wokabel.app.wokabel.models;

import java.util.Hashtable;
import java.util.UUID;

/**
 * Contains multiple {@link Vocable}s
 */
public class Unit {
    private String name;
    private String id;
    private Hashtable<String, Vocable> vocables;

    /**
     * Constructor for initiating a NEW {@link Unit}
     * @param name The name
     */
    public Unit(String name) {
        this.name = name;
        vocables = new Hashtable<>();
        id = "B" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Unit}
     * @param name The name
     * @param id The ID
     * @param vocables The vocables
     */
    public Unit(String name, String id, Hashtable<String, Vocable> vocables) {
        this.name = name;
        this.id = id;
        this.vocables = vocables;
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

    public Hashtable<String, Vocable> getVocables() {
        return vocables;
    }

    public void setVocables(Hashtable<String, Vocable> vocables) {
        this.vocables = vocables;
    }
}
