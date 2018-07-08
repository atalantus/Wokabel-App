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

        ArrayList<Vocable> testVocables;
        // HACK: Temp test
        testVocables = new ArrayList<Vocable>(Arrays.asList(
                new Vocable("tree", new ArrayList<String>(Arrays.asList("Baum")), "Fängt mit B an und existiert im Wald.", "0"),
                new Vocable("car", new ArrayList<String>(Arrays.asList("Auto")), "Brum brum", "0"),
                new Vocable("flower", new ArrayList<String>(Arrays.asList("Blume")), "Gibts auf Wiese und im Laden", "0"),
                new Vocable("to pay", new ArrayList<String>(Arrays.asList("bezahlen")), "Nach dem Kauf ....... man", "0"),
                new Vocable("house", new ArrayList<String>(Arrays.asList("Haus")), "Da wohnst du drinnen", "0"),
                new Vocable("cellphone", new ArrayList<String>(Arrays.asList("Handy")), "Nutzt du jeden Tag", "0"),
                new Vocable("table", new ArrayList<String>(Arrays.asList("Tisch")), "Kann man was draufstellen", "0"),
                new Vocable("bike", new ArrayList<String>(Arrays.asList("Fahrrad")), "2 Räder, selber treten", "0"),
                new Vocable("to jump", new ArrayList<String>(Arrays.asList("springen")), "Gegeneil von fallen", "0"),
                new Vocable("to fall", new ArrayList<String>(Arrays.asList("fallen")), "Gegenteil von springen", "0"),
                new Vocable("forest", new ArrayList<String>(Arrays.asList("Wald")), "Den ...... vor lauter Bäumen nicht mehr sehen", "0")
        ));
        VocabularyTest requestAlgorithm = new VocabularyTest(testVocables, VocabularyTest.Modes.RANDOM);
        try {
            System.out.println(requestAlgorithm.getQuestion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            requestAlgorithm.handleAnswer(requestAlgorithm.getAnswer());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
