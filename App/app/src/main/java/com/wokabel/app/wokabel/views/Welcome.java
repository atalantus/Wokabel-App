package com.wokabel.app.wokabel.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest;
import com.wokabel.app.wokabel.WokabelApplication;
import com.wokabel.app.wokabel.services.preferences.Settings;

import java.util.ArrayList;
import java.util.Arrays;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void start(View view) {
        EditText forenameInput = findViewById(R.id.forenameInput);
        String forename = forenameInput.getText().toString();
        Settings settings = WokabelApplication.sharedPreferences;
        settings.setString("username", forename);
        Intent intent = new Intent(this, SubjectSelect.class);
        finish();
        startActivity(intent);
    }
}
