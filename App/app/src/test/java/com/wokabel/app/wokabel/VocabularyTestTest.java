package com.wokabel.app.wokabel;

import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Difficulty.EASY;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Difficulty.HARD;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Difficulty.NOTIME;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Modes.KEY_VALUE;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Modes.RANDOM;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Modes.VALUE_KEY;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VocabularyTestTest {
    
    private ArrayList<Vocable> testVocables;

    @Before
    public void setUp()
    {
        testVocables = new ArrayList<>(Arrays.asList(
            new Vocable("tree", new ArrayList<>(Arrays.asList("Baum")), "Fängt mit B an und existiert im Wald.", "0"),
            new Vocable("car", new ArrayList<>(Arrays.asList("Auto")), "Brum brum", "0"),
            new Vocable("flower", new ArrayList<>(Arrays.asList("Blume")), "Gibts auf Wiese und im Laden", "0"),
            new Vocable("to pay", new ArrayList<>(Arrays.asList("bezahlen")), "Nach dem Kauf ....... man", "0"),
            new Vocable("house", new ArrayList<>(Arrays.asList("Haus")), "Da wohnst du drinnen", "0"),
            new Vocable("cellphone", new ArrayList<>(Arrays.asList("Handy")), "Nutzt du jeden Tag", "0"),
            new Vocable("table", new ArrayList<>(Arrays.asList("Tisch")), "Kann man was draufstellen", "0"),
            new Vocable("bike", new ArrayList<>(Arrays.asList("Fahrrad")), "2 Räder, selber treten", "0"),
            new Vocable("to jump", new ArrayList<>(Arrays.asList("springen")), "Gegeneil von fallen", "0"),
            new Vocable("to fall", new ArrayList<>(Arrays.asList("fallen")), "Gegenteil von springen", "0"),
            new Vocable("forest", new ArrayList<>(Arrays.asList("Wald")), "Den ...... vor lauter Bäumen nicht mehr sehen", "0")
            ));
    }

    @Test
    public void mode_keyValue() {
        // TODO: Key -> Value tests
        VocabularyTest testing = new VocabularyTest(testVocables, VocabularyTest.Modes.KEY_VALUE, VocabularyTest.Difficulty.EASY);
    }

    @Test
    public void mode_valueKey() {
        // TODO: Value -> Key tests
        VocabularyTest testing = new VocabularyTest(testVocables, VocabularyTest.Modes.VALUE_KEY, VocabularyTest.Difficulty.HARD);
    }

    @Test
    public void mode_random() {
        // TODO: Random tests
        VocabularyTest testing = new VocabularyTest(testVocables, VocabularyTest.Modes.RANDOM, VocabularyTest.Difficulty.NOTIME);
    }
}
