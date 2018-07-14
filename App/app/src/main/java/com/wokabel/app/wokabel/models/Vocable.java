package com.wokabel.app.wokabel.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;


/**
 * A vocable
 */
@Entity(tableName = "vocablist", indices = {@Index("subgroupid")}, foreignKeys = @ForeignKey(entity = Subgroup.class, parentColumns = "id", childColumns = "subgroupid"))
public class Vocable {
    @PrimaryKey
    @NonNull
    private String key;

    private String values;

    private String helper;

    @NonNull
    private String id;

    private int level;

    @NonNull
    private String subgroupid;

    /**
     * Constructor for initiating a NEW {@link Vocable}
     * @param key The query
     * @param values The different answer possibilities
     * @param helper The tip if the User doesn't know the answer
     * @param subgroupid The id of the Subgroup the Vocable is assigned to
     */
    @Ignore
    public Vocable(@NonNull String key, ArrayList<String> values, String helper, String subgroupid) {
        this.key = key;
        this.values = TextUtils.join(", ", values);
        this.helper = helper;
        level = 0;
        this.subgroupid = subgroupid;
        id = "V" + UUID.randomUUID().toString();
    }

    /**
     * Constructor for initiating an OLD {@link Vocable}
     * @param key The query
     * @param values The different answer possibilities
     * @param helper The tip if the User doesn't know the answer
     * @param id The ID
     * @param level The level
     * @param subgroupid The id of the Subgroup the Vocable is assigned to
     */
    @Ignore
    public Vocable(@NonNull String key, ArrayList<String> values, String helper, String id, int level, String subgroupid) {
        this.key = key;
        this.values = TextUtils.join(", ", values);
        this.helper = helper;
        this.id = id;
        this.level = level;
        this.subgroupid = subgroupid;
    }

    public Vocable(@NonNull String key, String values, String helper, String id, int level, String subgroupid) {
        this.key = key;
        this.values = values;
        this.helper = helper;
        this.id = id;
        this.level = level;
        this.subgroupid = subgroupid;
    }

    @NonNull
    public String getKey() {
        return key;
    }

    public void setKey(@NonNull String key) {
        this.key = key;
    }

    public ArrayList<String> getValuesList() {
        return new ArrayList<>(Arrays.asList(values.split(", ")));
    }

    public String getValues(){
        return values;
    }

    public void setValues(ArrayList<String> values) {
        this.values = TextUtils.join(", ", values);
    }

    public void setValues(String values){
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

    public void setId(String id){
        this.id = id;
    }

    public String getSubgroupid(){
        return subgroupid;
    }

    public void setSubgroupid(String subgroupid){
        this.subgroupid = subgroupid;
    }
}
