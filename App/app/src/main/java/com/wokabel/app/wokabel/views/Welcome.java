package com.wokabel.app.wokabel.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.wokabel.app.wokabel.R;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // HACK: Temp test
        testVocables = new ArrayList<Vocable>(Arrays.asList(
                new Vocable("tree", new ArrayList<String>(Arrays.asList("Baum")), "Fängt mit B an und existiert im Wald."),
                new Vocable("car", new ArrayList<String>(Arrays.asList("Auto")), "Brum brum"),
                new Vocable("flower", new ArrayList<String>(Arrays.asList("Blume")), "Gibts auf Wiese und im Laden"),
                new Vocable("to pay", new ArrayList<String>(Arrays.asList("bezahlen")), "Nach dem Kauf ....... man"),
                new Vocable("house", new ArrayList<String>(Arrays.asList("Haus")), "Da wohnst du drinnen"),
                new Vocable("cellphone", new ArrayList<String>(Arrays.asList("Handy")), "Nutzt du jeden Tag"),
                new Vocable("table", new ArrayList<String>(Arrays.asList("Tisch")), "Kann man was draufstellen"),
                new Vocable("bike", new ArrayList<String>(Arrays.asList("Fahrrad")), "2 Räder, selber treten"),
                new Vocable("to jump", new ArrayList<String>(Arrays.asList("springen")), "Gegeneil von fallen"),
                new Vocable("to fall", new ArrayList<String>(Arrays.asList("fallen")), "Gegenteil von springen"),
                new Vocable("forest", new ArrayList<String>(Arrays.asList("Wald")), "Den ...... vor lauter Bäumen nicht mehr sehen")
        ));
        RequestAlgorithm requestAlgorithm = new RequestAlgorithm(testVocables);
        System.out.println(requestAlgorithm.getNewVocable().getValues().get(0));
        requestAlgorithm.handleAnswer(true);
    }

    public void start(View view) {
        EditText forenameInput = findViewById(R.id.forenameInput);
        String forename = forenameInput.getText().toString();
        //TODO: Save forename in Settings
        Intent intent = new Intent(this, SubjectSelect.class);
        startActivity(intent);
    }
}
