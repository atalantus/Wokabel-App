package com.wokabel.app.wokabel.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wokabel.app.wokabel.R;

public class EditSubject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_subject);

        setTitle(getString(R.string.edit_subject));
    }
}
