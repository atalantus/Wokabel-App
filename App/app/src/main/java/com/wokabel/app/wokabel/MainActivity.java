package com.wokabel.app.wokabel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wokabel.app.wokabel.Models.Vocable;
import com.wokabel.app.wokabel.request.RequestAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Vocable> testVocables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
