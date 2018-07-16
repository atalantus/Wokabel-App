package com.wokabel.app.wokabel.room;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.models.Vocable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class that holds values to be used for testing.
 */
public class TestData {

    static final Vocable VOCABLE_ENTITY = new Vocable("present", new ArrayList<>(Arrays.asList("Geschenk", "Gegenwart")),
            "Fängt auch mit g an", "V01", 1,  "B01");

    static final Vocable VOCABLE_ENTITY2 = new Vocable("flor", new ArrayList<>(Arrays.asList("Blume", "Blüte")),
            "Ich kann kein Spanisch", "V02", 1, "B02");

    static final List<Vocable> VOCABLES = Arrays.asList(VOCABLE_ENTITY, VOCABLE_ENTITY2);



    static final Subgroup SUBGROUP_ENTITY = new Subgroup("Unit 1", "B01", "P01");

    static final Subgroup SUBGROUP_ENTITY2 = new Subgroup("Unit 1", "B02", "P02");

    static final List<Subgroup> SUBGROUPS = Arrays.asList(SUBGROUP_ENTITY, SUBGROUP_ENTITY2);



    static final Supergroup SUPERGROUP_ENTITY = new Supergroup("Englisch", "P01", "234234");

    static final Supergroup SUPERGROUP_ENTITY2 = new Supergroup("Spanisch", "P02", "245644");

    static final List<Supergroup> SUPERGROUPS = Arrays.asList(SUPERGROUP_ENTITY, SUPERGROUP_ENTITY2);
}
