package com.wokabel.app.wokabel;

import android.app.Application;

import com.wokabel.app.wokabel.services.preferences.Settings;

public class WokabelApplication extends Application {

    public static Settings sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        // Get Settings reference
        sharedPreferences = Settings.getInstance(this);
    }
}
