package com.wokabel.app.wokabel.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.wokabel.app.wokabel.R;

public class SubjectSelect extends AppCompatActivity {

    private ProfileFragment profileFragment;
    private SubjectsFragment subjectsFragment;
    private SettingsFragment settingsFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    setTitle(R.string.title_profile);
                    if (profileFragment == null) profileFragment = ProfileFragment.newInstance();
                    selectedFragment = profileFragment;
                    break;
                case R.id.navigation_subjects:
                    setTitle(R.string.title_subjects);
                    if (subjectsFragment == null) subjectsFragment = SubjectsFragment.newInstance();
                    selectedFragment = subjectsFragment;
                    break;
                case R.id.navigation_settings:
                    setTitle(R.string.title_settings);
                    if (settingsFragment == null) settingsFragment = SettingsFragment.newInstance();
                    selectedFragment = settingsFragment;
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_select);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_subjects);
    }

    public void createSubject(View view) {
        subjectsFragment.createSubject(view);
    }
}