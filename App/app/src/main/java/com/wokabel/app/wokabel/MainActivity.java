package com.wokabel.app.wokabel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wokabel.app.wokabel.models.Settings;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Small settings test
        Settings settings = new Settings(this);
        String name = settings.getString("username");
        System.out.println("Username: " + name);
        int xp = settings.getInt("user_xp");
        System.out.println("User XP: " + xp);
        settings.setInt("user_xp", 100);
        xp = settings.getInt("user_xp");
        System.out.println("User XP (100): " + xp);
    }
}
