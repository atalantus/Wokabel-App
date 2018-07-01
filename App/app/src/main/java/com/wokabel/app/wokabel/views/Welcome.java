package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.viewModels.WelcomeViewModel;

public class Welcome extends AppCompatActivity {

    private WelcomeViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        model = ViewModelProviders.of(this).get(WelcomeViewModel.class);
    }

    public void start(View view) {
        EditText forenameInput = findViewById(R.id.forenameInput);
        String forename = forenameInput.getText().toString();
        model.start(forename, getApplicationContext());
        Intent intent = new Intent(this, SubjectSelect.class);
        startActivity(intent);
    }
}
