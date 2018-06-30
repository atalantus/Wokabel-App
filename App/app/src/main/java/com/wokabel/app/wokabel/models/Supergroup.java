package com.wokabel.app.wokabel.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

/**
 * A group of {@link Subgroup}s
 */
@Entity(tableName = "supergrouplist")
public class Supergroup {

    private String name;

    @PrimaryKey
    @NonNull
    private String id;

    /**
     * Constructor for initiating a NEW {@link Supergroup}
     * @param name The name
     */
    @Ignore
    public Supergroup(String name) {
        this.name = name;
        id = "P" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Supergroup}
     * @param name The name
     * @param id The ID
     */
    public Supergroup(String name, String id) {
        this.name = name;
        this.id = id;
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
}
