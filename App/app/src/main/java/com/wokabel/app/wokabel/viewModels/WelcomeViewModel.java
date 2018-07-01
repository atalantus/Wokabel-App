package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.wokabel.app.wokabel.models.Settings;

public class WelcomeViewModel extends ViewModel {


    WelcomeViewModel(){

    }

    public void start(String user, Context context){
        Settings settings = new Settings(context);
        settings.setString("username", user);
    }
}
