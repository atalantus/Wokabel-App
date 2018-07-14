package com.wokabel.app.wokabel.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

/**
 * A group of {@link Subgroup}s
 */
@Entity(tableName = "supergrouplist",indices = {@Index("id")})
public class Supergroup {

    private String name;

    @PrimaryKey
    @NonNull
    private String id;

    private String icon;
    /**
     * Constructor for initiating a NEW {@link Supergroup}
     * @param name The name
     * @param icon The String of the IconRecourceId
     */
    @Ignore
    public Supergroup(String name, String icon) {
        this.name = name;
        id = "P" + UUID.randomUUID().toString();
        this.icon = icon;
    }

    /**
     * Constructor for initiating an OLD {@link Supergroup}
     * @param name The name
     * @param id The ID
     * @param icon The String of the IconRecourceId
     */
    public Supergroup(String name, @NonNull String id, String icon) {
        this.name = name;
        this.id = id;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }
}
