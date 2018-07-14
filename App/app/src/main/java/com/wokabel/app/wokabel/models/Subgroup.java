package com.wokabel.app.wokabel.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;


/**
 * Contains multiple {@link Vocable}s
 */
@Entity(tableName = "subgrouplist", indices = {@Index("supergroupid")},foreignKeys = @ForeignKey(entity = Supergroup.class, parentColumns = "id", childColumns = "supergroupid"))
public class Subgroup {

    private String name;

    @NonNull
    @PrimaryKey
    private String id;

    private String supergroupid;



    /**
     * Constructor for initiating a NEW {@link Subgroup}
     * @param name The name
     * @param supergroupid the Supergroup ID
     */
    @Ignore
    public Subgroup(String name, String supergroupid) {
        this.name = name;
        this.supergroupid = supergroupid;
        id = "B" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Subgroup}
     * @param name The name
     * @param id The ID
     */
    public Subgroup(String name, @NonNull String id, String supergroupid) {
        this.name = name;
        this.id = id;
        this.supergroupid = supergroupid;
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

    public String getSupergroupid(){
        return supergroupid;
    }

    public void setSupergroupid(String supergroupid){
        this.supergroupid = supergroupid;
    }

}
