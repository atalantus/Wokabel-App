package com.wokabel.app.wokabel.services.preferences;

import java.util.Hashtable;

/**
 * Contains all the default values for the settings
 */
public final class SettingsDefaults {
    private SettingsDefaults() { }

    public static final Hashtable<String, String> StringSettings = new Hashtable<String, String>() {
        { put("username", "defaultName"); }
    };

    public static final Hashtable<String, Integer> IntegerSettings = new Hashtable<String, Integer>() {
        { put("user_xp", 0);}
    };

    public static final Hashtable<String, Boolean> BooleanSettings = new Hashtable<String, Boolean>() {

    };
}
