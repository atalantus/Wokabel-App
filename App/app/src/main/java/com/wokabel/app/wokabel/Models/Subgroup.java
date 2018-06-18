package com.wokabel.app.wokabel.Models;

import java.util.Hashtable;
import java.util.UUID;

/**
 * Contains multiple {@link Vocable}s
 */
public class Subgroup {
    private String name;
    private String id;
    private Hashtable<String, Vocable> vocables;

    /**
     * Constructor for initiating a NEW {@link Subgroup}
     * @param name The name
     */
    public Subgroup(String name) {
        this.name = name;
        vocables = new Hashtable<>();
        id = "B" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Subgroup}
     * @param name The name
     * @param id The ID
     * @param vocables The vocables
     */
    public Subgroup(String name, String id, Hashtable<String, Vocable> vocables) {
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
