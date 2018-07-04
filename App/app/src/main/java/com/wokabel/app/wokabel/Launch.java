package com.wokabel.app.wokabel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wokabel.app.wokabel.views.SubjectSelect;
import com.wokabel.app.wokabel.views.Welcome;

public class Launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        // TODO: Check for settings
        if (true) {
            // no settings
            Intent intent = new Intent(this, Welcome.class);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, SubjectSelect.class);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
        }
    }
}
