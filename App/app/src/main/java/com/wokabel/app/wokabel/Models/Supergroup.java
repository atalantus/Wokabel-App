package com.wokabel.app.wokabel.Models;

import java.util.Hashtable;

/**
 * A group of {@link Subgroup}s
 */
public class Supergroup {
    private String name;
    private Hashtable<String, Subgroup> subgroups;
}
