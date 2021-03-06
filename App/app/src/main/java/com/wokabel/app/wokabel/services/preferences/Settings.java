package com.wokabel.app.wokabel.services.preferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Handles Settings
 */
public class Settings {
    private static Settings instance = null;

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    private Settings(Context context) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPrefs.edit();
    }

    public static Settings getInstance(Context context) {
        if (instance == null)
            instance = new Settings(context);
        return instance;
    }

    public void setString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void setInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public void setBool(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return sharedPrefs.getString(key, SettingsDefaults.StringSettings.get(key));
    }

    public int getInt(String key) {
        return sharedPrefs.getInt(key, SettingsDefaults.IntegerSettings.get(key));
    }

    public boolean getBool(String key) {
        return sharedPrefs.getBoolean(key, SettingsDefaults.BooleanSettings.get(key));
    }

    public void clear(String key) {
        this.editor.remove(key);
        this.editor.commit();
    }

    public void clear() {
        this.editor.clear();
        this.editor.commit();
    }
}
