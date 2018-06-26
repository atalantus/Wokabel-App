package com.wokabel.app.wokabel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void languageSelsctScreen(View view){

        Intent intent = new Intent(this, LanguageSelect.class);
        startActivity(intent);
    }
}
