package com.wokabel.app.wokabel.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.wokabel.app.wokabel.BuildConfig;
import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.services.XmlUtilities.XmlReader;

import java.io.File;

public class Launch extends AppCompatActivity {

    private enum AppStates { NORMAL, FIRST_RUN, UPGRADE, DOWNGRADE }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        AppStates appState = checkAppVersion();
        Intent appIntent;

        switch (appState) {

            case NORMAL:
                appIntent = new Intent(this, SubjectSelect.class);
                finish();
                startActivity(appIntent);
                break;
            case FIRST_RUN:
                //File xmlFile = XmlReader.createFileFromAsset("preset_eng-de.xml", this);
                //XmlReader reader = new XmlReader(xmlFile);
                //reader.writeXmlToDB();

                appIntent = new Intent(this, Welcome.class);
                finish();
                startActivity(appIntent);
                break;
            case UPGRADE:
                appIntent = new Intent(this, SubjectSelect.class);
                finish();
                startActivity(appIntent);
                break;
            case DOWNGRADE:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.downgrade_dialog_message)
                        .setTitle(R.string.downgrade_dialog_title);
                builder.setPositiveButton("SORRY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
        }
    }

    private AppStates checkAppVersion() {

        final String PREFS_NAME = "LaunchPreferences";
        final String PREF_VERSION_CODE_KEY = "app_version_code";
        final int DOESNT_EXIST = -1;

        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {

            // This is just a normal run
            return AppStates.NORMAL;

        } else if (savedVersionCode == DOESNT_EXIST) {

            // This is a new install (or the user cleared the shared preferences)
            return AppStates.FIRST_RUN;

        } else if (currentVersionCode > savedVersionCode) {

            // This is an upgrade
            return AppStates.UPGRADE;

        } else {
            return AppStates.DOWNGRADE;
            //throw new Exception("You just downgraded the app? Please stop manipulating the app.");
        }
    }
}
